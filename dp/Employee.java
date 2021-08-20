package com.example.demo.prc.dp;

public class Employee {
    private String name;
    private Integer age;

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.getName()) && age.equals(employee.getAge());
    }

    @Override
    public int hashCode() {
        if (this.name == null || this.age == null)
            return 0;
        int result = 31;
        result *= this.name.hashCode();
        result *= this.age.hashCode();
        return result;
    }

    public static void main(String[] args) {
        Employee emp = new Employee("Akshay", 24);
        Employee emp1 = new Employee("Akshay", 24);

        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");

        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3); //false
        System.out.println(s1.equals(s3)); //true
        System.out.println(s2.equals(s3)); //true

        System.out.println(emp.equals(emp1));
        System.out.println(emp.hashCode());
        System.out.println(emp1.hashCode());

    }
}
