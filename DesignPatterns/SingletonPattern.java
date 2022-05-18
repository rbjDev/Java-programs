package DesignPatterns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonPattern implements Serializable {
    private static SingletonPattern soleInstance=null;

    private SingletonPattern(){  
        System.out.println("Private constructor called!!");     
    }

    public static synchronized SingletonPattern getInstance(){
        if(soleInstance==null){
            soleInstance= new SingletonPattern();
        }
        return soleInstance;
    }

    public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException{
        SingletonPattern obj1 = SingletonPattern.getInstance();
        SingletonPattern obj2 = SingletonPattern.getInstance();
        SingletonPattern objT = new SingletonPattern();
        System.out.println(obj1==obj2);
        System.out.println("obj1:"+ obj1);
        System.out.println("objT:"+ objT);

        //Ways to break Singleton design pattern:
        //Serialization
        ObjectOutputStream ostream = new ObjectOutputStream(new FileOutputStream("abc.txt"));
        ostream.writeObject(obj1);

        ObjectInputStream iStream = new ObjectInputStream(new FileInputStream("abc.txt"));
        SingletonPattern obj3 =(SingletonPattern) iStream.readObject();

        System.out.println("Obj3:"+ obj3);
    }

}
