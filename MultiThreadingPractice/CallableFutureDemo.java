package MultiThreadingPractice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureDemo {

    public static void main(String[] args)  {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<String> task = ()->{
            System.out.println("Executing Task by " + Thread.currentThread().getName());
            // Simulate some computation
            Thread.sleep(2000);
            return "Task completed!!";
        };
        // Submit the Callable task to the executor
        Future<String> future = executor.submit(task);        
        try{
            // Perform some other operations while the task is being executed
            System.out.println("Performing some other operations...");
            String result = future.get();
            System.out.println("Result of task:" + result);
        }
        catch(InterruptedException | ExecutionException e){
            e.printStackTrace();
        }        
        finally{
            executor.shutdown();
        }

    }
}
