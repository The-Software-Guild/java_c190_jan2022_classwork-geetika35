/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.classesexample;

/**
 *
 * @author geetikabatra
 */
public class Dog {

    
    
    private String name;
    
    private double weight;
    public static final String constantgenus="canine";
    public static String genus;//=constantgenus;
     public Dog()
     {
         genus=Dog.constantgenus;
     }
    
    public Dog(String name,Double weight)
    {
        this(); //also has default ctor behaviour
        this.name=name;
        this.weight=weight;
    }
    public static boolean checkPetWorthy() {
        return genus==constantgenus;
    }
    
    
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public void speak() {
        if(weight<10.0)
        {
            System.out.println("yip!");
        }
        else
            System.out.println("WOOF!");
    }
    
    public void sit() {
        System.out.println("Sitting...");
    }
    
}
