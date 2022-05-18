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
            Random rand = new Random(1000);
            while(true){
                try {
                    queue.put(new Item(rand.nextInt(),"Milo"));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }               
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();

        final Runnable consumer = () -> {
            Random rand = new Random(1000);
            while(true){
                try {
                    Item i = queue.take();
                    System.out.println(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(consumer).start();
        new Thread(consumer).start();

        Thread.sleep(2000);

        Runnable prod = new Runnable(){
            public void run(){
                System.out.println("Run method called!");
            }
        };

        Runnable cons = () -> {
            System.out.println("Run method called!!");
        };

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