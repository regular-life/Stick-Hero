package com.project.stickhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainScreen extends Application
{

    Scene scene ;
    public static void main(String[] args)
    {
        String resourcePath = "/assets/sonatina_letsadventure_1ATaleForTheJourney.wav";
        MediaPlayer mediaPlayer = createPlayer(resourcePath);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

        launch(args);
    }

    private static MediaPlayer createPlayer(String resourcePath) {
        URL mediaUrl = MainScreen.class.getResource(resourcePath);
        if (mediaUrl == null) {
            throw new RuntimeException("Resource not found: " + resourcePath);
        }
        Media sound = new Media(mediaUrl.toString());
        return new MediaPlayer(sound);
    }

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        FXMLLoader root = new FXMLLoader(getClass().getResource("MainScreenFXML.fxml"));
        scene = new Scene(root.load());
        primaryStage.setTitle("HOME");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
