package Multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * https://www.youtube.com/watch?v=UOr9kMCCa5g
 */
public class ProducerConsumerBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException{
        BlockingQueue<Item> queue = new ArrayBlockingQueue<>(10);
        
        //Producer
        final Runnable producer = () -> {
            Random rand = new Random();
            while(true){
                try {
                    int itemNo = rand.nextInt(1000);
                    System.out.println("New item produced: " + itemNo);
                    queue.put(new Item(itemNo,"Milo"));
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }               
            }
        };

        //3 Producer threads producing items
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();

        final Runnable consumer = () -> {            
            while(true){
                try {
                    Item i = queue.take();
                    System.out.println("Item consumed:" + i.id);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        //Two consumer threads consuming items
        new Thread(consumer).start();
        new Thread(consumer).start();

       

        
    }
    
}

class Item{
    int id;
    String name;
    public Item(int id, String name){
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + "]";
    }
}