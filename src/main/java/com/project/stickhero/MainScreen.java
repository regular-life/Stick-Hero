//package com.project.stickhero;
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.layout.StackPane;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//import javafx.scene.transform.Rotate;
//import javafx.scene.transform.Scale;
//import javafx.stage.Stage;
//
//public class MainScreen extends Application {
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Create a rectangle
//        Rectangle block = new Rectangle(100, 50, Color.BLUE);
//
//        // Apply translation (move the block)
//        block.setTranslateX(100);
//        block.setTranslateY(100);
//
//        // Apply rotation
//        Rotate rotate = new Rotate(45, 50, 25); // angle, pivotX, pivotY
//        block.getTransforms().add(rotate);
//
//        primaryStage.setTitle("Block Transformation Example");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
