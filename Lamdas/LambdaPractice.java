package Lamdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaPractice {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1,"John dart",50000,"john@gmail.com","Accounts"),
            new Employee(2,"Rob dart",90000,"rob@gmail.com","IT"),
            new Employee(3,"tony dart",70000,"tony@gmail.com","Sales"),
            new Employee(4,"Pony dart",72000,"pony@gmail.com","IT")
    );
        List<Employee> tempEmps = new ArrayList<>(employees);
        // 1st way (class based implementation)
        EmpNameComparator nameComparator = new EmpNameComparator();
        employees.sort(nameComparator);

        //2nd way (Anonymous inner class)
        Comparator salaryComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.salary - o2.salary;
            }            
        };
        employees.sort(salaryComparator);

        //3rd way (Lambda)
        Comparator<Employee> salaryReverse = (e1,e2) -> {
                return e2.salary - e1.salary;
        };
        employees.sort(salaryReverse);

        //4th way (lambda)
        employees.sort((e1,e2)->  e1.email.compareTo(e2.email));


        //Predicate
        tempEmps.removeIf((e)->!e.isActive());
        tempEmps.forEach(System.out::println);
        


    }
}
