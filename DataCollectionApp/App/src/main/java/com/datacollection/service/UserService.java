package com.datacollection.service;

import com.datacollection.database.DBConnection;
import com.datacollection.util.*;

import java.sql.*;

public class UserService {

    public static void register(
            String email,
            String password)
            throws Exception{


        String hash=
                PasswordUtil.hash(password);


        String code=
                CodeUtil.generate();


        Connection con=
                DBConnection.connect();


        PreparedStatement ps=
                con.prepareStatement(

                        "INSERT INTO users(email,password,verification_code)VALUES(?,?,?)");


        ps.setString(1,email);

        ps.setString(2,hash);

        ps.setString(3,code);

        ps.executeUpdate();


        EmailService.send(email,code);

    }


    public static boolean login(
            String email,
            String password)
            throws Exception{


        Connection con=
                DBConnection.connect();


        PreparedStatement ps=
                con.prepareStatement(

                        "SELECT password,verified FROM users WHERE email=?");


        ps.setString(1,email);


        ResultSet rs=
                ps.executeQuery();


        if(rs.next()){


            if(rs.getBoolean("verified")
                    && PasswordUtil.verify(password,rs.getString("password")))

                return true;


        }

        return false;

    }

}
