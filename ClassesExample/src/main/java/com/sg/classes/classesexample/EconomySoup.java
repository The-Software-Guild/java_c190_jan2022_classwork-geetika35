/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classes.classesexample;

/**
 *
 * @author geetikabatra
 */
public class EconomySoup extends Soup{
    
    public EconomySoup(int quantity,double unitprice) {
        super(quantity,0.99f);
    }

    @Override
    public String demoVirtual() {
        return "Economy soup";
    }
    
}
