/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.functionalinterfacedemo;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author geetikabatra
 */
public class DemoFunctionalInterfaces {
    
    Set<Employee> employees;
    
    void demo(String[] args) {
        demoStandardInitialization();
    }

    private void demoStandardInitialization() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
        employees=new HashSet<>();
        Employee newEmp= new Employee();
        newEmp .setID(101);
        newEmp.setFirstName("Fred");
        newEmp.setLastName("Astaire");
        newEmp.setSalary(new BigDecimal(40000));
        
        newEmp = new Employee();
        
        newEmp .setID(102);
        newEmp.setFirstName("adelle");
        newEmp.setLastName("Astaire");
        newEmp.setSalary(new BigDecimal(40000));
        
        employees.add(new Employee());
        for(Employee e:employees)
        {
            System.out.println(e);
        }
    }
    
}
