package com.datacollection.ui;

import com.datacollection.service.UserService;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class RegisterUI {

    public static void show(){

        Label title=new Label("Register");

        TextField email=new TextField();
        PasswordField password=new PasswordField();

        Label message=new Label();

        Button register=new Button("Register");

        register.setOnAction(e->{

            try{

                UserService.register(email.getText(),password.getText());

                message.setText("Verification code sent");

                VerificationUI.show(email.getText());

            }
            catch(Exception ex){
                message.setText(ex.getMessage());
            }

        });

        VBox root=new VBox(10,title,email,password,register,message);

        root.setAlignment(Pos.CENTER);

        ScreenManager.show(new Scene(root,400,400),"Register");
    }
}
/*package com.datacollection.ui;

import com.datacollection.service.UserService;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class RegisterUI {

    public static void show() {

        Label title = new Label("Register");

        TextField email = new TextField();
        email.setPromptText("Email");

        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        Label message = new Label();

        Button registerBtn = new Button("Register");

        Button back = new Button("Back");

        registerBtn.setOnAction(e -> {

            try {

                UserService.register(

                        email.getText(),

                        password.getText()

                );

                message.setText("Verification code sent to email");

                VerificationUI.show(email.getText());

            }
            catch (Exception ex){

                message.setText(ex.getMessage());

            }

        });

        back.setOnAction(e->LoginUI.show());

        VBox root = new VBox(10,title,email,password,registerBtn,back,message);

        root.setAlignment(Pos.CENTER);

        ScreenManager.show(new Scene(root,400,400),"Register");

    }

}*/
