/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classroster.dao;

import com.sg.classroster.service.ClassRosterPersistenceException;
import com.sg.classroster.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author geetikabatra
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao{

    private static final String ROSTER_FILE = "roster.txt";
    private static final String DELIMITER = "::";
    
    private Map<String, Student> students = new HashMap<>();

    //these 4 were used before marshalling and unmarshalling
//    
//    @Override
//    public Student addStudent(String studentId, Student student) {
//        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        Student prevStudent = students.put(studentId, student);
//        return prevStudent;
//    }
//
//    @Override
//    public List<Student> getAllStudents() {
//        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//         return new ArrayList<Student>(students.values());  //values in hashmap - names
//    }
//
//    @Override
//    public Student getStudent(String studentId) {
//        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        return students.get(studentId);
//    }
//
//    @Override
//    public Student removeStudent(String studentId) {
//        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        Student removedStudent = students.remove(studentId);
//        return removedStudent;
//    }
//    
    
        ///////////////////////////////////////////////////////////////
    
    
    @Override
    public Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException 
    {
        loadRoster();
        Student newStudent = students.put(studentId, student);
        writeRoster();
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException 
    {
        loadRoster();
        return new ArrayList(students.values());
    }
    
    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException 
    {
        loadRoster();
        return students.get(studentId);
    }
    
    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException 
    {
        loadRoster();
        Student removedStudent = students.remove(studentId);
        writeRoster();
        return removedStudent;
    }

    
    private Student unmarshallStudent(String studentAsText) throws ClassRosterPersistenceException
    {
        String[] studentTokens;
        String studentId ;
        
        studentTokens = studentAsText.split(DELIMITER);
        studentId = studentTokens[0];
        
        
        
        // Which we can then use to create a new Student object to satisfy
        // the requirements of the Student constructor.
        Student studentFromFile = new Student(studentId);
        try{
        // Index 1 - FirstName
        studentFromFile.setFirstName(studentTokens[1]);

        // Index 2 - LastName
        studentFromFile.setLastName(studentTokens[2]);

        // Index 3 - Cohort
        studentFromFile.setCohort(studentTokens[3]);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            throw new ClassRosterPersistenceException("Data file contains an empty line",e); //checking for empty line in text file
        }

        // We have now created a student! Return it!
        return studentFromFile;

    }
    
        ///////////////////////////////////////////////////////////////

    
    private void loadRoster() throws ClassRosterPersistenceException 
    {
        Scanner sc;

        try {
            // Create Scanner for reading the file
            sc = new Scanner( new BufferedReader(new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new ClassRosterPersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        
        
        // currentStudent holds the most recent student unmarshalled
        Student currentStudent;
        
        
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // Student object by calling the unmarshallStudent method.
        // Process while we have more lines in the file
        while (sc.hasNextLine()) {
            // get the next line in the file
            currentLine = sc.nextLine();
            // unmarshall the line into a Student
            currentStudent = unmarshallStudent(currentLine);

            // We are going to use the student id as the map key for our student object.
            // Put currentStudent into the map using student id as the key
            students.put(currentStudent.getStudentId(), currentStudent);
        }
        // close scanner
        sc.close();
    }
    
    
    ///////////////////////////////////////////////////////////////
    
    
    private String marshallStudent(Student aStudent)
    {
        // We need to turn a Student object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // 4321::Charles::Babbage::Java-September1842

        // It's not a complicated process. Just get out each property,
        // and concatenate with our DELIMITER as a kind of spacer. 

        // Start with the student id, since that's supposed to be first.
        String studentAsText = aStudent.getStudentId() + DELIMITER;

        // add the rest of the properties in the correct order:

        // FirstName
        studentAsText += aStudent.getFirstName() + DELIMITER;

        // LastName
        studentAsText += aStudent.getLastName() + DELIMITER;

        // Cohort - don't forget to skip the DELIMITER here.
        studentAsText += aStudent.getCohort();

        // We have now turned a student to text! Return it!
        return studentAsText;
    }
    
    
    
    private void writeRoster() throws ClassRosterPersistenceException 
    {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new ClassRosterPersistenceException(
                    "Could not save student data.", e);
        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        String studentAsText;
        List<Student> studentList = this.getAllStudents();
        for (Student currentStudent : studentList) {
            // turn a Student into a String
            studentAsText = marshallStudent(currentStudent);
            // write the Student object to the file
            out.println(studentAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
    
}
