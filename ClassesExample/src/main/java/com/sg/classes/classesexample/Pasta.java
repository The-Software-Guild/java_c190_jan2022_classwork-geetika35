/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.classesexample;

/**
 *
 * @author geetikabatra
 */
public class Pasta implements GroceryItem {

    private int quantity;
    private static double UNIT_PRICE=0.99f;

    public Pasta(int i) {
    }

    @Override
    public String displayDetails() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return String.format("Soup %d cans @ %.2f/per can = %.2f ",quantity, Pasta.UNIT_PRICE,this.getPrice());
    }

    @Override
    public double getPrice() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return quantity *UNIT_PRICE;
    }

    @Override
    public int getQuantity() {
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return quantity;
    }
    
}
