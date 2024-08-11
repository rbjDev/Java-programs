package Lamdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsQuestions {
    public static void main(String[] args) {

        //Array to list

        int array[] = {1,5,7,8};
        List<Integer> arrayList = IntStream.of(array)
                                            .boxed()
                                            .collect(Collectors.toList());
        
        //Create a list on the go
        List<Integer> arrayList1 = Arrays.asList(1,4,5,6);
        List<String> stringList = Arrays.asList("tom","dick","harry","mojo");


        // 1. Find min,max,count,sum,average of a list of integers

        int arr[] = { 1, 5, 9, 5, 20 };
        System.out.println(IntStream.of(arr).min().getAsInt());
        IntStream.of(arr)
                .max()
                .ifPresent(System.out::println);

        // 2. Find names of 3 highest earning employees (Sort employees based on a
        // specific attribute)
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John dart", 50000, "john@gmail.com", "Accounts"),
                new Employee(2, "Rob dart", 90000, "rob@gmail.com", "IT"),
                new Employee(3, "tony dart", 70000, "tony@gmail.com", "Sales"),
                new Employee(4, "Pony dart", 72000, "pony@gmail.com", "IT"));
        System.out.println("Find names of 3 highest earning employees:");
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .limit(3)
                .map(Employee::getName)
                .forEach(System.out::println);

        // 3. COunt of employees in each dept
        System.out.println("Count of emp in each dept:");
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()))
                .forEach((dept, count) -> System.out.println("Name:" + dept + " , " + "Count:" + count));

        // 4. Find duplicates in a list of integers
        System.out.println("Duplicates in a list:");
        int nums[] = { 9, 1, 9, 4, 5, 9, 2, 3, 2, 8, 7, 12, 1 };
        Set<Integer> seen = new HashSet<>();
        Arrays.stream(nums)
                .boxed()
                .filter(n -> !seen.add(n)) // Add to set, return false if already present
                .forEach(System.out::println);

        // 4. Find duplicates in a list of integers 2nd way
        System.out.println("Duplicates in a list 2nd way:");
        Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey()));

        // 5. Find duplicates in a list of integers using Stream
        int arr1[] = { 4, 6, 9, 2, 4, 9, 5, 2, 4 };
        List<Integer> list = IntStream.of(arr1).boxed().collect(Collectors.toList());
        list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        // 6. Given a sentence find the frequency of each word
        String sentence = "This is a good way to start coding ! It is likely to help in future .";
        System.out.println("Frequency of each word:");
        Stream.of(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));

        Map<String, Long> map = Stream.of(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // 7. Given a sentence find the highest frequency word
        String sentence1 = "This is the best way to start coding ! It is likely to help in the near future .";        

        String highestFreq = Stream.of(sentence1.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(entry ->entry.getKey()).get()
                ;

        System.out.println("\n\n Highest frequency word:" + highestFreq);

        //8. Given a string find highest frequency character
        String word = "eeteees";   
        Character mostfreqChar = word.chars()
            .mapToObj(c -> (char)c)
            .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
            .entrySet()
            .stream()
            .max(Comparator.comparing(Map.Entry::getValue))
            .map(entry->entry.getKey())
            .orElse(null);
        System.out.println("\n Most frequent char: " + mostfreqChar);

        //9. Find 3rd most frequent char in string
        String word1 = "eeteeess";   
         Optional<Character> thirdMostFrequentChar = word1.chars()  // Convert to IntStream
            .mapToObj(c -> (char) c)  // Convert IntStream to Stream<Character>
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))  // Create a frequency map
            .entrySet().stream()  // Convert the map to a stream
            .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())  // Sort by frequency in descending order
            .skip(2)  // Skip the first 2 entries
            .findFirst()  // Get the third entry
            .map(Map.Entry::getKey);  // Get the character from the entry
        System.out.println("\n Third Most frequent char: " + thirdMostFrequentChar);

        // 10. Given a list of names group by their first letter & count no of names in each group
        String names = "Rupam,Aman,Rajiv,Ashish,Biswa,Chethan,Rony";
        System.out.println("\n Freq count by first letter of name:");
        Stream.of(names.split(","))
                .collect(Collectors.groupingBy(
                    s->s.charAt(0),
                    LinkedHashMap::new,   //to maintain order
                    Collectors.counting()))
                .entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));


        //11. Student Grade classification - 70 and above  is pass

        class Student{
            String name;
            int marks;
            public Student(String name, int marks) {
                this.name = name;
                this.marks = marks;
            }
            @Override
            public String toString() {
                return "Student [name=" + name + ", marks=" + marks + "]";
            }
            
            
        }

       // List<Integer> numbers = Arrays.asList(5,6,7,8);

        List<Student> students = Arrays.asList(
                                    new Student("Raj", 90),
                                    new Student("Taj", 50),
                                    new Student("Paj", 60),
                                    new Student("Baj", 80),
                                    new Student("Maj", 98)
        );

        System.out.println("\n Student Grade classification - 70 and above  is pass \n");
        students.stream()
                    .collect(Collectors.groupingBy(s -> s.marks >=70 ? "Pass" : "fail"))
                    .entrySet()
                    .stream()
                    .forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));

    //12. Merge two sorted arrays/lists into a single sorted list
    List<Integer> list1 = Arrays.asList(5,16,377,48);
    List<Integer> list2 = Arrays.asList(15,26,47,98);
    Stream.concat(list1.stream(), list2.stream())
                                         .sorted()
                                         .collect(Collectors.toList());

    ////13. Merge two sorted arrays/lists into a single sorted list and remove duplicates
    Stream.concat(list1.stream(), list2.stream())
                                         .sorted()
                                         .distinct()
                                         .collect(Collectors.toList());



    }
}
