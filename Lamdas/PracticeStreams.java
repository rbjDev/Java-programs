package Lamdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeStreams {
    public static void main(String[] args) {
        int arr[] = {1,5,7,8,9};

        //size of array
        Arrays.stream(arr).count();

        
        //1. Find min,max,avg from an array of int
        System.out.println("Find min:");
        System.out.println(Arrays.stream(arr).min().getAsInt());


        //2. Find duplicates in a list of integers
        System.out.println("Duplicates in a list:");
        int nums[] = { 9, 1, 9, 4, 5, 9, 2, 3, 2, 8, 7, 12, 1 };
        System.out.println(Arrays.stream(nums)
                        .boxed()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(entry -> entry.getValue() > 1)
                        .map(entry -> entry.getKey())
                        .collect(Collectors.toList()));

        //2. Find duplicates in a list of integers (2nd way)
        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(nums)
                    .boxed()
                    .filter(n -> !set.add(n))
                    .forEach(System.out::print);


        //3. Merge two sorted arrays/lists into a single sorted list
        List<Integer> list1 = Arrays.asList(5,16,377,48);
        List<Integer> list2 = Arrays.asList(15,26,47,98);
        Stream.concat(list1.stream(),list2.stream()).sorted().collect(Collectors.toList());

        //4. Merge two sorted arrays/lists into a single sorted list and remove duplicates
        Stream.concat(list1.stream(),list2.stream()).sorted().distinct().collect(Collectors.toList());


        // 5. Find names of 3 highest earning employees (Sort employees based on a specific attribute)
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John dart", 50000, "john@gmail.com", "Accounts"),
                new Employee(2, "Rob dart", 90000, "rob@gmail.com", "IT"),
                new Employee(3, "tony dart", 70000, "tony@gmail.com", "Sales"),
                new Employee(4, "Pony dart", 72000, "pony@gmail.com", "IT"));
        System.out.println("Find names of 3 highest earning employees:");

        employees.stream()
                    .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                    .limit(3)
                    .map(emp->emp.getName())
                    .forEach(System.out::println);

        // 6. Count of employees in each dept
        System.out.println("Count of emp in each dept:");
        employees.stream()
                    .collect(Collectors.groupingBy(emp->emp.getDept(),Collectors.counting()));
                                //OR
        employees.stream()
                    .collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()))
                    .forEach((dept,count) -> System.out.println(dept + ":" + count));
        

        //7. Student Grade classification - 70 and above  is pass

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
                    .collect(Collectors.groupingBy(s -> s.marks>70 ? "Pass" : "Fail",Collectors.counting()))
                    .entrySet()
                    .stream()
                    .forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));


        //8. Given a sentence find the frequency of each word
        String sentence = "This is a good way to start coding ! It is likely to help in future .";
        System.out.println("Frequency of each word:");

        Arrays.stream(sentence.split("\\s+"))
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                        .entrySet()
                        .stream()
                        .forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));

         // 7. Given a sentence find the highest frequency word
         String sentence1 = "This is the best way to start coding ! It is likely to help in the near future .";      
         Arrays.stream(sentence.split("\\s+"))
                    .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                    .entrySet()
                    .stream()
                    .max(Comparator.comparing(Map.Entry::getValue))
                    .map(entry -> entry.getKey())
                    .get();


         // 10. Given a list of names group by their first letter & count no of names in each group
         String names = "Rupam,Aman,Rajiv,Ashish,Biswa,Chethan,Rony";
         System.out.println("\n Freq count by first letter of name:");
         Arrays.stream(names.split(","))
                    .collect(Collectors.groupingBy(
                        name -> name.charAt(0),
                        LinkedHashMap::new,
                        Collectors.counting()
                    ))
                    .entrySet()
                    .stream()
                    .forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));


        //14. Given a string array of sentences use stream api to return distinct list of words that start with #
		 String[] sentences = {
            "Here is a #sample sentence.",
            "This is another #example of a sentence.",
            "#Java streams are powerful.",
            "Find words that start with #."
        };
        System.out.println("Given a string array of sentences use stream api to return distinct list of words that start with #");
        Arrays.stream(sentences)
                .flatMap(sent -> Arrays.stream(sent.split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.toSet())
                .stream()
                .forEach(System.out::println);


        //15. Given a string find highest frequency character
        String word = "eeteees";   
            word.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(entry -> entry.getKey())
                .get();


        //16. Find 3rd most frequent char in string
        String word1 = "eeteeess";   
            word.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .skip(2)
                .findFirst()
                .map(entry -> entry.getKey())
                .get();


        //17 . String s = "asdfaghjklkjhgfdsa".
        // Find the first repeating character in the given string using streams and lambda expression. output - a

        String s = "asdfaghjklkjhgfdsa";
        Set<Character> seen = new HashSet<>();
        s.chars().mapToObj(c -> (char)c)
                    .filter(c -> !seen.add(c))
                    .findFirst()
                    .get();

        //*******************************************HASHMAP BASED QUESTIONS************************* */

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 5);
        map.put("B", 10);
        map.put("C", 15);

        //1. Compute the sum of values in a HashMap<String, Integer>

        int sum = map.values().stream()
                    .mapToInt(Integer::intValue) //The mapToInt(Integer::intValue) method is used to convert the stream of Integer objects to an IntStream. This is necessary because the sum method is available on IntStream.
                    .sum();
        
        

        //2 .Given a HashMap<String, Integer>, filter out entries with values less than 10.

        Map<String,Integer> filteredMap = map.entrySet().stream()
                                                        .filter(entry-> entry.getValue()<10)
                                                        .collect(Collectors.toMap(e->e.getKey(),e->e.getValue()));

                                //OR
                                map.entrySet().stream()
                                .filter(entry-> entry.getValue()<10)
                                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        //2 (a) Count the number of entries with values greater than 10 in a HashMap<String, Integer>.

        long count = map.values().stream()
                                .filter(value -> value>10)
                                .count();
        System.out.println("Count the number of entries with values greater than 10 : " + count);

        //3. Given a HashMap<String, Integer>, double the values of all entries.
        System.out.println("Given a HashMap<String, Integer>, double the values of all entries.");
        Map<String,Integer> doubledMap = map.entrySet().stream()                                
                                .collect(Collectors.toMap(e->e.getKey(),e->2 * e.getValue()));
        doubledMap.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));

        //4. Find the entry with the maximum value in a HashMap<String, Integer>.
        System.out.println("Find the entry with the maximum value in a HashMap<String, Integer>.");
        String key = map.entrySet().stream()
                        .max(Comparator.comparingInt(Map.Entry::getValue))
                        .map(entry->entry.getKey())
                        .get();
        System.out.println("Max value's key" + key);

        //5. Convert all keys of a HashMap<String, Integer> to a List<String>.
        System.out.println("Convert all keys of a HashMap<String, Integer> to a List<String>.");
        List<String> keysList = map.entrySet().stream()
                                                .map(Map.Entry::getKey)
                                                .collect(Collectors.toList());
        System.out.println("Keys list: " + keysList );


       //6. Group entries of a HashMap<String, Integer> by the length of the keys.
       Map<String, Integer> map1 = new HashMap<>();
       map1.put("apple", 10);
       map1.put("banana", 20);
       map1.put("cherry", 30);
       map1.put("date", 40);
       map1.put("fig", 50);
       map1.put("grape", 60);

       System.out.println("Group entries of a HashMap<String, Integer> by the length of the keys.");
       Map<Integer,List<Map.Entry<String,Integer>>> groupedMap = map1.entrySet().stream()
                    .collect(Collectors.groupingBy(entry -> entry.getKey().length()));

        groupedMap.forEach((length,entries) ->{
            System.out.print("Length :" + length);
            entries.forEach(entry -> System.out.print(" " + entry.getKey() + ":" + entry.getValue() + " , "));
            System.out.println();
        });

        //7. Sort a HashMap<String, Integer> by its values and collect it into a new LinkedHashMap.
        System.out.println("Sort a HashMap<String, Integer> by its values and collect it into a new LinkedHashMap.");
        Map<String,Integer> sortedMap = map1.entrySet().stream()
                                                        .sorted(Comparator.comparingInt(Map.Entry::getValue))// .sorted(Map.Entry.comparingByValue())
                                                        .collect(Collectors.toMap(
                                                            Map.Entry::getKey, //The key mapper.
                                                            Map.Entry::getValue, // The value mapper.
                                                            (e1,e2) -> e1, // A merge function to handle key collisions (not needed in this case, but required by the method signature).
                                                            LinkedHashMap::new // A supplier providing a new LinkedHashMap instance.
                                                        ));
       //8. Merge two HashMap<String, Integer> instances, summing the values of common keys.   
       System.out.println("Merge two HashMap<String, Integer> instances, summing the values of common keys.");  

       Map<String, Integer> mapA = new HashMap<>();
        mapA.put("apple", 10);
        mapA.put("banana", 20);
        mapA.put("cherry", 30);

       Map<String, Integer> mapB = new HashMap<>();
        mapB.put("banana", 15);
        mapB.put("date", 25);
        mapB.put("apple", 5);

        Map<String,Integer> mergedMap = Stream.concat(mapA.entrySet().stream(), mapB.entrySet().stream())
                                        .collect(Collectors.toMap(
                                            Map.Entry::getKey,
                                            Map.Entry::getValue,
                                            (e1,e2) -> e1+e2
                                        ));
        mergedMap.forEach((k,v) -> System.out.println(k + ":" + v));

        //9. Flatten all lists from a HashMap<String, List<Integer>> to a single List<Integer>.
        Map<String, List<Integer>> listMap = new HashMap<>();
        listMap.put("a", Arrays.asList(1, 2, 3));
        listMap.put("b", Arrays.asList(4, 5));
        listMap.put("c", Arrays.asList(6, 7, 8, 9));

        listMap.values().stream()
                        .flatMap(list -> list.stream()) //The flatMap(List::stream) method is used to flatten the stream of lists into a single stream of integers
                        .collect(Collectors.toList());


        /*********************FlatMap examples */                        
        //Given a List<List<Integer>>, how would you flatten it into a single List<Integer> using Streams?
        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1,9,4),Arrays.asList(11,19,14),Arrays.asList(12,29,24));

        listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());



    }
}
