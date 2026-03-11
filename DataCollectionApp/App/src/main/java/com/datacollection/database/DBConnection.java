package com.datacollection.database;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection connect() throws Exception {
        return DriverManager.getConnection(

                "jdbc:mysql://localhost:3306/user_auth_db",
                "root",

                "Mongol+9418"
        );
    }
}
