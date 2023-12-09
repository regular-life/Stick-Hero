package com.project.stickhero;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.net.BindException;

public class PlayScreenController
{

    public Button BB;
    public Rectangle StartBlock;
    public Rectangle EndBlock;
    public Rectangle Bridge;
    public Rectangle Bridge2;
    public ImageView Mushroom;
    public Text Score;

    @FXML
    private Text Counter;
    @FXML
    private AnchorPane BackGround;
    @FXML
    private Button AddCherry;

    private int cherryCount = 0;
    private int score = 0;
    private static final double MIN_WIDTH = 30.0;
    private static final double MAX_WIDTH = 100.0;
    private Timeline bridgeGrowthTimeline;
    private Timeline bridgeRotate;
    private TranslateTransition MushroomTimeline;

    private Rotate rotate;

    boolean success = false;

    public void initialize() {
        Mushroom.setFitWidth(81);
        Mushroom.setFitHeight(70);
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

        BB.setOnMousePressed(event -> handleBBButtonPressed());
        BB.setOnMouseReleased(event -> handleBBButtonReleased());

        Bridge = new Rectangle(10, 10, Color.RED);
        Bridge.setLayoutX(StartBlock.getLayoutX() + StartBlock.getWidth());
        Bridge.setLayoutY(StartBlock.getLayoutY() - 10);

        BackGround.getChildren().add(Bridge);
//        Bridge.setVisible(false);

        bridgeGrowthTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.1), e -> {
                    Bridge.setHeight(Bridge.getHeight() + 5);
                    Bridge.setLayoutY(Bridge.getLayoutY() - 5);
                })
        );
        bridgeGrowthTimeline.setCycleCount(Timeline.INDEFINITE);

        bridgeGrowthTimeline.stop();
//        moveBridgesAndMushroomToLeft(Bridge, Bridge2, Mushroom);
    }
    private void handleBBButtonPressed() {
        handleActionButtonAction();

        BackGround.getChildren().remove(Bridge);
        BackGround.getChildren().remove(Mushroom);
        Bridge = null;
        Mushroom = null;
        Mushroom = new ImageView(new Image(getClass().getResourceAsStream("/assets/cute mushroom idle (1).png")));
        Mushroom.setLayoutX(13);
        Mushroom.setLayoutY(370);
        Mushroom.setFitHeight(67.5);
        Mushroom.setFitWidth(81);
        Bridge = new Rectangle(10, 10, Color.RED);
        Bridge.setLayoutX(StartBlock.getLayoutX() + StartBlock.getWidth());
        Bridge.setLayoutY(StartBlock.getLayoutY() - 10);
        BackGround.getChildren().add(Bridge);
        BackGround.getChildren().add(Mushroom);

        Bridge.setHeight(10);
        rotate = null;
        bridgeRotate = null;

        rotate = new Rotate();

        rotate.pivotXProperty().bind(Bridge.xProperty().add(Bridge.widthProperty().multiply(0))); // Center X
        rotate.pivotYProperty().bind(Bridge.yProperty().add(Bridge.heightProperty())); // Center Y

        Bridge.getTransforms().add(rotate);

        bridgeRotate = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rotate.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(rotate.angleProperty(), 90))
        );
