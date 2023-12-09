package com.project.stickhero;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController extends Application {
    public AnchorPane Main_Background;
    private Scene scene;
    @FXML
    private Text matchesPlayedText;

    @FXML
    private Text highestScoreText;

    private static int matchesPlayed ;
    private static int highestScore ;


    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private void handleStartButton() throws IOException
    {
        FXMLLoader root = new FXMLLoader(PlayScreen.class.getResource("PlayScreenFXML.fxml"));
        scene = new Scene(root.load());
        Stage primaryStage = (Stage) Main_Background.getScene().getWindow();
        primaryStage.setTitle("Stick Hero");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    @FXML
    public void handleStatsButton(ActionEvent actionEvent) throws IOException
    {
        matchesPlayed = 0 ;
        highestScore = 0 ;
        matchesPlayedText.setText("Matches Played: " + StartController.matchesPlayed);
        highestScoreText.setText("Highest Score: " + StartController.highestScore);

        FXMLLoader root = new FXMLLoader(PlayScreen.class.getResource("stats-page.fxml"));
        scene = new Scene(root.load());
        Stage primaryStage = (Stage) Main_Background.getScene().getWindow();
        primaryStage.setTitle("Stick Hero");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
//
//        @FXML
//                public void
    }

    @FXML
    public void handleExitButton(ActionEvent actionEvent)
    {
        Stage stage = (Stage) Main_Background.getScene().getWindow();
        stage.close();
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("start-screen.fxml"));
        Parent root = loader.load();
        scene = new Scene(root);

        primaryStage.setTitle("Stick Hero");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

}
