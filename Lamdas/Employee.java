package Lamdas;

public class Employee implements Comparable<Employee>{
    int id;
    String name;
    int salary;
    String email;
    String dept;

    public Employee(int id, String name, int salary, String email, String dept) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.email = email;
        this.dept = dept;
    }

    boolean isActive(){
        return id%2==0;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public int compareTo(Employee o) {
        // TODO Auto-generated method stub
        return this.getSalary() - o.getSalary();
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", email=" + email + ", dept=" + dept
                + "]";
    }
    
    
    
}
