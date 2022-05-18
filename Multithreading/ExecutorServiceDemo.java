package Multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    public static void main(String args[]){
        PrintJob[] jobs = { new PrintJob("Raj"),new PrintJob("Ramesh"),
                            new PrintJob("Tarun"),new PrintJob("Daya"),
                            new PrintJob("Varun"),new PrintJob("Ali"),
        };
        ExecutorService service = Executors.newFixedThreadPool(3);

        List<PrintJob> jobList = new ArrayList<>(Arrays.asList(jobs));
        jobList.stream().forEach(j->service.submit(j));
        
        // for(PrintJob job: jobs){
        //     service.submit(job);
        // }

        
        service.shutdown();
    }
}

class PrintJob implements Runnable{
    String name;

    PrintJob(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name +"-- Print job started by thread: "+ Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Print job finished by thread:" + Thread.currentThread().getName());
        
    }

}
