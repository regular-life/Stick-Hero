package com.project.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static com.project.stickhero.PlayScreenController.cherries;
import static com.project.stickhero.PlayScreenController.score;

public class GameOverScreenController
{

    @FXML
    AnchorPane root ;
    @FXML
    private Text scoreText;

    @FXML
    private Text highestScoreText;

    @FXML
    private Stage stage ;

    @FXML
    private Scene scene ;


    public AnchorPane getRoot() {
        return root;
    }

    public void setRoot(AnchorPane root) {
        this.root = root;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Text getScoreText() {
        return scoreText;
    }

    public void setScoreText(Text scoreText) {
        this.scoreText = scoreText;
    }

    public Text getHighestScoreText() {
        return highestScoreText;
    }

    public void setHighestScoreText(Text highestScoreText) {
        this.highestScoreText = highestScoreText;
    }

    public void initialize()
    {
        highestScoreText.setText(TextFileHandler.readDataFromTextFile());
        System.out.println(highestScoreText.getText());
        scoreText.setText(String.valueOf(score));
    }

    @FXML
    public void handleRestart(ActionEvent event) throws IOException
    {
        if (score > Integer.parseInt(highestScoreText.getText()))
        {
            TextFileHandler.addDataToTextFile(String.valueOf(score));
            highestScoreText.setText(String.valueOf(score));
        }
        score = 0 ;
        cherries = 0 ;
//        System.out.println("restart");
        Parent roo = FXMLLoader.load(getClass().getResource("PlayScreenFXML.fxml"));
//        System.out.println("Fuck");
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(roo);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleQuit()
    {
        if (score > Integer.parseInt(highestScoreText.getText()))
        {
            TextFileHandler.addDataToTextFile(String.valueOf(score));
            highestScoreText.setText(String.valueOf(score));
        }
        System.exit(0);
    }

    @FXML
    public void handleRevive(ActionEvent event) throws IOException
    {
        if (cherries >= 5)
        {
            cherries -= 5 ;
            Parent roo = FXMLLoader.load(getClass().getResource("PlayScreenFXML.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(roo);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            // add popup which says "You need atleast 5 bananas to Revive!"
            showPopup("You need atleast 5 cherries to Revive!");
        }
    }

    private void showPopup(String message)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

