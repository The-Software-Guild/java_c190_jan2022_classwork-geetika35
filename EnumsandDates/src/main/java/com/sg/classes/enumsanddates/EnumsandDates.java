/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.enumsanddates;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author geetikabatra
 */
class EnumsandDates {

    public static void demo(String[] args) {
        System.out.println("The answer is = " + calculate(MathOperator.PLUS, 40, 2));
        showLocalDate();
        //oldDates(); 
    }

    private static void oldDates() {
        LocalDate ld = LocalDate.now();
        Date legacyDate = new Date();
        System.out.println(legacyDate);
        ZonedDateTime zdt = ZonedDateTime.ofInstant(
                legacyDate.toInstant(), ZoneId.systemDefault());
        System.out.println(zdt);
        ld = zdt.toLocalDate();
        System.out.println(ld);
    }

    //localdate
    private static void showLocalDate() {
        LocalDate ld = LocalDate.now();
        System.out.println(ld);

        LocalDate past = ld.minusWeeks(2);
        System.out.println(past);
        Period diff = ld.until(past);
        System.out.println(diff);

        Period otherdiff = past.until(ld);
        System.out.println(otherdiff);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        ld = LocalDate.parse("02/07/2010", formatter);
        String formatted = ld.format(formatter);
        System.out.println(formatted);

        formatted = ld.format(DateTimeFormatter.ofPattern("MM=dd=yyyy+=+=+="));
        System.out.println(formatted);

    }

    private static int calculate(MathOperator operator, int operand1, int operand2) {
        switch (operator) {
            case PLUS:
                System.out.println(MathOperator.valueOf("MULTIPLY")); //gives you token name
                return operand1 + operand2;
            case MINUS:
                return operand1 - operand2;
            case MULTIPLY:
                return operand1 * operand2;
            case DIVIDE:
                return operand1 / operand2;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public enum MathOperator {
        PLUS, MINUS, MULTIPLY, DIVIDE
    }
}
