package Multithreading;

public class DaemonThreadDemo extends Thread{
    public void run(){
        int i = 1;
        while(true){
            System.out.println("Daemon thread executing :"+ i);
            i++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
    public static void main(String args[]) throws InterruptedException{
        DaemonThreadDemo d1 = new DaemonThreadDemo();
        d1.setDaemon(true);
        d1.start();
        System.out.println("Main thread going to sleep!!");
        Thread.sleep(2000);
        System.out.println("Main thread finishing!");
    }
    
}
