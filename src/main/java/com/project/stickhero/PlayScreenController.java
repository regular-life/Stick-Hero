package com.project.stickhero;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class PlayScreenController {

    public Button BB;
    public Rectangle StartBlock;
    public Rectangle EndBlock;
    public Button ActionButton;
    public Rectangle Bridge;
    @FXML
    private Text Counter;
    @FXML
    private AnchorPane BackGround;
    @FXML
    private Button AddCherry;
    private int cherryCount = 0;
    private static final double MIN_WIDTH = 30.0;
    private static final double MAX_WIDTH = 100.0;

    private Timeline bridgeGrowthTimeline;
    private Timeline RotateTimeline;

    private boolean isBBButtonPressed = false;

    public void initialize() {
        Counter.setText("" + cherryCount);
        Image backgroundImage = new Image(getClass().getResourceAsStream("/assets/background/back1.png"));
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
        );

        Background backgroundObject = new Background(background);
        BackGround.setBackground(backgroundObject);

        AddCherry.setOnAction(this::handleAddCherryAction);
        ActionButton.setOnAction(this::handleActionButtonAction);

        BB.setOnMousePressed(event -> handleBBButtonPressed());
        BB.setOnMouseReleased(event -> handleBBButtonReleased());

        // Create a timeline for the bridge growth animation
        bridgeGrowthTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.1), e -> {
                    Bridge.setHeight(Bridge.getHeight() + 5);
                    Bridge.setLayoutY(Bridge.getLayoutY() - 5);
                })
        );

//        movePivot(Bridge, 10, 10);

        Rotate rotation = new Rotate();
        rotation.pivotXProperty().bind(Bridge.xProperty().add(Bridge.widthProperty().multiply(0))); // Center X
        rotation.pivotYProperty().bind(Bridge.yProperty().add(Bridge.heightProperty())); // Center Y


        Bridge.getTransforms().add(rotation);

        RotateTimeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rotation.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(0.5), new KeyValue(rotation.angleProperty(), 90)),
                new KeyFrame(Duration.ZERO, e -> {
            // This block will be executed when the timeline is reset to the initial state
            Bridge.setLayoutX(StartBlock.getLayoutX() + StartBlock.getWidth());
            Bridge.setLayoutY(BackGround.getHeight() - StartBlock.getHeight());
            Bridge.setHeight(0);
            Bridge.setVisible(true);
        })
        );

        RotateTimeline.setCycleCount(1);
        bridgeGrowthTimeline.setCycleCount(Timeline.INDEFINITE);
    }
    private void movePivot(Rectangle node, double x, double y){
        node.getTransforms().add(new Translate(-x,-y));
        node.setTranslateX(x); node.setTranslateY(y);
    }
    private void handleBBButtonPressed() {
        isBBButtonPressed = true;
        RotateTimeline.stop();
        if (isBBButtonPressed) {
            Bridge.setLayoutX(StartBlock.getLayoutX() + StartBlock.getWidth());
            Bridge.setLayoutY(BackGround.getHeight() - StartBlock.getHeight());
            Bridge.setHeight(0);
            Bridge.setVisible(true);
            bridgeGrowthTimeline.play();
        }
    }

    private void handleBBButtonReleased() {
        isBBButtonPressed = false;
        bridgeGrowthTimeline.stop();
        RotateTimeline.play();
    }
    private void handleAddCherryAction(ActionEvent event) {
        cherryCount++;
        Counter.setText("" + cherryCount);
        System.out.println("Cherry added!");
    }
    private void handleActionButtonAction(ActionEvent event) {
        double maxWidth = BackGround.getWidth() - StartBlock.getWidth() - 10;
        double randomWidth = clamp(MIN_WIDTH, MAX_WIDTH, Math.random() * maxWidth);
        double randomPosition = Math.random() * (maxWidth - randomWidth);

        EndBlock.setWidth(randomWidth);
        EndBlock.setLayoutX(StartBlock.getWidth() + 10 + randomPosition);

        System.out.println("ActionButton clicked! EndRectangle width: " + randomWidth + ", position: " + randomPosition);
    }
    private double clamp(double min, double max, double value) {
        return Math.max(min, Math.min(max, value));
    }
}