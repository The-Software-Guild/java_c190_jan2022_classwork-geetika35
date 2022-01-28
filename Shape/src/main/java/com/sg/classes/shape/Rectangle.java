/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.shape;

/**
 *
 * @author geetikabatra
 */
public class Rectangle extends Shape {;
    private int length;
    private int width;
    
    public Rectangle(int length,int width)
    {
        this.length=length;
        this.width=width;
    }
    
    
    @Override
    public int getArea() {
        return length*width;
    }

    @Override
    public int getPerimeter() {
       return 2*(length+width);
    }
    
}
