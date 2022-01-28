/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.classesexample;

/**
 *
 * @author geetikabatra
 */
public class GourmetSoup extends Soup{
    
    public GourmetSoup(int quantity,double unitprice) {
        super(quantity,1.99f);
    }
    
    @Override
    public double getPrice()
    {
        double cheapSoup = super.getPrice();
        return cheapSoup * 2;
    }
    
    @Override
    public String demoVirtual()
    {
        return "Gourmet Soup";
    }
}
