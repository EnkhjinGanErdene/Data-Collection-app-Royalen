package com.datacollection.service;

import com.datacollection.database.DBConnection;
import java.sql.*;

public class TaskService {

    public static void createTask(int userId,String name,String desc)throws Exception{

        Connection con=DBConnection.connect();

        PreparedStatement ps=con.prepareStatement(
                "INSERT INTO tasks(user_id,name,description) VALUES(?,?,?)");

        ps.setInt(1,userId);
        ps.setString(2,name);
        ps.setString(3,desc);

        ps.executeUpdate();
    }
}