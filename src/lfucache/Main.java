package lfucache;

public class Main {
    public static void main(String[] args) {
        LFUCache<Integer, Integer> cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        cache.put(5, 5);
    }
}
