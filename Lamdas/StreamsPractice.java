package Lamdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
//https://www.youtube.com/watch?v=N3gQdIn90CI&list=PLhfHPmPYPPRmwlUqOv4eDhMOF6IUXCWDJ 
//Channel : Defog Tech
public class StreamsPractice {
    public static void main(String[] args) {
        int arr[] = {1,5,9,5,20};
        System.out.println(IntStream.of(arr).min().getAsInt());
        IntStream.of(arr)
                .max()
                .ifPresent(System.out::println);

        

        // Check if any number is even
        boolean anyNumberIsEven = IntStream.of(arr).anyMatch(num -> num % 2 == 0);

        //get distinct smallest 3 numbers
        IntStream.of(Arrays.copyOf(arr, arr.length))
                .distinct()
                .sorted()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("Print even nos:");
        IntStream.rangeClosed(1,10)
                .filter(x->x%2==0)
                .forEach(System.out::println);

        /*
         * 1. Stream create
         * 2. Stream process
         * 3. Stream consume
         */

        /*
        1. Stream create
        */
        IntStream.of(arr);
        IntStream.range(1,101);
        IntStream.rangeClosed(1,100);

        Random random = new Random();
        
        // Generate an infinite stream of random integers
        IntStream randomInts = IntStream.generate(random::nextInt);

        /**
         * 2. Stream process
         */
        
        IntStream.of(arr).sorted();
        IntStream.of(arr).distinct();
        IntStream.of(arr).limit(5);
        IntStream.of(arr).skip(4);
        IntStream.of(arr).filter(num -> num%2==0);
        IntStream.of(arr).map(num -> num*2);
        IntStream.of(arr).boxed();

        /**
         * 3. Consume Stream
         */
        IntStream.of(arr).min();
        IntStream.of(arr).max();
        IntStream.of(arr).sum();
        IntStream.of(arr).average().ifPresent(System.out::println);
        IntStream.of(arr).count();
        
        IntStream.of(arr).toArray();
        IntStream.of(arr).boxed().collect(Collectors.toList());

        IntStream.of(arr).allMatch(x -> x%2 ==0);
        IntStream.of(arr).anyMatch(x -> x%2 ==0);

        List<Employee> employees = Arrays.asList(
            new Employee(1,"John dart",50000,"john@gmail.com","Accounts"),
            new Employee(2,"Rob dart",90000,"rob@gmail.com","IT"),
            new Employee(3,"tony dart",70000,"tony@gmail.com","Sales"),
            new Employee(4,"Pony dart",72000,"pony@gmail.com","IT")
    );

    

        List<Employee> employees2 = new ArrayList<>(employees);
       // Collections.sort(employees2, (e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
    //    Collections.sort(employees2, new Comparator<Employee>() {

    //     @Override
    //     public int compare(Employee o1, Employee o2) {
    //        return o1.getName().compareTo(o2.getName());
    //     }
        
    //    });

        Collections.sort(employees2, new EmpSalaryCompare());

        
        System.out.println("Employees 2:" + employees2);

        employees.stream()
                    .sorted(Comparator.reverseOrder())
                    .map(Employee ::getName)
                    .forEach(System.out::println);

        employees.stream()
                    .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                    .map(Employee::getEmail)
                    .forEach(System.out::println);
        System.out.println("Test------------------------------------");
        employees.stream()
                    .sorted(new Comparator<Employee>() {

                        @Override
                        public int compare(Employee o1, Employee o2) {
                           return o1.getName().compareTo(o2.getName());
                        }
                        
                       })
                    .map(Employee::getEmail)
                    .forEach(System.out::println);

        System.out.println("Test------------------------------------");
        employees.stream()
                    .sorted((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()))
                    .map(Employee::getEmail)
                    .forEach(System.out::println);

                    int numOfThreads = Runtime.getRuntime().availableProcessors();
                    System.out.println("Number of threads used by parallel stream: " + numOfThreads);


        /**
         * Collectors
         * 1. .collect
         */

         employees.stream()
                    .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                    .map(Employee::getEmail)
                    .collect(Collectors.toList());

    
        employees.stream()
                    .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                    .map(Employee::getEmail)
                    .collect(Collectors.toSet());

        employees.stream()
                    .sorted(Comparator.comparingInt(Employee::getSalary).reversed())                   
                    .collect(Collectors.toMap(Employee::getName, Employee::getEmail))
                    .forEach((name,email)-> System.out.println("Name:" + name + " , " + "Email:" + email ));

        
        employees.stream()
                    .sorted(Comparator.comparingInt(Employee::getSalary).reversed())                   
                    .collect(Collectors.groupingBy(Employee::getDept))
                    .forEach((dept,emp)-> System.out.println("Name:" + dept + " , " + "Employee:" + emp ));

        System.out.println("Count of emp in each dept:");
        employees.stream()
                    .sorted(Comparator.comparingInt(Employee::getSalary).reversed())                   
                    .collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()))
                    .forEach((dept,count)-> System.out.println("Name:" + dept + " , " + "Count:" + count ));

        //Handling Duplicate Keys
        //If the stream contains elements with duplicate keys, Collectors.toMap will throw an IllegalStateException. 
        //To handle this, you can provide a merge function to resolve the conflict:

        employees.stream()
        .sorted(Comparator.comparingInt(Employee::getSalary).reversed())                   
        .collect(Collectors.toMap(
            Employee::getName,
            Employee::getEmail,
            (existing,replacement) -> existing + ',' + replacement,
            LinkedHashMap::new)) //LinkedHashMap maintains insertion order
        .forEach((name,email)-> System.out.println("Name:" + name + " , " + "Email:" + email ));


        String dummy = "This is a dummy string";
        Stream<String> myStream = Stream.of("abc","bcd","pqr","abc","pqr","pqr");
        //myStream.distinct().forEach(System.out::println); 
        String max = myStream.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .get();
        System.out.println("Max:" + max );

            
        

        
    }
}
