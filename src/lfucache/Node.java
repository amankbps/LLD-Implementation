package lfucache;

public class Node <K,V>{
    public int freq;
    K key;
    V value;
    Node<K,V> next;
    Node<K,V> prev;
    public Node(K key, V value){
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}
