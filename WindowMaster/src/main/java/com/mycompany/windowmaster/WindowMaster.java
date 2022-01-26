/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.windowmaster;

import java.util.Scanner;

/**
 *
 * @author geetikabatra
 */
public class WindowMaster {
    public static void main(String[] args){
        
        
    // declare variables for height and width
    float height;
    float width;
    
    
    // declare other variables
    float areaOfWindow;
    float cost;
    float perimeterOfWindow;
    
    
    // declare and initialize the Scanner
    Scanner myScanner = new Scanner(System.in);

    // get input from the user
    System.out.println("Please enter window height:");
    height = myScanner.nextFloat();
  
    System.out.println("Please enter window width:");
    width = myScanner.nextFloat();
    
    // calculate the area of the window
    areaOfWindow = height * width;

    // calculate the perimeter of the window
    perimeterOfWindow = 2 * (height + width);
    //sout n tab
    
    // calculate the total cost 
    cost = ((3.50f * areaOfWindow) + (2.25f * perimeterOfWindow));
    
    
    
    // display the results to the user
    System.out.println("Window height = " + height);
    System.out.println("Window width = " + width);
    System.out.println("Window area = " + areaOfWindow);
    System.out.println("Window perimeter = " + perimeterOfWindow);
    System.out.println("Total Cost = CAD " + cost);

    
    }
    
}
