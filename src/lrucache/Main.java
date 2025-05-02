package lrucache;

public class Main {


    public static void main(String[] args) {
        LRUCache<Integer, String> cache=new LRUCache<>(3);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

        cache.put(4, "four");
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

        cache.put(2, "updated 2");
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
