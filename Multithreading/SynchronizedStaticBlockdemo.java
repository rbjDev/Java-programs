package Multithreading;

public class SynchronizedStaticBlockdemo {
    
    public static void main(String[] args){
        PowerTable p1 = new PowerTable();
        PowerTable p2= new PowerTable();
        Thread1 t1 = new Thread1(p1);
        Thread2 t2 = new Thread2(p2);
        //Threads t1 and t2 are accessing the separate PowerTable objects   
        t1.start(); 
        t2.start();
    }    
}

class Thread1 extends Thread{
    PowerTable p;        
    public Thread1(PowerTable p) {
        this.p = p;
    }
    public void run(){
        p.power(5);
    }
}

class Thread2 extends Thread{
    PowerTable p;
    Thread2(PowerTable p){
        this.p = p;
    }
    public void run(){
        p.power(7);
    }
}

class PowerTable{      
    public void power(int p){
        int temp =1;
        synchronized(PowerTable.class){
            for(int i=1;i<5;i++){
                System.out.println(Thread.currentThread().getName() + ":- " + p + "^"+ i + " value: " + p*temp);
                temp*= p;
                try{
                    Thread.currentThread().sleep(2000);
                }
                catch(InterruptedException e){
                }
            }
        }
        
    }
    public void print(){
        System.out.println("Hello from:"+ Thread.currentThread().getName());
    }

}
