import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JavaSorting {
    static class Employee implements Comparable<Employee>{
        int id;
        String name;
        int age;
        int exp;
        public Employee(int id, String name, int age, int exp) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.exp = exp;
        }
        @Override
        public int compareTo(Employee o) {
            return this.name.compareTo(o.name);
        }
        @Override
        public String toString() {
            return "Employee [age=" + age + ", exp=" + exp + ", id=" + id + ", name=" + name + "]";
        }        
    }

    static class EmployeeExpComparator implements Comparator<Employee>{

        @Override
        public int compare(JavaSorting.Employee o1, JavaSorting.Employee o2) {
            // TODO Auto-generated method stub
            return Integer.compare(o1.exp, o2.exp);
        }

    }

    public static void main(String args[]){
        List<Employee> list = new ArrayList<Employee>();
        Employee e1 = new Employee(1, "Raj", 26, 3);
        Employee e2 = new Employee(1, "Taj", 27, 3);
        Employee e3 = new Employee(1, "Baj", 36, 10);
        list.add(e1);
        list.add(e2);
        list.add(e3);
        //Collections.sort(list);
        // Collections.sort(list, new Comparator<Employee>() {

        //     @Override
        //     public int compare(Employee o1, Employee o2) {
        //         // TODO Auto-generated method stub
        //         return Integer.compare(o1.age, o2.age);
        //     }
             
        // });

        Collections.sort(list, new EmployeeExpComparator());
        System.out.println(list);
    }
}
