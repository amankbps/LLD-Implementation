package lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache <K, V> {
    private final int capacity;
    private DoublyLinkedList<K,V>list;
    private final Map<K, Node<K, V>> cache;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        list = new DoublyLinkedList<>();
    }
    public V get(K key) {
        Node<K, V> node = cache.get(key);
        if (node == null) {
            return null;
        }
        list.remove(node);
        list.addFirst(node);
        return node.value;
    }
    public void put(K key, V value) {
        Node<K, V> node = cache.get(key);
        if (node != null) {
             node.value = value;
             list.remove(node);
             list.addFirst(node);
        }else{
            node= new Node<>(key, value);
            cache.put(key, node);
            list.addFirst(node);
            if(cache.size() > capacity){
                Node<K, V> removedNode=list.removeLast();
                cache.remove(removedNode.key);
            }
        }
    }

}
