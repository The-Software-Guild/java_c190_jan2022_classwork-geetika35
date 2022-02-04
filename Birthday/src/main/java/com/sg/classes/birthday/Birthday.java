/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.birthday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author geetikabatra
 */
public class Birthday {
    
    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);
        LocalDate today= LocalDate.now();
        LocalDate tom=today.plusDays(1);
        
        System.out.println("Welcome to the Magical Birthday calculator!");
        System.out.println("Whats your bday?");
        
        
        System.out.println("enter year: ");
        int year= sc.nextInt();
        System.out.println("enter month: ");
        int month=sc.nextInt();
        System.out.println("enter date: ");
        int date= sc.nextInt();
        
        LocalDate thisYearBday=LocalDate.of(today.getYear(), month, date);
        LocalDate bday=LocalDate.of(year,month,date);
        
        DayOfWeek dayName = bday.getDayOfWeek();
        System.out.println("You were born on a "+ dayName);
        
        DayOfWeek dayName2= thisYearBday.getDayOfWeek();
        
        System.out.println("This year it falls on a "+dayName2);
        
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
         
         int age=Period.between(bday, thisYearBday).getYears();
         
         System.out.println(today);
         System.out.println(thisYearBday);
         int diff=today.getDayOfYear()-thisYearBday.getDayOfYear();
         
         //Period diff=Period.between(today,thisYearBday);
         //long numDays=diff.get(ChronoUnit.DAYS);
         //long diff=ChronoUnit.DAYS.between(today,thisYearBday);
                 
        System.out.println("And since today is "+ today.format(formatter)+", there's only "+ diff+" more days until next one!");
        System.out.println("Bet you're excited to be turning "+ age+ "!");
        
    }
}
