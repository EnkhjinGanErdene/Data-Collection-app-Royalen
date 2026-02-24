package com.datacollection.ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("Data Collection App Login");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginBtn = new Button("Login");

        Button registerBtn = new Button("Register");

        Label message = new Label();

        loginBtn.setOnAction(e -> {

            String email = emailField.getText();

            String password = passwordField.getText();

            message.setText("Login button clicked");

        });


        registerBtn.setOnAction(e -> {

            message.setText("Register button clicked");

        });


        VBox root = new VBox(10);

        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(

                title,

                emailField,

                passwordField,

                loginBtn,

                registerBtn,

                message

        );


        Scene scene = new Scene(root, 400, 400);

        stage.setScene(scene);

        stage.setTitle("Login");

        stage.show();

    }


    public static void main(String[] args) {

        launch();

    }

}
