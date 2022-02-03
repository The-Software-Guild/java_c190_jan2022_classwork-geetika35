/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import com.sg.classroster.service.ClassRosterPersistenceException;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author geetikabatra
 */
public class ClassRosterDaoFileImplTest {

    public ClassRosterDaoFileImplTest() {
    }

    ClassRosterDao testDao;

    @BeforeEach
    public void setUp() throws IOException {

        String testFile = "testroster.txt";
        //filewriter ctor creates or opens the file if no append second argument
        new FileWriter(testFile);
        testDao = new ClassRosterDaoFileImpl(testFile);
    }

    @Test
    public void testAddGetStudent() throws ClassRosterPersistenceException {
        //arange
        String studentId = "0001";
        Student student = new Student(studentId);
        student.setFirstName("Ada");
        student.setLastName("Lovelace");
        student.setCohort("Java");

        //act
        testDao.addStudent(studentId, student);
        Student retrievedstudent = testDao.getStudent(studentId);

        //assert
//        assertEquals(student.getStudentId(), retrievedstudent.getStudentId(), 
//                "Checking student id.");
//        assertEquals(student.getFirstName(), retrievedstudent.getFirstName(),
//                "Checking student first name.");
//        assertEquals(student.getLastName(),retrievedstudent.getLastName(),
//                "Checking student last name.");
//        assertEquals(student.getCohort(),retrievedstudent.getCohort(),
//                "Checking student cohort.");

          assertEquals(student,retrievedstudent);
    }

}
