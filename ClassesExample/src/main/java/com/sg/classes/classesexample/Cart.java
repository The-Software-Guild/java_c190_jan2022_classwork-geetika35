/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.classesexample;

/**
 *
 * @author geetikabatra
 */
public class Cart {
   private GroceryItem[] contents;
   private int currentIndex=0;
   //private wheels;
   
   public Cart()
   {
       this(100);
   }
   
   public Cart(int size)
   {
       contents = new GroceryItem[size];
   }
   
   
   public boolean addItem(GroceryItem item)
   {
       boolean success=false;
       if(currentIndex<contents.length)
       {  
           contents[currentIndex++]=item;
           success=true;
       }
       return success;
   }
   
   
   public String checkout()
   {
       return String.format("%d items in the cart",currentIndex);
   }
}
