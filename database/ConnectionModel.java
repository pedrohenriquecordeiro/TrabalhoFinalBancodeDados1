/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class ConnectionModel {
    
    public static Connection connector() throws ClassNotFoundException, SQLException{
        
        String namebd = "postgres";
        String password = "1308";
        Class.forName("org.postgresql.Driver");
	java.sql.Connection connection = DriverManager.getConnection("jdbc:postgresql://"
				+ "localhost:5432/postgres" , namebd , password);
        
        return connection;
    }
    
}
