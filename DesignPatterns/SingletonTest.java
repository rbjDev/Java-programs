package DesignPatterns;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonTest {
    public static void main(String args[]) throws Exception{
        SingletonPattern obj1 = SingletonPattern.getInstance();
        SingletonPattern obj2 = SingletonPattern.getInstance();
       // SingletonPattern objT = new SingletonPattern();
        System.out.println(obj1==obj2);
        System.out.println("obj1:"+ obj1);
        //System.out.println("objT:"+ objT);

         //Ways to break Singleton design pattern:
        //Serialization
        ObjectOutputStream ostream = new ObjectOutputStream(new FileOutputStream("abc.txt"));
        ostream.writeObject(obj1);

        ObjectInputStream iStream = new ObjectInputStream(new FileInputStream("abc.txt"));
        SingletonPattern obj3 =(SingletonPattern) iStream.readObject();

        System.out.println("Obj3:"+ obj3);

         //Ways to break Singleton design pattern:
        //Multithreading
        System.out.println("Multi-threading using ExecutorService:");
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(()->{
            SingletonPattern obj = SingletonPattern.getInstance();
            System.out.println(obj);
        });
        service.submit(()->{
            SingletonPattern obj = SingletonPattern.getInstance();
            System.out.println(obj);
        });

        service.shutdown();


    }
}
