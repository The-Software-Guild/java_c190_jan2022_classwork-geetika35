/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.todo.dao;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.sg.todo.dto.ToDo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.sql.DataSource;

/**
 *
 * @author geetikabatra
 */
public class ToDoSQLDao {
    
    private static DataSource ds;
    private static Scanner sc = new Scanner(System.in);
    
    public static void myMain(String[] args) throws SQLException {
        
        try {
            ds = getDataSource();
        } catch (SQLException ex) {
            System.out.println("Error connecting to database");
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        
        displayList();
        //addItem();
        updateItem();
        removeItem();
    }
    
    private static DataSource getDataSource() throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName("localhost");
        ds.setDatabaseName("todoDB");
        ds.setUser("root");
        ds.setPassword("35Sardarclub!");
        ds.setServerTimezone("America/New_York");
        ds.setUseSSL(false);
        ds.setAllowPublicKeyRetrieval(true);

        return ds;
    }
    
    
    private static void displayList() throws SQLException {
        
        try ( Connection conn = ds.getConnection())  //instruction for entry to try block - not using catch
        
        {
            Statement stmt = conn.createStatement();
            String SQLquery ="SELECT * FROM todo";
            ResultSet rs = stmt.executeQuery(SQLquery);
            while (rs.next()) 
            {
                System.out.printf("%s: %s -- %s -- %s\n",
                        rs.getString("id"), //columns in todo table
                        rs.getString("todo"),
                        rs.getString("note"),
                        rs.getBoolean("finished"));
            }
            System.out.println("");
        }
        
    }
    
    
     private static void addItem() throws SQLException {
        System.out.println("Add Item");
        System.out.println("What is the task?");
        String task = sc.nextLine();
        System.out.println("Any additional notes?");
        String note = sc.nextLine();
        
        try (Connection conn = ds.getConnection()) {
            String sql = "INSERT INTO todo(todo, note) VALUES(?,?)";
            PreparedStatement pStmt = conn.prepareCall(sql);
            pStmt.setString(1, task);
            pStmt.setString(2, note);
           
            if(pStmt.executeUpdate()!=0)
                System.out.println("Add Complete");
            else
                System.out.println("Add Failed");
        }
    }
    
    
    
    private static void updateItem() throws SQLException {
        
         System.out.println("Update Item");
        System.out.println("Which item do you want to update?");
        String itemId = sc.nextLine();
        
        try( Connection conn = ds.getConnection()) 
        {
            String sql = "SELECT * FROM todo WHERE id = ?";
            PreparedStatement pStmt = conn.prepareCall(sql);
            pStmt.setString(1, itemId);
            ResultSet rs = pStmt.executeQuery();
            rs.next();
            
            ToDo td = new ToDo();
            td.setId(rs.getInt("id"));
            td.setTodo(rs.getString("todo"));
            td.setNote(rs.getString("note"));
            td.setFinished(rs.getBoolean("finished"));
            
            
             System.out.println("1. ToDo - " + td.getTodo());
            System.out.println("2. Note - " + td.getNote());
            System.out.println("3. Finished - " + td.isFinished());
            System.out.println("What would you like to change?");

            String choice = sc.nextLine();
            switch(choice) {
                case "1":
                    System.out.println("Enter new ToDo:");
                    String todo = sc.nextLine();
                    td.setTodo(todo);
                    break;
                case "2":
                    System.out.println("Enter new Note:");
                    String note = sc.nextLine();
                    td.setNote(note);
                    break;
                case "3":
                    System.out.println("Toggling Finished to " + !td.isFinished());
                    td.setFinished(!td.isFinished());
                    break;
                default:
                    System.out.println("No change made");
                    return;
            }
            String updateSql = "UPDATE todo SET todo = ?, note = ?, finished = ? WHERE id = ?";
            PreparedStatement updatePStmt = conn.prepareCall(updateSql);
            updatePStmt.setString(1, td.getTodo());
            updatePStmt.setString(2, td.getNote());
            updatePStmt.setBoolean(3, td.isFinished());
            updatePStmt.setInt(4, td.getId());
            updatePStmt.executeUpdate();
            System.out.println("Update Complete");
        }
        
    }
    
    
    
    
    private static void removeItem() throws SQLException {
        System.out.println("Remove Item");
        System.out.println("Which item would you like to remove?");
        String itemId = sc.nextLine();
        
        try(Connection conn = ds.getConnection()) {
            String sql = "DELETE FROM todo WHERE id = ?";
            PreparedStatement pStmt = conn.prepareCall(sql);
            pStmt.setString(1, itemId);
            pStmt.executeUpdate();
            System.out.println("Remove Complete");
        }    
    }
    
    
}
