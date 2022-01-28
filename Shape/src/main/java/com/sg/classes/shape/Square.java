/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.shape;

/**
 *
 * @author geetikabatra
 */
public class Square extends Shape {

    int length;
    public Square(int length)
    {
        this.length=length;
    }
    @Override
    public int getArea() {
        return length*length;
    }

    @Override
    public int getPerimeter() {
        return length*4;
    }
    
}
