/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author geetikabatra
 */
public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer{

    private ClassRosterDao dao;
    private ClassRosterAuditDao auditDao;
    
//    public ClassRosterServiceLayerImpl(ClassRosterDao dao)
//    {
//        this.dao=dao;
//    }
    
    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao)
    {
        this.dao=dao;
        this.auditDao=auditDao;
    }
    
    @Override
    public void createStudent(Student student) throws ClassRosterDuplicateIdException,
            ClassRosterDataValidationException, ClassRosterPersistenceException 
    {
        String st_id=student.getStudentId();
        
         if (dao.getStudent(st_id) != null) 
         {
            throw new ClassRosterDuplicateIdException("ERROR: Could not create student."
                    + "  Student Id "+ st_id+ " already exists");
         }

         
          validateStudentData(student);
          
          dao.addStudent(st_id, student);
          
          auditDao.writeAuditEntry(
            "Student " + student.getStudentId() + " CREATED.");

          
          
     
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException
    {
         return dao.getAllStudents();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException
    {
        return dao.getStudent(studentId);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException 
    {
        Student removedStudent = dao.removeStudent(studentId);
        // Write to audit log
        auditDao.writeAuditEntry("Student " + studentId + " REMOVED.");
        return removedStudent;
    }
    
    
    private void validateStudentData(Student student) throws ClassRosterDataValidationException
    {
       // if (student==null) return;

        if (student.getFirstName() == null
                || student.getFirstName().trim().length() == 0
                || student.getLastName() == null
                || student.getLastName().trim().length() == 0
                || student.getCohort() == null
                || student.getCohort().trim().length() == 0) {

            throw new ClassRosterDataValidationException(
                    "ERROR: All fields [First Name, Last Name, Cohort] are required.");
        }
    }
    
}
