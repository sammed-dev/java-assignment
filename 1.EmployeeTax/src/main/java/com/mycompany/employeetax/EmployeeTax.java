/* 

    Write a program to take N number of space separated inputs. The input
    lines will be employee details and should look like this,
    Employee_id Employee_name Salary
    Store the details as a list of objects in java of the class with the above
    mentioned parameters. Once stored, iterate through each object, calculate
    the income tax of all the employees and print all the details in the console.
    The income tax slabs are as follows:
    Slab rate IT rate
    Upto Rs. 50,000 Nil
    Upto Rs. 60,000 10% on additional amount
    Upto Rs. 1,50,000 20% on additional amount
    Above Rs. 1,50,000 30% on additional amount

*/
        
package com.mycompany.employeetax;

import java.util.ArrayList;
import java.util.List;


class Employee{
    int employee_id;
    String employee_name;
    double salary;

    public Employee(int employee_id, String employee_name, int salary) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.salary = salary;
    }
}


public class EmployeeTax {

    public static void main(String[] args) {

        List<Employee> employee = new ArrayList<>();
        employee.add(new Employee(101, "sammed", 40000));
        employee.add(new Employee(101, "Amit", 55000));
        employee.add(new Employee(101, "Shreyank", 90000));
        employee.add(new Employee(101, "virat", 200000));

        List<Employee> employee_tax = new ArrayList<>();
        for(Employee employee1 : employee){
            if(employee1.salary < 50000)
                employee_tax.add(employee1);
            else if(employee1.salary>=50000 && employee1.salary < 60000){
                employee1.salary = employee1.salary + (0.1 * employee1.salary);
                employee_tax.add(employee1);
            }
            else if(employee1.salary>=60000 && employee1.salary < 150000){
                employee1.salary = employee1.salary + (0.2 * employee1.salary);
                employee_tax.add(employee1);
            }
            else if(employee1.salary>=150000){
                employee1.salary = employee1.salary + (0.3 * employee1.salary);
                employee_tax.add(employee1);
            }
        }

        for(Employee employee1 : employee_tax){
            System.out.println(employee1.employee_name+" "+ employee1.salary);
        }

    }
}
