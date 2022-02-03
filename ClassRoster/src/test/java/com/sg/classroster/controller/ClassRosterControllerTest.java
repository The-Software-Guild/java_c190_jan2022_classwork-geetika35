/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sg.classroster.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 *
 * @author geetikabatra
 */

// @ExtendWith(MockitoExtension.class)
public class ClassRosterControllerTest {
    
   
    
    public ClassRosterControllerTest() {
    }
    
    private ClassRosterController controller;
    
    
    @BeforeEach
    public void setUp() {
        //controller= new ClassRosterController();
    }

    /**
     * Test of run method, of class ClassRosterController.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        ClassRosterController instance = null;
        instance.run();
        fail("The test case is a prototype.");
    }
    
}
