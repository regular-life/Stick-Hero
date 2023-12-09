package com.project.stickhero;

import com.almasb.fxgl.inventory.ItemData;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SnapshotResult;
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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.BindException;
import java.util.Objects;

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
    private static final double MIN_WIDTH = 75.0;
    private static final double MAX_WIDTH = 100.0;
    private Timeline bridgeGrowthTimeline;
    private Timeline bridgeRotate;
    private TranslateTransition MushroomTimeline;
    private TranslateTransition startBlockTranslate;
    private TranslateTransition endBlockTranslate;

    private Rotate rotate;

//    private Timeline translate;

    boolean success = false;

    public Button getBB() {
        return BB;
    }

    public void setBB(Button BB) {
        this.BB = BB;
    }

    public Rectangle getStartBlock() {
        return StartBlock;
    }

    public void setStartBlock(Rectangle startBlock) {
        StartBlock = startBlock;
    }

    public Rectangle getEndBlock() {
        return EndBlock;
    }

    public void setEndBlock(Rectangle endBlock) {
        EndBlock = endBlock;
    }

    public Rectangle getBridge() {
        return Bridge;
    }

    public void setBridge(Rectangle bridge) {
        Bridge = bridge;
    }

    public Rectangle getBridge2() {
        return Bridge2;
    }

    public void setBridge2(Rectangle bridge2) {
        Bridge2 = bridge2;
    }

    public ImageView getMushroom() {
        return Mushroom;
    }

    public void setMushroom(ImageView mushroom) {
        Mushroom = mushroom;
    }

    public Text getScore() {
        return Score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Timeline getBridgeGrowthTimeline() {
        return bridgeGrowthTimeline;
    }

    public void setBridgeGrowthTimeline(Timeline bridgeGrowthTimeline) {
        this.bridgeGrowthTimeline = bridgeGrowthTimeline;
    }

    public Timeline getBridgeRotate() {
        return bridgeRotate;
    }

    public void setBridgeRotate(Timeline bridgeRotate) {
        this.bridgeRotate = bridgeRotate;
    }

    public TranslateTransition getMushroomTimeline() {
        return MushroomTimeline;
    }

    public void setMushroomTimeline(TranslateTransition mushroomTimeline) {
        MushroomTimeline = mushroomTimeline;
    }

    public TranslateTransition getStartBlockTranslate() {
        return startBlockTranslate;
    }

    public void setStartBlockTranslate(TranslateTransition startBlockTranslate) {
        this.startBlockTranslate = startBlockTranslate;
    }

    public TranslateTransition getEndBlockTranslate() {
        return endBlockTranslate;
    }

    public void setEndBlockTranslate(TranslateTransition endBlockTranslate) {
        this.endBlockTranslate = endBlockTranslate;
    }

    public Rotate getRotate() {
        return rotate;
    }

    public void setRotate(Rotate rotate) {
        this.rotate = rotate;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setScore(Text score) {
        Score = score;
    }

    public Text getCounter() {
        return Counter;
    }

    public void setCounter(Text counter) {
        Counter = counter;
    }

    public AnchorPane getBackGround() {
        return BackGround;
    }

    public void setBackGround(AnchorPane backGround) {
        BackGround = backGround;
    }

    public Button getAddCherry() {
        return AddCherry;
    }

    public void setAddCherry(Button addCherry) {
        AddCherry = addCherry;
    }

    public int getCherryCount() {
        return cherryCount;
    }

    public void setCherryCount(int cherryCount) {
        this.cherryCount = cherryCount;
    }

    public void initialize() {

        Mushroom.setFitWidth(81);
        Mushroom.setFitHeight(70);
        Counter.setText("" + cherryCount);
        Image backgroundImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/background/back1.png")));
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

        StartBlock = new Rectangle();
        StartBlock.setLayoutX(0);
        StartBlock.setLayoutY(432);
        StartBlock.setWidth(100);
        StartBlock.setHeight(100);
        StartBlock.setFill(Color.BLACK);
        StartBlock.toFront();

        EndBlock = new Rectangle();
        EndBlock.setLayoutX(120);
        EndBlock.setLayoutY(432);
        EndBlock.setWidth(50);
        EndBlock.setHeight(100);
        EndBlock.setFill(Color.BLACK);
        EndBlock.toFront();
        BackGround.getChildren().add(StartBlock);
        BackGround.getChildren().add(EndBlock);

        Bridge = new Rectangle(10, 10, Color.RED);
        Bridge.setLayoutX(96);
        Bridge.setLayoutY(422);

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
    }

    private void moveBlocksLeft(Double XX)
    {
        startBlockTranslate = new TranslateTransition();
        startBlockTranslate.setNode(StartBlock);
        startBlockTranslate.setToX(-1 * 1000);
        startBlockTranslate.setDuration(Duration.seconds(2));
        startBlockTranslate.setCycleCount(1);
        startBlockTranslate.play();

        endBlockTranslate = new TranslateTransition();
        endBlockTranslate.setNode(EndBlock);
        endBlockTranslate.setByX(XX);
        endBlockTranslate.setDuration(Duration.seconds(2));
        endBlockTranslate.setCycleCount(1);
        endBlockTranslate.play();

//        System.out.println(XX + " but curr pos: " + EndBlock.getLayoutX());
//        StartBlock = EndBlock;
//        handleActionButtonAction();
    }

    private void moveMushroomLeft(Double mushroomX)
    {
        TranslateTransition mushroomTranslate = new TranslateTransition();
        mushroomTranslate.setNode(Mushroom);
        mushroomTranslate.setByX(mushroomX);
        mushroomTranslate.setDuration(Duration.seconds(2));
        mushroomTranslate.setCycleCount(1);
        mushroomTranslate.setOnFinished(actionEvent -> handleActionButtonAction());
        mushroomTranslate.play();
    }

    private void handleBBButtonPressed()
    {
//        System.out.println(EndBlock.getLayoutY());
        BackGround.getChildren().remove(Bridge);
        BackGround.getChildren().remove(Mushroom);
        Bridge = null;
        Mushroom = null;
        Mushroom = new ImageView(new Image(getClass().getResourceAsStream("/assets/cute mushroom idle (1).png")));
        Mushroom.setLayoutX(23);
        Mushroom.setLayoutY(370);
        Mushroom.setFitHeight(67.5);
        Mushroom.setFitWidth(81);
        Bridge = new Rectangle(10, 10, Color.RED);
        Bridge.setLayoutX(96);
        Bridge.setLayoutY(422);
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
//        System.out.println(Bridge.getLayoutX());
//        System.out.println(Bridge.getHeight());
//        System.out.println(EndBlock.getLayoutX());
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
                Score.setText("" + score);
                BackGround.getChildren().remove(Bridge);
                double xx = 96 - EndBlock.getWidth() - EndBlock.getLayoutX();
                moveBlocksLeft(xx);
                moveMushroomLeft(xx);
            }
            else{
                mushroomFall();
                //Pause Screen()
            }
        });

        bridgeRotate.setOnFinished(actionEvent -> {
            MushroomTimeline.play();
        });

        bridgeGrowthTimeline.stop();
        bridgeRotate.play();
    }

    private void handleAddCherryAction(ActionEvent event) {
        cherryCount++;
        Counter.setText("" + cherryCount);
        yourController.setPlayerScore(cherryCount);
    }
    private void handleActionButtonAction() {

        double maxWidth = BackGround.getWidth() - StartBlock.getWidth() - 10;
        double randomWidth = clamp(MIN_WIDTH, MAX_WIDTH, Math.random() * maxWidth);
        double randomPosition = (Math.random() *  250) + 96;

        BackGround.getChildren().remove(StartBlock);
        BackGround.getChildren().remove(EndBlock);

        StartBlock = new Rectangle();
        StartBlock.setLayoutX(96 - EndBlock.getWidth());
        StartBlock.setLayoutY(432);
        StartBlock.setWidth(EndBlock.getWidth());
        StartBlock.setHeight(100);
        StartBlock.setFill(Color.BLACK);
        StartBlock.toFront();

        EndBlock = new Rectangle();
        EndBlock.setLayoutX(randomPosition);
        EndBlock.setLayoutY(432);
        EndBlock.setWidth(randomWidth);
        EndBlock.setHeight(100);
        EndBlock.setFill(Color.BLACK);
        EndBlock.toFront();
        BackGround.getChildren().add(StartBlock);
        BackGround.getChildren().add(EndBlock);

//        System.out.println("ActionButton clicked! EndRectangle width: " + randomWidth + ", position: " + randomPosition);
    }
    private double clamp(double min, double max, double value) {
        return Math.max(min, Math.min(max, value));
    }

    // function to move the 2 bridges and the mushroom to left (using multi-threading). after second bridge has reached to the point where first bridge was, the player can then again extend stick and move accordingly. use timeline to show the movement.

    public void mushroomFall()
    {
        MushroomTimeline = new TranslateTransition();
        MushroomTimeline.setNode(Mushroom);
        MushroomTimeline.setByY(BackGround.getHeight() - Mushroom.getFitHeight());
        MushroomTimeline.setDuration(Duration.seconds(1.5));
        MushroomTimeline.setCycleCount(1);
        MushroomTimeline.play();
        MushroomTimeline.setOnFinished(actionEvent -> {
            System.out.println("Game Over! Mushroom has reached the ground");
        });
    }
}