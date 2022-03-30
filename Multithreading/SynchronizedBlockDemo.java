package Multithreading;

public class SynchronizedBlockDemo {
    
    public static void main(String[] args){
        PowerTable1 p1 = new PowerTable1();
        PowerTable1 p2= new PowerTable1();
        Thread11 t1 = new Thread11(5,p1);
        Thread22 t2 = new Thread22(7,p2);
        //Threads t1 and t2 are accessing the separate PowerTable objects   
        t1.start(); 
        t2.start();
    }    
}

class Thread11 extends Thread{
    PowerTable1 p;  
    int n;      
    public Thread11(int n,PowerTable1 p) {
        this.p = p;
        this.n = n;
    }
    public void run(){
        this.p.power(n);
    }
}

class Thread22 extends Thread{
    int n;
    PowerTable1 p;
    Thread22(int n,PowerTable1 p){
        this.n = n;
        this.p = p;
    }
    public void run(){
        p.power(n);
    }
}

class PowerTable1{      
    public void power(int p){
        int temp =1;
        synchronized(PowerTable1.class){
            for(int i=1;i<=3;i++){
                System.out.println(Thread.currentThread().getName() + ":- " + p + "^"+ i + " value: " + p*temp);
                temp*= p;
                try{
                    Thread.currentThread().sleep(5000);
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

