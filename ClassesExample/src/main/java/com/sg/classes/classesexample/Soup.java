/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.classesexample;

/**
 *
 * @author geetikabatra
 */
public abstract class Soup implements GroceryItem {
    private final int quantity;
    private static double SOUP_UNIT_PRICE=2.99d;
    
    
    public Soup (int quantity,double unitprice)
    {
        this.quantity=quantity;
        SOUP_UNIT_PRICE=unitprice;
    }

    //public abstract String demoVirtual();
    public abstract String demoVirtual();
    //{
        //return "abstract";
   // }
    
    //{return "Soup";}
    /**
     * @return the quantity
     */
    @Override
    public int getQuantity() {
        return quantity;
    }
    
    @Override
    public double getPrice() {
        return quantity * SOUP_UNIT_PRICE;
    }
    
    @Override
    public String displayDetails()
    {
        return String.format("Soup %d cans @ %.2f/per can = %.2f",quantity, 
                Soup.SOUP_UNIT_PRICE,this.getPrice());
    }
    
    //public String 
            
}
