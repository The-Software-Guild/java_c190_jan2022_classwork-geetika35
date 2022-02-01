/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.statecapitals2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author geetikabatra
 */
public class StateCapitals2 {
   static Map<String, String>  map = new HashMap<>();
    
    public static void main(String[] args) {
        
         
      Scanner sc=null;
        try {
             sc = new Scanner(new BufferedReader(new FileReader("StateCapitals.txt")));
             
             while(sc.hasNextLine())
                {
                    
                    String currLine= sc.nextLine();
                    //System.out.println(currLine);
                   // parseData(currLine);
                   
                    String[] data = currLine.split("::");
                     map.put(data[0],data[1]);
                    
                }
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StateCapitals2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(sc!=null)
            {
                sc.close();
            }
            
            
        }
        

        
        Set<String> keys = map.keySet();
        System.out.println("States -");
        for(String s: keys)
        {
            System.out.println(s);
        }

//        System.out.println("");
//        System.out.println("Capitals -");
//        for(String s: keys)
//        {
//            System.out.println(map.get(s));
//        }
//        
//        System.out.println("");
//        System.out.println("States - Capitals");
//        for(String s: keys)
//        {
//            System.out.println(s+" - "+map.get(s));
//        }
         
          
    }
    
//    
//    private static void parseData(String str){	
//   
//    String[] data = str.split("::");
//     map.put(data[0],data[1]);
//  }
}
