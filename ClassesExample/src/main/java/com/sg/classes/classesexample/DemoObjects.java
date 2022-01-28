/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.classesexample;

import java.util.Scanner;

/**
 *
 * @author geetikabatra
 */


public class DemoObjects {
    
    static Scanner cin = new Scanner(System.in);
    
    public static void demoObjects(String[] args)
    {
        System.out.println("This demo deals with classes and objects");
        System.out.println("");
        System.out.println("");
        
        
        //Dog pet = new Dog();
        //pet.setName("Lady");
        //pet.setWeight(9.0);
        
        //Dog pet = new Dog("Lady",9.0);
        Dog stray = new Dog();
        //stray.setName("Tramp");
        //stray.setWeight(20.0);
        
//        pet.speak();
//        stray.speak();
        Dog.genus="lobo"; //can be changed because genus is static and not final
        System.out.println(Dog.genus);
       // System.out.println(pet.genus); //this works because we declared genus as static
       // System.out.println(Dog.checkPetWorthy());
       int x=2,y=3;
       swap(x,y);
        System.out.println("x= "+x+ " y= "+y);
       
       
       
       Dog lassie = new Dog();
       lassie.setName("Lassie");
       passByValueDemo(lassie);
        System.out.println(lassie.getName());
       
       
    }

    private static void passByValueDemo(Dog anydog) { 
    //reference to memory
        anydog=new Dog();
       anydog.setName("Benjie");
    }

    private static void swap(int x, int y) { 
    //working with copies, so not going to work
         
     int temp=x;
     x=y;
     y=temp;
 
    }
    
}
