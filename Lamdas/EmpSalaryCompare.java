package Lamdas;

import java.util.Comparator;

public class EmpSalaryCompare implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        // TODO Auto-generated method stub
        return o1.getSalary() - o2.getSalary();
    }
    
    
}
