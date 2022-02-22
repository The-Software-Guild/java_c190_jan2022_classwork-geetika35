package com.sg.todo;

import com.sg.todo.dao.ToDoSQLDao;
import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(ToDoApplication.class, args);
                
               // ToDoSQLDao.myMain(args);
	}

}
