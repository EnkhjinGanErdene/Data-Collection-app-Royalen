package com.datacollection.ui;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenManager {

    private static Stage stage;

    public static void setStage(Stage s) {

        stage = s;

    }

    public static void show(Scene scene, String title) {

        stage.setTitle(title);

        stage.setScene(scene);

        stage.show();

    }

}
