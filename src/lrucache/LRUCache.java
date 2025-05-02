package lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache <K, V> {
    private final int capacity;
    private Node<K, V> head;
    private Node<K, V> tail;
    private final Map<K, Node<K, V>> cache;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }
    public V get(K key) {
        Node<K, V> node = cache.get(key);
        if (node == null) {
            return null;
        }
        modeToHead(node);
        return node.value;
    }
    public void put(K key, V value) {
        Node<K, V> node = cache.get(key);
        if (node != null) {
             node.value = value;
             modeToHead(node);
        }else{
            node= new Node<>(key, value);
            cache.put(key, node);
            addToHead(node);
            if(cache.size() > capacity){
                Node<K, V> removedNode=removeTail();
                cache.remove(removedNode.key);
            }
        }
    }
    private void addToHead(Node<K, V> node) {
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }

    private void removeNode(Node<K, V> node) {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    private void modeToHead(Node<K, V> node) {
        removeNode(node);
        addToHead(node);
    }
    private Node<K,V> removeTail()
    {
        Node<K, V> node = tail.prev;
        removeNode(node);
        return node;
    }
}
