package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {


    public static void connection(){
        String url = "jdbc:sqlite:/home/lm/Documents/Projects/DBProject/dbproject/data/database.db";
        try(Connection conn = DriverManager.getConnection(url)){
            System.out.println("Connection with SQLite established!");
        }
        catch(SQLException e){
            System.out.println("Error:\n" + e.getMessage());

        }
    }
    
}

