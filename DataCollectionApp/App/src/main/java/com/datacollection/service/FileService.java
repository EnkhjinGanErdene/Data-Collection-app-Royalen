package com.datacollection.service;

import com.datacollection.database.DBConnection;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

public class FileService {

    public static void upload(int taskId,File file)throws Exception{

        Connection con=DBConnection.connect();

        PreparedStatement ps=con.prepareStatement(
                "INSERT INTO files(task_id,file_name,file_data) VALUES(?,?,?)");

        FileInputStream fis=new FileInputStream(file);

        ps.setInt(1,taskId);
        ps.setString(2,file.getName());
        ps.setBinaryStream(3,fis,file.length());

        ps.executeUpdate();
    }
}