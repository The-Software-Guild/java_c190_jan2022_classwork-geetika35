/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classroster.service;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dto.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author geetikabatra
 */
class ClassRosterDaoStubImpl  implements ClassRosterDao{

    private Student student;
    
    
    public ClassRosterDaoStubImpl()
    {
        student = new Student("101"){{
                
            setFirstName("Ada");
            setLastName("Lovelace");
            setCohort("Java-May-1845");
                }};
    }
    
    public ClassRosterDaoStubImpl(Student student)
    {
        this.student=student;
    }
    
    
    @Override
    public Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException {
        
        if(studentId==this.student.getStudentId())
        {
            return student;
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        
        return new ArrayList<Student>(){{
            
            add(student);
                
        }};
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        
        return addStudent(studentId,this.student); //extreme DRY application
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        
         //return addStudent(studentId,this.student);
         return getLonelyStudent(studentId); //better application of DRY
    }
    
    private Student getLonelyStudent(String studentId)
    {
        if(studentId==this.student.getStudentId())
        {
            return student;
        }
        return null;
    }
    
}
