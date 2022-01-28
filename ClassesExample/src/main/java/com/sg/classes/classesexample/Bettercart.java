/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.classesexample;

import java.util.*;
//import java.util.Collection;
//import java.util.List;
//import java.util.Stack;

/**
 *
 * @author geetikabatra
 */
public class Bettercart {
    
   private List<GroceryItem> contents= new ArrayList<GroceryItem>(); 
   private Stack<String> strings= new Stack<String>(); 
   
//   public void test()
//   {
//       strings.push("hello");
//       String value =strings.pop();
//   }
   
   
   public boolean addItem(GroceryItem item)
   {
       return contents.add(item);
       
   }
   
   
   
   public void Helper(Collection<GroceryItem> coll)
   {
       if(!coll.isEmpty())
       {
           for(GroceryItem item:coll)
           {
               System.out.println(item.displayDetails());
           }
       }
   }
   
    public String checkout()
   {
       return String.format("%d items in the cart",contents.size());
   }
    
    
    public void emptyCart()
    {
        contents.clear();
    }
    
}
