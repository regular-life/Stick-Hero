package com.project.stickhero;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class yourController {

    @FXML
    private static Text playerScoreText;

    private static int playerScore;

    public static Text getPlayerScoreText() {
        return playerScoreText;
    }

    public void setPlayerScoreText(Text playerScoreText) {
        this.playerScoreText = playerScoreText;
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
}
