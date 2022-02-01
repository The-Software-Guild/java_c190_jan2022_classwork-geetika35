/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.statecapitals;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author geetikabatra
 */
public class StateCapitals {
    
    public static void main(String[] args) {
        
        Map<String, String> st_cap = new HashMap<>();
        
//        Alabama - Montgomery
//Alaska - Juneau
//Arizona - Phoenix
//Arkansas - Little Rock
        st_cap.put("Alabama", "Montgomery");
        st_cap.put("Alaska", "Juneau");
        st_cap.put("Arizona","Phoenix");
        st_cap.put("Arkansas","Little Rock");
        
        Set<String> keys = st_cap.keySet();
        System.out.println("States -");
        for(String s: keys)
        {
            System.out.println(s);
        }
        
        System.out.println("");
        System.out.println("Capitals -");
        for(String s: keys)
        {
            System.out.println(st_cap.get(s));
        }
        
        System.out.println("");
        System.out.println("States - Capitals");
        for(String s: keys)
        {
            System.out.println(s+" - "+st_cap.get(s));
        }
    }
}
