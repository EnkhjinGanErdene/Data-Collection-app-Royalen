package com.datacollection.ui;

import com.datacollection.service.UserService;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class LoginUI {

    public static void show(){

        Label title=new Label("Login");

        TextField email=new TextField();
        PasswordField password=new PasswordField();

        Label message=new Label();

        Button login=new Button("Login");

        Button register=new Button("Register");

        login.setOnAction(e->{

            try{

                if(UserService.login(email.getText(),password.getText()))
                    message.setText("Login success");
                else
                    message.setText("Invalid login");

            }
            catch(Exception ex){
                message.setText(ex.getMessage());
            }

        });

        register.setOnAction(e->RegisterUI.show());

        VBox root=new VBox(10,title,email,password,login,register,message);

        root.setAlignment(Pos.CENTER);

        ScreenManager.show(new Scene(root,400,400),"Login");
    }
}

/*package com.datacollection.ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class LoginUI {

    public static void show() {

        Label title = new Label("Login");

        TextField email = new TextField();
        email.setPromptText("Email");

        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        Label message = new Label();

        Button login = new Button("Login");

        Button register = new Button("Go Register");

        register.setOnAction(e -> RegisterUI.show());

        VBox root = new VBox(10, title, email, password, login, register, message);

        root.setAlignment(Pos.CENTER);

        ScreenManager.show(new Scene(root,400,400),"Login");

    }

}*/
