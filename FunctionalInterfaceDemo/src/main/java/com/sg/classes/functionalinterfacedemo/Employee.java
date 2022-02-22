/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.functionalinterfacedemo;

import java.math.BigDecimal;

/**
 *
 * @author geetikabatra
 */
class Employee {
    
    
    private int id;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    
    public Employee()
    {}

    void setID(int id) {
        this.id=id;
    }

    void setFirstName(String str) {
        firstName=str;
    }

    void setLastName(String str) {
        lastName=str;
    }
    
    void setSalary(BigDecimal s)
    {   
        salary=s;
        
    }
    
}
