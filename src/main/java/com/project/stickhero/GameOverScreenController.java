package com.project.stickhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static com.project.stickhero.PlayScreenController.score;

public class GameOverScreenController
{

    @FXML
    AnchorPane root ;
    @FXML
    private Text scoreText;

    @FXML
    private Text highestscoreText;

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

    public Text getscoreText() {
        return scoreText;
    }

    public void setscoreText(Text scoreText) {
        this.scoreText = scoreText;
    }

    public Text getHighestscoreText() {
        return highestscoreText;
    }

    public void setHighestscoreText(Text highestscoreText) {
        this.highestscoreText = highestscoreText;
    }

    public void initialize()
    {

        highestscoreText.setText(TextFileHandler.readDataFromTextFile());
        System.out.println(highestscoreText.getText());
        scoreText = new Text(String.valueOf(score));
    }

    @FXML
    public void handleRestart(ActionEvent event) throws IOException
    {
        if (score > Integer.parseInt(highestscoreText.getText()))
        {
            TextFileHandler.addDataToTextFile(String.valueOf(score));
        }

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
        if (score > Integer.parseInt(highestscoreText.getText()))
        {
            TextFileHandler.addDataToTextFile(String.valueOf(score));
        }
        System.exit(0);
    }

    @FXML
    public void handleRevive()
    {
        // to do
    }
}

