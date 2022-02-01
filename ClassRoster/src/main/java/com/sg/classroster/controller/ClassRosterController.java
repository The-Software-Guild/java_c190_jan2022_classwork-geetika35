/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classroster.controller;

import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoException;
import com.sg.classroster.dao.ClassRosterDaoFileImpl;
import com.sg.classroster.dto.Student;
import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOconsoleImpl;
import java.util.List;

/**
 *
 * @author geetikabatra
 */
public class ClassRosterController {
    
    //private ClassRosterView view= new ClassRosterView(); //use this if not DI
    //private UserIO io = new UserIOconsoleImpl(); //dont need after implementing methods
    //private ClassRosterDao dao = new ClassRosterDaoFileImpl(); //use this if not DI
    
    private ClassRosterView view; //dependency injection 
    private ClassRosterDao dao; //dependency injection
    
    public ClassRosterController(ClassRosterDao dao, ClassRosterView view) //for DI
    {
        this.dao = dao;
        this.view = view;
    }


    public void run() 
    {
        boolean keepGoing = true;
        int menuSelection = 0;
        try
        {
            while (keepGoing) 
            {
                //first step in controller
    //            io.print("Main Menu");
    //            io.print("1. List Student IDs");
    //            io.print("2. Create New Student");
    //            io.print("3. View a Student");
    //            io.print("4. Remove a Student");
    //            io.print("5. Exit");

                menuSelection = getMenuSelection(); 
            //io.readInt("Please select from the above choices.", 1, 5); //min and max

                switch (menuSelection) 
                {
                    case 1:
                        //io.print("LIST STUDENTS");
                        listStudents();
                        break;
                    case 2:
                        //io.print("CREATE STUDENT");
                        createStudent();
                        break;
                    case 3:
                        //io.print("VIEW STUDENT");
                        viewStudent();
                        break;
                    case 4:
                        //io.print("REMOVE STUDENT");
                        removeStudent();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        //io.print("UNKNOWN COMMAND");
                        unknownCommand();
                }

            }

            //o.print("GOOD BYE");
            exitMessage();
        } catch(ClassRosterDaoException e)
        {
            String err= e.getMessage();
            if(e.getCause()!=null )   //additional if exception is given a cause we can get nexted throwable
            {  err+='\n'+ e.getCause().getMessage();
            }
            
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return view.printMenuAndGetSelection();
    }
    
    
    //private void createStudent() 
    private void createStudent() throws ClassRosterDaoException
    {
        view.displayCreateStudentBanner() ;
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }
    
   // private void listStudents() 
    private void listStudents() throws ClassRosterDaoException
    {
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }
    
    //private void viewStudent()
    private void viewStudent() throws ClassRosterDaoException
    {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }
    
    //private void removeStudent()
    private void removeStudent() throws ClassRosterDaoException
    {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student removedStudent = dao.removeStudent(studentId);
        view.displayRemoveResult(removedStudent);
    }
    
    private void unknownCommand() 
    {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() 
    {
        view.displayExitBanner();
    }
}
