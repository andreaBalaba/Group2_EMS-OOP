package EmployeeManagementSystem;

import java.util.*;

public class Employee 
{
    private String name;
    private int age;
    private Date dateOfHired;
    private String email;
    private String address;
    private String phone;
    private String employeeId;
    private String education;
    private String position;
    private int salary;
    private String department;

    public Employee(String name, int age, Date dateOfHired, String email, String address, String phone, String employeeId, String education, String position, int salary, String department) 
    {
        this.name = name;
        this.age = age;
        this.dateOfHired = dateOfHired;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.employeeId = employeeId;
        this.education = education;
        this.position = position;
        this.salary = salary;
        this.department = department;
    }
    
    public Employee(String name, int age, String department, String position, int salary, String address, String email, String phone)
    {
        this.name = name;
        this.age = age;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.address = address;
        this.email = email;
        this.phone = phone;
        
    }
    
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getAge() 
    {
        return age;
    }

    public void setAge(int age) 
    {
        this.age = age;
    }

    public Date getDateOfHired() 
    {
        return dateOfHired;
    }

    public void setDateOfHired(Date dateOfHired) 
    {
        this.dateOfHired = dateOfHired;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getEmployeeId() 
    {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) 
    {
        this.employeeId = employeeId;
    }

    public String getEducation() 
    {
        return education;
    }

    public void setEducation(String education) 
    {
        this.education = education;
    }

    public String getPosition() 
    {
        return position;
    }

    public void setPosition(String position) 
    {
        this.position = position;
    }

    public int getSalary() 
    {
        return salary;
    }

    public void setSalary(int salary) 
    {
        this.salary = salary;
    }

    public String getDepartment() 
    {
        return department;
    }

    public void setDepartment(String department) 
    {
        this.department = department;
    }
}
