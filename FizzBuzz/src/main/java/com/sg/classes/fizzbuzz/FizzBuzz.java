/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.fizzbuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author geetikabatra
 */
public class FizzBuzz {
    
    public static void main(String[] args) {
       
        System.out.println("Please enter a number: ");
        Scanner sc = new Scanner(System.in);
        int input=sc.nextInt();
        int counter=0;
        //List<String> fbarray = new ArrayList<String>();
        //int lengthCounter;
        
        
        for(int i=0;;i++) /////!!!!!!!!
        {
            if(i==0)
            {
                System.out.println(i);
            }
            else if((i%3 ==0) && (i%5 ==0))
            {
                System.out.println("fizz buzz");
                counter++;
            }
            else if(i%3==0)
            {
                System.out.println("fizz");
                counter++;
            }
            else if(i%5==0)
            {
                System.out.println("buzz");
                counter++;
            }
            else
            { System.out.println(i);
            
            }
            
           if(counter==input)
               break;
            
            
        }
               
    }
    
}
