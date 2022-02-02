/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.classroster;

import com.sg.classroster.controller.ClassRosterController;
import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterAuditDaoFileImpl;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoFileImpl;
import com.sg.classroster.service.*;
import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOconsoleImpl;

/**
 *
 * @author geetikabatra
 */
public class App {
    public static void main(String[] args) {
//        ClassRosterController controller = new ClassRosterController();
//        controller.run();
    
    //define dependency implementations
    UserIO myIo = new UserIOconsoleImpl();
    ClassRosterDao myDao = new ClassRosterDaoFileImpl();
    
    //inject user io dependency into view
    ClassRosterView myView = new ClassRosterView(myIo);
    ClassRosterAuditDao myAuditDao= new ClassRosterAuditDaoFileImpl();
//    ClassRosterServiceLayer service = new ClassRosterServiceLayerImpl(myDao);
ClassRosterServiceLayer service = new ClassRosterServiceLayerImpl(myDao,myAuditDao);
    
    
    //injecting class roster dao and class roster view into class roster controller
    //ClassRosterController controller = new ClassRosterController(myDao, myView);
    ClassRosterController controller = new ClassRosterController(service, myView);
    
    //run application
    controller.run();



    }
}
