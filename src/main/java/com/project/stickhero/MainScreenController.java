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


public class MainScreenController
{

    @FXML
    AnchorPane root ;

    @FXML
    private Stage stage ;

    @FXML
    private Scene scene ;


    public void initialize(){;}

    @FXML
    public void handleStart(ActionEvent event) throws IOException
    {
        Parent roo = FXMLLoader.load(getClass().getResource("PlayScreenFXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(roo);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleExit()
    {
        System.exit(0);
    }
}

