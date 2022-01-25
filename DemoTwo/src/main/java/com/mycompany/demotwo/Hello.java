/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demotwo;

import java.util.Scanner;

/**
 *
 * @author geetikabatra
 */
public class Hello {
     public static void main(String[] args) {
//         Hello myhello= new Hello();
//         String message = "Hello World";
//         message+= "- From IDE";
//         message+=(myhello.getNumber()+"extra");
//         
//         myhello.getNumber();
//        System.out.println(message);
          int num=0;
          Scanner in = new Scanner(System.in); 
          System.out.println("enter num from 1-5:");
          num=in.nextInt();
           demonstrateOperators(num);

    }

    private static void demonstrateOperators(int n) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int firstOperand;
        int secondOperand;
        int result=n;
        
        firstOperand= 42;
        secondOperand= 1;
        //result as result of sum of 2 values
        //result= 2+2;
       // result= firstOperand + secondOperand;
       // result= firstOperand + 2;
        //result+=42;
        System.out.println(result);
        System.out.println(++result);
        System.out.println(result++);
        System.out.println(result);
        
    }

    public int getNumber() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return 42;
    }

    
}
