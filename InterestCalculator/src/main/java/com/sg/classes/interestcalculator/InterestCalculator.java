/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.interestcalculator;

import java.util.Scanner;

/**
 *
 * @author geetikabatra
 */
public class InterestCalculator {
    
        
        
        
        
    public static float findQuarterlyProfits(float currentBalance, float annualInterest) {
        float QuarterlyInterest = annualInterest/4;
        return currentBalance * (1 + (QuarterlyInterest / 100));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How much do you want to invest? ");
        float initPrincipal = sc.nextFloat();
        System.out.print("How many years are investing? ");
        // int numYears = sc.nextInt();
        System.out.print("What is the annual interest rate % growth? ");
        float annualInterest = sc.nextFloat();

        // find profits per quarter
        float firstQuarter = findQuarterlyProfits(initPrincipal, annualInterest);
        System.out.println(firstQuarter);

        // find yearly profits
        float quarter = initPrincipal;
        for (int i=1;i<=4;i++){
            quarter = findQuarterlyProfits(quarter, annualInterest);
            System.out.println(quarter);
        }
        
        // for(int i=1;i<=numYears;i++){
            
        // }

        sc.close();

    
    }
}
