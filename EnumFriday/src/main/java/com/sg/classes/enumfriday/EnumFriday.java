/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.enumfriday;

import java.util.Scanner;

/**
 *
 * @author geetikabatra
 */
class EnumFriday {
    
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.println("Please enter a day:");
         String st=sc.next();
         st=st.toUpperCase();
         
         
         System.out.println(countDays(Enum.valueOf(EnumFriday.Days.class, st)));
     }
    
    

    private static int countDays(Days d) {
        
        
        switch (d) {
            case MONDAY:
                return 4;
            case TUESDAY:
                return 3;
            case WEDNESDAY:
                return 2;
            case THURSDAY:
                return 1;
            case FRIDAY:
                return 0;
            case SATURDAY:
                return 6;
            case SUNDAY:
                return 5;
            default:
                throw new UnsupportedOperationException();
        }

    }

    public enum Days {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY

    }
}