//        MushroomTimeline.setOnFinished(actionEvent -> moveBridgesAndMushroomToLeft(Bridge, Bridge2, Mushroom));
        bridgeRotate.setCycleCount(1);

        bridgeRotate.stop();
        bridgeGrowthTimeline.play();
    }

    private void handleBBButtonReleased() {
        double endBlockMiddle = EndBlock.getLayoutX() + EndBlock.getWidth() / 2;
        double distanceToMiddle = endBlockMiddle - Mushroom.getLayoutX() - Mushroom.getFitWidth() / 2;
        System.out.println(Bridge.getLayoutX());
        System.out.println(Bridge.getHeight());
        System.out.println(EndBlock.getLayoutX());
        MushroomTimeline = new TranslateTransition();
        MushroomTimeline.setNode(Mushroom);
        if((Bridge.getLayoutX()+Bridge.getHeight())> EndBlock.getLayoutX()) {
            success = true;
            MushroomTimeline.setByX(distanceToMiddle);
        }
        else {
            success = false;
            MushroomTimeline.setByX(Mushroom.getLayoutX()+Bridge.getHeight() + 30);
        }
        MushroomTimeline.setDuration(Duration.seconds(2));
        MushroomTimeline.setCycleCount(1);
        MushroomTimeline.setOnFinished(actionEvent -> {
            if(success){
                score++;
                Score.setText("" + cherryCount);
            }
        });

        bridgeRotate.setOnFinished(actionEvent -> {
            MushroomTimeline.play();
        });

        bridgeGrowthTimeline.stop();
        bridgeRotate.play();
//        MushroomTimeline.setOnFinished(actionEvent -> moveBridgesAndMushroomToLeft(Bridge, Bridge2, Mushroom));
    }

    private void handleAddCherryAction(ActionEvent event) {
        cherryCount++;
        Counter.setText("" + cherryCount);
//        System.out.println("Cherry added!");
    }
    private void handleActionButtonAction() {
        double maxWidth = BackGround.getWidth() - StartBlock.getWidth() - 10;
        double randomWidth = clamp(MIN_WIDTH, MAX_WIDTH, Math.random() * maxWidth);
        double randomPosition = Math.random() * (maxWidth - randomWidth);

        EndBlock.setWidth(randomWidth);
        EndBlock.setLayoutX(StartBlock.getWidth() + 10 + randomPosition);

//        System.out.println("ActionButton clicked! EndRectangle width: " + randomWidth + ", position: " + randomPosition);
    }
    private double clamp(double min, double max, double value) {
        return Math.max(min, Math.min(max, value));
    }

    // function to move the 2 bridges and the mushroom to left (using multi-threading). after second bridge has reached to the point where first bridge was, the player can then again extend stick and move accordingly. use timeline to show the movement.
    private void moveBridgesAndMushroomToLeft(Rectangle LeftBridge, Rectangle RightBridge, ImageView Mushroom)
    {
        Double X = LeftBridge.getLayoutX();
        Thread left = new Thread(new MultithreadBridge(LeftBridge, X));
        Thread right = new Thread(new MultithreadBridge(RightBridge, X));
        Thread mushroom = new Thread(new MultithreadingMushroom(Mushroom, X));
        left.run();
        right.run();
        mushroom.run();
    }
}

class MultithreadBridge implements Runnable
{
    private Rectangle bridge;
    private Timeline bridgeLeftTimeline;
    private Double X;

    public MultithreadBridge(Rectangle bridge, Double X) {
        this.bridge = bridge;
        this.X = X;
    }

    public Rectangle getBridge() {
        return bridge;
    }

    public void setBridge(Rectangle bridge) {
        this.bridge = bridge;
    }

    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
            bridgeLeftTimeline = new Timeline(
                    new KeyFrame(Duration.seconds(2), new KeyValue(bridge.layoutXProperty(), this.X))
            );
            bridgeLeftTimeline.setCycleCount(1);
            bridgeLeftTimeline.play();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class MultithreadingMushroom implements Runnable {
    private ImageView mushroom;
    private TranslateTransition mushroomTimeline;
    private Double X ;

    public MultithreadingMushroom(ImageView mushroom, Double X) {
        this.mushroom = mushroom;
        this.X = X;
    }

    public ImageView getMushroom() {
        return mushroom;
    }

    public void setMushroom(ImageView mushroom) {
        this.mushroom = mushroom;
    }

    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
            // movement by timeline
            mushroomTimeline = new TranslateTransition();
            mushroomTimeline.setNode(mushroom);
            mushroomTimeline.setByX(this.X);
            mushroomTimeline.setDuration(Duration.seconds(5));
            mushroomTimeline.setCycleCount(1);
            mushroomTimeline.play();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}