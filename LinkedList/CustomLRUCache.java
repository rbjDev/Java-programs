package LinkedList;

import java.util.LinkedHashMap;
import java.util.Map;

public class CustomLRUCache {
    LRUCustomCache<Integer,Integer> cache ;

    CustomLRUCache(int capacity){
        cache = new LRUCustomCache<>(capacity);        
    }

    public int get(int key){
        return cache.get(key);
    }

    public void put(int key, int value){
        cache.put(key, value);
    }

    private class LRUCustomCache<K,V> extends LinkedHashMap<K,V>{
        private int CACHE_SIZE ;
    
        LRUCustomCache(int maxSize){
            super(maxSize,0.75f,true);
            this.CACHE_SIZE = maxSize;
        }
    
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> var1) {
          return size() > CACHE_SIZE;
       }
    }
}
