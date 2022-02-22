/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.todo.dto;

/**
 *
 * @author geetikabatra
 */
public class ToDo {

    private int id;
    private String todo;
    private String notes;
    private boolean finished;

    public void setId(int aInt) {
        id = aInt;
    }

    public void setTodo(String string) {
        todo = string;
    }

    public void setNote(String string) {

        notes = string;
    }

    public void setFinished(boolean aBoolean) {
        finished=aBoolean;
    }

    public int getId() {
        return id;
    }
    
    public String getTodo() {
        return todo;
    }

    public String getNote() {
        return notes;
    }

    public Boolean isFinished() {
        return finished;
    }

}
