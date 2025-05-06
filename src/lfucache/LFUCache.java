package lfucache;

import java.util.HashMap;

public class LFUCache<K, V> {
    private final int capacity;
    private int minFreq;
    private final HashMap<K, Node<K, V>> cache;
    private final HashMap<Integer, DoublyLinkedList<K, V>> freqList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqList = new HashMap<>();
    }

    public V get(K key) {
        if (!cache.containsKey(key)) return null;
        Node<K, V> node = cache.get(key);
        updateFrequency(node);
        return node.value;
    }

    public void put(K key, V value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            Node<K, V> node = cache.get(key);
            node.value = value;
            updateFrequency(node);
        } else {
            if (cache.size() == capacity) {
                DoublyLinkedList<K, V> minFreqList = freqList.get(minFreq);
                if (minFreqList != null) {
                    Node<K, V> nodeToRemove = minFreqList.removeLast();
                    if (nodeToRemove != null) {
                        cache.remove(nodeToRemove.key);
                    }
                }
            }

            Node<K, V> newNode = new Node<>(key, value);
            cache.put(key, newNode);
            freqList.computeIfAbsent(1, k -> new DoublyLinkedList<>()).addFirst(newNode);
            minFreq = 1;
        }
    }

    private void updateFrequency(Node<K, V> node) {
        int freq = node.freq;
        DoublyLinkedList<K, V> oldList = freqList.get(freq);

        if (oldList != null) {
            oldList.remove(node);
            if (freq == minFreq && oldList.isEmpty()) {
                minFreq++;
            }
        }

        node.freq++;
        freqList.computeIfAbsent(node.freq, k -> new DoublyLinkedList<>()).addFirst(node);
    }
}
