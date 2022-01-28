/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.classesexample;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author geetikabatra
 */
class DemoContainers {

    static void democontainers(String[] args) {
        
        //Bettercart cart = new Bettercart();
        GroceryItem item = new Pasta(3);
        Map<String,GroceryItem> keyValueContainer = new HashMap<String,GroceryItem>();
        
        addItemToMap(keyValueContainer, item);
        System.out.println(keyValueContainer.size());
    }

    private static void addItemToMap(Map<String, GroceryItem> keyValueContainer, GroceryItem item) {
        String UPC_code="12334555";
        if(keyValueContainer.containsKey(UPC_code))
        {
            GroceryItem existingitem = keyValueContainer.get(UPC_code);
        
        }
        else
        {
            keyValueContainer.put(UPC_code,item);
        }
        
    }
    
}
