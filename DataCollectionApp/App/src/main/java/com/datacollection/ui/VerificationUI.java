package com.datacollection.ui;

import com.datacollection.database.DBConnection;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.sql.*;

public class VerificationUI {

    public static void show(String email){

        Label title=new Label("Enter verification code");

        TextField code=new TextField();

        Label message=new Label();

        Button verify=new Button("Verify");

        verify.setOnAction(e->{

            try{

                Connection con=DBConnection.connect();

                PreparedStatement ps=con.prepareStatement(
                        "UPDATE users SET verified=1 WHERE email=? AND verification_code=?");

                ps.setString(1,email);
                ps.setString(2,code.getText());

                int result=ps.executeUpdate();

                if(result>0){

                    message.setText("Verified");

                    LoginUI.show();
                }
                else{

                    message.setText("Wrong code");
                }

            }
            catch(Exception ex){

                message.setText(ex.getMessage());
            }

        });

        VBox root=new VBox(10,title,code,verify,message);

        root.setAlignment(Pos.CENTER);

        ScreenManager.show(new Scene(root,400,400),"Verify");
    }
}
/*package com.datacollection.ui;
import com.datacollection.database.DBConnection;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class VerificationUI {

    public static void show(String email) {

        Label title=new Label("Enter verification code");

        TextField code=new TextField();

        Label message=new Label();

        Button verify=new Button("Verify");

        verify.setOnAction(e->{

            try{

                Connection con=DBConnection.connect();

                PreparedStatement ps=con.prepareStatement(

                        "UPDATE users SET verified=1 WHERE email=? AND verification_code=?");

                ps.setString(1,email);

                ps.setString(2,code.getText());

                int result=ps.executeUpdate();

                if(result>0){

                    message.setText("Account verified");

                    LoginUI.show();

                }

                else{

                    message.setText("Wrong code");

                }

            }
            catch(Exception ex){

                message.setText(ex.getMessage());

            }

        });

        VBox root=new VBox(10,title,code,verify,message);

        root.setAlignment(Pos.CENTER);

        ScreenManager.show(new Scene(root,400,400),"Verify");
    }
}*/
