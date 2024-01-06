package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer,Node> cache;
    private Node head;
    private Node tail;
    int capacity;
    

    
    public LRUCache(){}
    public LRUCache(int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<Integer,Node>(capacity);
        this.head = null;
        this.tail = null;
    }

    public int get(int key){
        System.out.println();
        System.out.println("Get:"+ key );

        if(!cache.containsKey(key))
            return -1;
        
        Node node = cache.get(key);
        deleteNode(node);
        addToFirst(node);
        return node.value;
    }

    //delete node
    //add node to first
    //delete tail node
    

    private void addToFirst(Node node) {
        if(head == null){
            head = node;
            tail = node;
        }else{
            node.right = head;
            head.left = node;
            head = node ;
        }

    }
    private void deleteNode(Node node) {
        if(node == head){
            head = head.right;
        }
        else if(node == tail){
            tail = tail.left;
            tail.right = null;            
        }else{
            node.left.right = node.right;
            node.right.left = node.left;
        }
    }

    public void put(int key, int value){
        System.out.println();
        System.out.println("Put:" + key + ":" + value);
        
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            cache.remove(key);            
            deleteNode(node);            
        }
        if(cache.size()==capacity){
            cache.remove(tail.key);
            deleteNode(tail);
        }
        Node node = new Node(key, value);
        addToFirst(node);
        cache.put(key, node); 
    }

    public void displayCache(){
        System.out.println();
        System.out.println("Cache:" +cache);
        Node node = head;
        while(node!=null){
            System.out.print(" [ " + node.key + ":" + node.value + " ] " + " -> ");
            node = node.right;
        }
        System.out.println();
    }

    private static class Node{
        int key;
        int value;
        Node left;
        Node right;

        public Node(){}
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String args[]){
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.displayCache();
        lruCache.put(2,2);
        lruCache.displayCache();
        lruCache.get(1);
        lruCache.displayCache();
        lruCache.put(3,3);
        lruCache.displayCache();
        lruCache.get(2);
        lruCache.displayCache();
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
        lruCache.displayCache();        

    }
}
