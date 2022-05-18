import java.util.*;
public class ArrayListExample {
    public static void main(String args[]){
        // ArrayList<String> names = new ArrayList<String>();
        // names.add("Messi");
        // names.add("Ronaldo");
        // names.add("Zlatan");
        // //Iterate in forward
        // Iterator<String> iterator = names.iterator();
        // while(iterator.hasNext()){
        //     System.out.println(iterator.next());
        // }

        //Remove while traversing
        List<Integer> numbers = new ArrayList<>();
        numbers.add(13);
        numbers.add(18);
        numbers.add(25);
        numbers.add(40);
        

        Iterator<Integer> numbersIterator = numbers.iterator();
        while (numbersIterator.hasNext()) {
            Integer num = numbersIterator.next();
            if(num % 2 != 0) {
                numbersIterator.remove();//remove odd numbers
            }
        }

        System.out.println(numbers);
    }

}

