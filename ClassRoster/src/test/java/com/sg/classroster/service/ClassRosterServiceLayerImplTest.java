/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dto.Student;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author geetikabatra
 */
public class ClassRosterServiceLayerImplTest {
    
    private ClassRosterAuditDao auditDao;
    private ClassRosterDao dao;
    private ClassRosterServiceLayer instance;
    
    public ClassRosterServiceLayerImplTest() {
    }
    
    @BeforeEach
    public void setUp() {
        
        auditDao = new ClassRosterAuditDaoStubImpl();
        dao = new ClassRosterDaoStubImpl();
        instance =  new ClassRosterServiceLayerImpl(dao,auditDao);
    }

    /**
     * Test of createStudent method, of class ClassRosterServiceLayerImpl.
     */
    @Test
    public void testCreateInvalidStudent() throws Exception {
        System.out.println("createStudent");
        Student student = null;
        ClassRosterServiceLayerImpl instance = null;
        instance.createStudent(student);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    @Test
public void testCreateValidStudent() {
    // ARRANGE
    Student student = new Student("0002");
    student.setFirstName("Charles");
    student.setLastName("Babbage");
    student.setCohort(".NET-May-1845");
    // ACT
    try {
        instance.createStudent(student);
    } catch (ClassRosterDuplicateIdException
            | ClassRosterDataValidationException
            | ClassRosterPersistenceException e) {
    // ASSERT
        fail("Student was valid. No exception should have been thrown.");
    }
}
    
    /**
     * Test of getAllStudents method, of class ClassRosterServiceLayerImpl.
     */
//    @Test
//    public void testGetAllStudents() throws Exception {
//        System.out.println("getAllStudents");
//        ClassRosterServiceLayerImpl instance = null;
//        List<Student> expResult = null;
//        List<Student> result = instance.getAllStudents();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getStudent method, of class ClassRosterServiceLayerImpl.
     */
//    @Test
//    public void testGetStudent() throws Exception {
//        System.out.println("getStudent");
//        String studentId = "";
//        ClassRosterServiceLayerImpl instance = null;
//        Student expResult = null;
//        Student result = instance.getStudent(studentId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of removeStudent method, of class ClassRosterServiceLayerImpl.
     */
//    @Test
//    public void testRemoveStudent() throws Exception {
//        System.out.println("removeStudent");
//        String studentId = "";
//        ClassRosterServiceLayerImpl instance = null;
//        Student expResult = null;
//        Student result = instance.removeStudent(studentId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
    @Test
public void testCreateDuplicateIdStudent() {
    // ARRANGE
    Student student = new Student("0001");
    student.setFirstName("Charles");
    student.setLastName("Babbage");
    student.setCohort(".NET-May-1845");

    // ACT
    try {
        instance.createStudent(student);
        fail("Expected DupeId Exception was not thrown.");
    } catch (ClassRosterDataValidationException
            | ClassRosterPersistenceException e) {
    // ASSERT
        fail("Incorrect exception was thrown.");
    } catch (ClassRosterDuplicateIdException e){
        return;
    }
}


@Test
public void testCreateStudentInvalidData() throws Exception {
    // ARRANGE
    Student student = new Student("0002");
    student.setFirstName("");
    student.setLastName("Babbage");
    student.setCohort(".NET-May-1845");

    // ACT
    try {
        instance.createStudent(student);
        fail("Expected ValidationException was not thrown.");
    } catch (ClassRosterDuplicateIdException
            | ClassRosterPersistenceException e) {
    // ASSERT
        fail("Incorrect exception was thrown.");
    } catch (ClassRosterDataValidationException e){
        return;
    }  
}


@Test
public void testGetAllStudents() throws Exception {
    // ARRANGE
    Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

    // ACT & ASSERT
    assertEquals( 1, instance.getAllStudents().size(), 
                                   "Should only have one student.");
    assertTrue( instance.getAllStudents().contains(testClone),
                              "The one student should be Ada.");
}



@Test
public void testGetStudent() throws Exception {
    // ARRANGE
    Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

    // ACT & ASSERT
    Student shouldBeAda = instance.getStudent("0001");
    assertNotNull(shouldBeAda, "Getting 0001 should be not null.");
    assertEquals( testClone, shouldBeAda,
                                   "Student stored under 0001 should be Ada.");

    Student shouldBeNull = instance.getStudent("0042");    
    assertNull( shouldBeNull, "Getting 0042 should be null.");

}


@Test
public void testRemoveStudent() throws Exception {
    // ARRANGE
    Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

    // ACT & ASSERT
    Student shouldBeAda = instance.removeStudent("0001");
    assertNotNull( shouldBeAda, "Removing 0001 should be not null.");
    assertEquals( testClone, shouldBeAda, "Student removed from 0001 should be Ada.");

    Student shouldBeNull = instance.removeStudent("0042");    
    assertNull( shouldBeNull, "Removing 0042 should be null.");

}
    
}
