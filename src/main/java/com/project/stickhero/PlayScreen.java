package com.project.stickhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayScreen extends Application {

    static Scene scene ;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        FXMLLoader root = new FXMLLoader(PlayScreen.class.getResource("PlayScreenFXML.fxml"));
        scene = new Scene(root.load());
        primaryStage.setTitle("Stick Hero");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
