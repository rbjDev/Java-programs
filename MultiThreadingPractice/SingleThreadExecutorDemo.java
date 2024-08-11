package MultiThreadingPractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for(int i=0; i<10; i++){
            service.execute(new Task(i));
        }
        service.shutdown();        
    }
}

class Task implements Runnable{

    int taskId;

    public Task(int taskId){
        this.taskId = taskId;
    }

    @Override
    public void run() {
       System.out.println("Task with id:" + taskId + " being executed by thread: " + Thread.currentThread().getName());
       try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    System.out.println("Task with id:" + taskId + " completed execution by thread: " + Thread.currentThread().getName());
        
    }
    
}
