package com.project.stickhero;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static com.project.stickhero.StartController.Main_Background;

public class GameOverController extends Application
{

    @FXML
    private static Text playerScoreText;

    private static int playerScore;

    public static Text getPlayerScoreText() {
        return playerScoreText;
    }

    public void setPlayerScoreText(Text playerScoreText) {
        GameOverController.playerScoreText = playerScoreText;
    }

    public static int getPlayerScore() {
        return playerScore;
    }

    public static void setPlayerScore(int score) {
        playerScore = score;
        updatePlayerScoreText();
    }

    private static void updatePlayerScoreText() {
        if (playerScoreText != null) {
            playerScoreText.setText("Player Score: " + playerScore);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader root = new FXMLLoader(PlayScreen.class.getResource("game-over-view.fxml"));
        Scene scene = new Scene(root.load());
        Stage primaryStage = (Stage) Main_Background.getScene().getWindow();
        playerScoreText = (Text) "Player Score: " + playerScore ;

        primaryStage.setTitle("Game Over");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public void restartAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) Main_Background.getScene().getWindow();
        stage.close();
        StartController.handleStartButton();
    }

    public void exitAction(ActionEvent actionEvent)
    {
        Stage stage = (Stage) Main_Background.getScene().getWindow();
        stage.close();
        System.exit(0);
    }
}
