package MultiThreadingPractice;


class Counter{
    private int count;
    public Counter(){
        count = 0;
    }
    public synchronized void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }
}

class StaticCounter{
    private static int count = 0;

    public synchronized static void increment(){
        count++;
    }

    public static int getCount(){
        return count;
    }

}


public class SynchronizedExample {

    public static void main(String[] args) throws InterruptedException {
        // Counter counter  = new Counter();
        // Thread t1 = new Thread(()->{
        //     for(int i=0; i<5; i++){
        //         counter.increment();
        //     }
        // });

        // Thread t2 = new Thread(()->{
        //     for(int i=0; i<5; i++){
        //         counter.increment();
        //     }
        // });

        // t1.start();
        // t2.start();

        // t1.join();
        // t2.join();

        // System.out.println("Final count: " + counter.getCount());


        StaticCounter staticCounter = new StaticCounter();

        Thread t3 = new Thread(()->{
            for(int i=0; i<5; i++){
                StaticCounter.increment();
            }
        });

        Thread t4 = new Thread(()->{
            for(int i=0; i<5; i++){
                StaticCounter.increment();
            }
        });

        t3.start();
        t4.start();

        t3.join();
        t4.join();
        System.out.println("Final count: " + StaticCounter.getCount());
    }
}
