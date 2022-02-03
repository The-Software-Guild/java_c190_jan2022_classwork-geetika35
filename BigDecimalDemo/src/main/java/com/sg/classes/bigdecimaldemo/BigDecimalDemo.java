/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.bigdecimaldemo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import static java.math.RoundingMode.DOWN;

/**
 *
 * @author geetikabatra
 */
public class BigDecimalDemo {

    public static void main(String[] args) {

        BigDecimal a = new BigDecimal("42.35");
        System.out.println(a);

        BigDecimal b = a.setScale(1,DOWN); 
        b = a.setScale(1, RoundingMode.HALF_UP);
        System.out.println(b.toString()); // 42.4

    }

}
