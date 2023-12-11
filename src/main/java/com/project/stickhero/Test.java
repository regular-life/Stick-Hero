package com.project.stickhero;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.*;
import javafx.util.Duration;
import javafx.geometry.*;
import javafx.scene.effect.*;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.Objects;
import java.util.Random;

public class Test
{
    public PlayScreenController playScreenController;
    @org.junit.Test
    public void testClampWithinRange() {
        playScreenController = new PlayScreenController();

        double min = 5.0;
        double max = 10.0;
        double value = 7.5;

        double result = playScreenController.clamp(min, max, value);

        assertEquals(value, result, 0.01);
        System.out.println("Test1 clamp done") ;
    }
    @org.junit.Test
    public void testClampBelowMin() {
        playScreenController = new PlayScreenController();

        double min = 5.0;
        double max = 10.0;
        double value = 3.0;

        double result = playScreenController.clamp(min, max, value);

        assertEquals(min, result, 0.01);
        System.out.println("Test2 clamp done") ;
    }
    @org.junit.Test
    public void testClampAboveMax() {
        playScreenController = new PlayScreenController();

        double min = 5.0;
        double max = 10.0;
        double value = 12.0;

        double result = playScreenController.clamp(min, max, value);

        assertEquals(max, result, 0.01);
        System.out.println("Test3 clamp done") ;
    }



    public TextFileHandler textFileHandler;
    @org.junit.Test
    public void testReadDataFromTextFile() {
        textFileHandler = new TextFileHandler();

        String expected = "0";

        String result = textFileHandler.readDataFromTextFile();

        assertEquals(expected, result);
        System.out.println("Test1 TextFileHandler done") ;
    }

    @org.junit.Test
    public void testAddDataToTextFile() {
        textFileHandler = new TextFileHandler();

        String expected = "0";

        textFileHandler.addDataToTextFile(expected);

        String result = textFileHandler.readDataFromTextFile();

        assertEquals(expected, result);
        System.out.println("Test2 TextFileHandler done") ;
    }
}