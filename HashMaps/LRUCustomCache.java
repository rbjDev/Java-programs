package HashMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LRUCustomCache<K,V> extends LinkedHashMap<K,V>{
    private int CACHE_SIZE ;

    LRUCustomCache(int maxSize){
        super(maxSize,0.75f,true);
        this.CACHE_SIZE = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> var1) {
      return size() > CACHE_SIZE;
   }

   public static void main(String[] args) {
        LRUCustomCache<Integer,String> cache = new LRUCustomCache<>(4);
        
        for(int i=1 ; i<6; i++){
            cache.put(i,"*" + i + "*");
            System.out.println(cache);
        }
   }
}
