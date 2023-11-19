package com.project.stickhero;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class HelloController {
    @FXML
    AnchorPane pane1;
    @FXML
    ImageView Img;
    @FXML
    ImageView Img2;
    @FXML
    ImageView Img3;
    @FXML
    Button button;

    public void initialize() {
        // Load the image using the relative path
        Image newImage = new Image(getClass().getResourceAsStream("/assets/images/welcomescreen/hero.png"));
        Image newImage2 = new Image(getClass().getResourceAsStream("/assets/images/welcomescreen/beta.png"));
        Image newImage3 = new Image(getClass().getResourceAsStream("/assets/images/welcomescreen/play.png"));

        Img.setImage(newImage);
        Img2.setImage(newImage2);
        Img3.setImage(newImage3);
        System.out.println("Image loaded successfully");
    }
}