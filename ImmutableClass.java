import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/***
 * How to make a class immutable?
 * 1. Donot provide setter methods that modify fields or objects referred to by fields
 * 2. Make all fields private and final - Fields declared private will not be accessible outside class and declaring them final will prevent them from getting modified accidentally.
 * 3. Do-not allow subclasses to override methods - decalre the class as final.
 * 4. Special attention when having mutable instance variables- Integer, Double,String are all immutable classes.
 * For all mutable objects return a copy of the original object (deep cloning).
 * 
 * A more sophisticated approach would be to make the constructor private and construct instances using factory methods
 */

public final class ImmutableClass {
     /**
  * String class is immutable as it also does not provide setter to change its content
  * */
    private final String name;
    /**
  * Integer class is immutable as it does not provide any setter to change its content
  * */
    private final Integer id;
    /**
  * ArrayList class is mutable as it provide setters to change various date/time parts
  * */
    private final ArrayList<String> list;

    private final HashMap<String, String> map;

    //Default private constructor will ensure no unplanned construction of class
    private ImmutableClass(String n, Integer id, ArrayList<String> l,HashMap<String,String> m){
        this.name = n;
        this.id = id;
        this.list = new ArrayList<String>(l);
        this.map = new HashMap<>(m);
    }
    
    //Factory method to store object creation logic in single place
    public static ImmutableClass getNewInstance(String n, Integer id, ArrayList<String> l, HashMap<String,String> m){
        return new ImmutableClass(n, id, l,m);
    }

    public String getName(){
        return this.name;
    }

     /**
  * Integer class is immutable so we can return the instance variable as it is
  * */
    public Integer getId(){
        return this.id;
    }
    /**
  * ArrayList class is mutable so we need a little care here.
  * We should not return the reference of original instance variable.
  * Instead a new Date object, with content copied to it, should be returned.
  * */
    public ArrayList getList(){
        return new ArrayList<String>(this.list);
    }

    @Override
    public String toString(){
        return name + "_" + id + "_" + list.toString() + "_" + map;
    }

    public static void main(String args[]){
        ArrayList<String> l = new ArrayList<String>(Arrays.asList("Apple","Banana"));
        ImmutableClass im = ImmutableClass.getNewInstance("Ravi", 15, l , new HashMap<String,String>());
        System.out.println(im);
        Integer id = im.getId();
        id = 55;
        List<String> list = im.getList();
        list = Arrays.asList("new","contents");
        System.out.println(im);



    }



}
