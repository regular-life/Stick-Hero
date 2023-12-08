package com.project.stickhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PlayScreen extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
            FXMLLoader root = new FXMLLoader(PlayScreen.class.getResource("PlayScreenFXML.fxml"));
            Scene scene = new Scene(root.load());
            stage.setTitle("Stick Hero");
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
    }
}
