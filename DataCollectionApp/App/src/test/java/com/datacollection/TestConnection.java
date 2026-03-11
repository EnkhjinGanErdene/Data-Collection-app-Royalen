package com.datacollection;

import com.datacollection.database.DBConnection;
import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {

        try {

            Connection conn = DBConnection.connect();

            if (conn != null) {
                System.out.println("Database connected successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}