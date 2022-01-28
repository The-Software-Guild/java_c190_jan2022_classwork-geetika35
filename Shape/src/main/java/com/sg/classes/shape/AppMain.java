/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.shape;

/**
 *
 * @author geetikabatra
 */
public class AppMain {
    
    public static void main(String[] args) {
        
        
        Shape s = new Square(3);
        System.out.println(s.getArea());
        System.out.println(s.getPerimeter());
        
        Shape s2= new Rectangle(2,3);
        System.out.println("");
        System.out.println(s2.getArea());
        System.out.println(s2.getPerimeter());
        
    }
    
    
    
}
