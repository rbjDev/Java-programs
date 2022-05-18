package Multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo  {

    public static void main(String args[]) throws InterruptedException, ExecutionException{
        Sum[] sums = { new Sum(10), new Sum(20),
            new Sum(30), new Sum(40),
            new Sum(50), new Sum(60)
        };

        ExecutorService service = Executors.newFixedThreadPool(3);
        // for(Sum s:sums){
        //     Future r=service.submit(s);
        //     System.out.println("Sum:"+ r.get());
        // }

        Runnable r1= ()->{
            int num=15;
            System.out.println(Thread.currentThread().getName() + " is responsible to get sum of first " + num + " integers");
            int sum=0;
            for(int i=1;i<=num;i++){
                sum+= i;
            }
            System.out.println("Sum: "+ sum);

        };

        Runnable r2= ()->{
            int num =10;
            System.out.println(Thread.currentThread().getName() + " is responsible to get sum of first " + num + " integers");
            int sum=0;
            for(int i=1;i<=num;i++){
                sum+= i;
            }
            System.out.println("Sum: "+ sum);

        };

        service.submit(r1);
        service.shutdown();
    }
    

    
    
}

class Sum implements Callable{
    int num;
    Sum(int n){
        this.num = n;
    }
    public Object call() throws Exception{
        System.out.println(Thread.currentThread().getName() + " is responsible to get sum of first " + num + " integers");
        int sum=0;
        for(int i=1;i<=num;i++){
            sum+= i;
        }
        return sum;
    }
}


