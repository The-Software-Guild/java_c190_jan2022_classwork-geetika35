/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.demotwo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author geetikabatra
 */
public class TestHello {
    
    public TestHello() {
    }

//    @org.junit.jupiter.api.BeforeAll
//    public static void setUpClass() throws Exception {
//    }
//
//    @org.junit.jupiter.api.AfterAll
//    public static void tearDownClass() throws Exception {
//    }
//
//    @org.junit.jupiter.api.BeforeEach
//    public void setUp() throws Exception {
//    }
//
//    @org.junit.jupiter.api.AfterEach
//    public void tearDown() throws Exception {
//    }
//    
    @BeforeAll
    public static void setUpClass() {
        underTest=new Hello();
    }
    
//    @AfterAll
//    public static void tearDownClass() {
//    }
    int result =12;
   static Hello underTest;
    @BeforeEach
    public void setUp() {
        result=42;
    }
    
    @AfterEach
    public void tearDown() {
        result=12;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         int number = underTest.getNumber();
         assertEquals(number,result);
     }
}
