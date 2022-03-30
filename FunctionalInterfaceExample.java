import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

interface functionalInterface{
    void abstractSquare(int x);
}
public class FunctionalInterfaceExample {
    public static void main(String args[]){
        functionalInterface fobj = (x) -> System.out.println(x*x);
        fobj.abstractSquare(5);
        
        Collection<Integer> list = Arrays.asList(5,6,7,8,9);
        Integer s = list.stream().filter(x->x%2==0).map(x->x*x).reduce(0, Integer::sum);
        Integer sr = list.stream().filter(x->x%2==0).map(x->x*x).reduce(0,(x,y)->x+y);
    }
    
}
