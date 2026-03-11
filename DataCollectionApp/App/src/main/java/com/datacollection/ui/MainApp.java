package com.datacollection.ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        ScreenManager.setStage(stage);

        LoginUI.show();

    }

    public static void main(String[] args) {

        launch();

    }

}
