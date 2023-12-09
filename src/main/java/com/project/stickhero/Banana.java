package com.project.stickhero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Banana {
    private static final ImageView bananaImageView;
    private Double BANANA_X ;
    private final Double BANANA_Y = 436.0;

    static {
        // Load the image using a relative path that works across different systems
        String imagePath = "/assets/Banana.png";
        Image bananaImage = new Image(Objects.requireNonNull(Banana.class.getResourceAsStream(imagePath)));
        bananaImageView = new ImageView(bananaImage);
    }

    public static ImageView getBananaImageView() {
        return bananaImageView;
    }

    public void addImage() {
        // randomize double x, y to be between startBlock and endBlock's X coordinates, it's Y coordinate does not change
        BANANA_X = (Math.random() * (PlayScreenController.getEndBlock().getX() - PlayScreenController.getStartBlock().getX())) + PlayScreenController.getStartBlock().getX();
        bananaImageView.setX(BANANA_X);
        PlayScreenController.getBackGround().getChildren().add(bananaImageView);
    }


}
