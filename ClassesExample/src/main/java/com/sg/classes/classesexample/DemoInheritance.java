/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.classesexample;

/**
 *
 * @author geetikabatra
 */
public class DemoInheritance {
    
    
    static void demoInheritance(String[] args)
    {
        //Soup s= new Soup(3);
        
        GroceryItem item= new EconomySoup(3,1.0f);
     //   double totalCosts=s.getPrice();
      //  System.out.println(String.format("The total cost of items is %.2f",totalCosts));
        //System.out.println(item.displayDetails());\
        Cart cart=new Cart();
        if (!cart.addItem(item))
        {   return;}
        item=new Pasta(6);
        if (!cart.addItem(item))
        {   return;}
        System.out.println(item.displayDetails());
        
        item= new GourmetSoup(2,2.0f);
        if (!cart.addItem(item))
        {   return;}
        
       GourmetSoup gs= (GourmetSoup)item;
        System.out.println(gs.demoVirtual());
        System.out.println(item.displayDetails());
        System.out.println(cart.checkout());
    }
}
