package MultiThreadingPractice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsSyncDemo {

    public static void main(String[] args) {
        //1. Collections.synchronizedList
        List<Integer> list = new ArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(list);

        //2. Collections.synchronizedSet
        Set<String> set = new HashSet<>();
        Set<String> syncSet = Collections.synchronizedSet(set);

        //3. Collections.synchronizedMap
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> synchronizedMap = Collections.synchronizedMap(map);

        //Collections.synchronizedCollection
        Collection<String> collection = new ArrayList<>();
        Collection<String> synchronizedCollection = Collections.synchronizedCollection(collection);

    }
}
