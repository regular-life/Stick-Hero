package com.project.stickhero;

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

public class PlayScreenController
{
    public boolean walking = false;
    public boolean isFlipped = false;
    public ImageView Banana1;
    public Button BB;
    public Rectangle StartBlock;
    public Rectangle EndBlock;
    public Rectangle Bridge;
    public Rectangle Bridge2;
    public ImageView Mushroom;
    public Text Score;

    public Button BB2;

    @FXML
    private Text Counter;
    @FXML
    private AnchorPane BackGround;
    @FXML
    private Button AddCherry;
    private Boolean CherryCollect;
    private int cherryCount = 0;
    public static int cherries ;
    public static int score = 0;
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
        PlayScreenController.score = score;
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

    private static MediaPlayer createPlayer(String resourcePath) {
        URL mediaUrl = MainScreen.class.getResource(resourcePath);
        if (mediaUrl == null) {
            throw new RuntimeException("Resource not found: " + resourcePath);
        }
        Media sound = new Media(mediaUrl.toString());
        return new MediaPlayer(sound);
    }

    private TranslateTransition createAnimation(ImageView imageView) {
        TranslateTransition animation = new TranslateTransition(Duration.seconds(1), imageView);
        animation.setByX(400);
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.setAutoReverse(true);
        animation.play();
        return animation;
    }

    public void initialize() {

        cherryCount = cherries ;

        CherryCollect = false;

        Mushroom.setLayoutX(23);
        Mushroom.setLayoutY(370);
        Mushroom.setFitHeight(67.5);
        Mushroom.setFitWidth(81);
        Counter.setText("" + cherryCount);
        Image backgroundImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/background/back1.png")));
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
        );

        Button pauseButton = new Button("Pause");
        BackGround.getChildren().add(pauseButton);
        BorderPane.setAlignment(pauseButton, Pos.CENTER);
        BorderPane.setMargin(pauseButton, new Insets(5));

//        TranslateTransition animation = createAnimation(Mushroom);

        pauseButton.setOnAction(e -> {
//            animation.pause();
            BackGround.setEffect(new GaussianBlur());

            VBox pauseRoot = new VBox(5);
            pauseRoot.getChildren().add(new Text("Paused"));
            pauseRoot.setStyle("-fx-background-color: rgba(255, 255, 255, 0.8);");
            pauseRoot.setAlignment(Pos.CENTER);
            pauseRoot.setPadding(new Insets(20));

            Button resume = new Button("Resume");
            pauseRoot.getChildren().add(resume);

            Stage popupStage = new Stage(StageStyle.TRANSPARENT);
            popupStage.initOwner((Stage) Mushroom.getScene().getWindow());
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setScene(new Scene(pauseRoot, Color.TRANSPARENT));

            resume.setOnAction(event -> {
                BackGround.setEffect(null);
//                animation.play();
                popupStage.hide();
            });

            popupStage.show();
        });



        Background backgroundObject = new Background(background);
        BackGround.setBackground(backgroundObject);


        BB.setOnMousePressed(event -> handleBBButtonPressed());
        BB.setOnMouseReleased(event -> handleBBButtonReleased());
        BB2.setOnMousePressed(mouseEvent -> Change_side());

        StartBlock = new Rectangle();
        StartBlock.setLayoutX(0);
        StartBlock.setLayoutY(432);
        StartBlock.setWidth(100);
        StartBlock.setHeight(100);
        StartBlock.setFill(Color.BLACK);
        StartBlock.toFront();

        EndBlock = new Rectangle();
        EndBlock.setLayoutX(240);
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

        CherryMaker();

        BackGround.getChildren().add(Bridge);
//        Bridge.setVisible(false);

        bridgeGrowthTimeline = new Timeline(
                new KeyFrame(Duration.seconds(0.05), e -> {
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
        endBlockTranslate.setDuration(Duration.seconds(1));
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
        mushroomTranslate.setDuration(Duration.seconds(1));
        mushroomTranslate.setCycleCount(1);
        mushroomTranslate.setOnFinished(actionEvent -> {
            Banana1.setVisible(false);
            handleActionButtonAction();
        });
        mushroomTranslate.play();
    }

    private void handleBBButtonPressed()
    {
        isFlipped = false;
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
                new KeyFrame(Duration.seconds(0.5), new KeyValue(rotate.angleProperty(), 90))
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
        Mushroom.translateXProperty().addListener((Observable)->{
            if(Mushroom.getBoundsInParent().intersects(Banana1.getBoundsInParent())){
                CherryCollect = true;
                Banana1.setVisible(false);
            }
        });
        MushroomTimeline.setOnFinished(actionEvent -> {
            walking = false;
            if(success  && !isFlipped){
                if(CherryCollect) {
                    handleAddCherryAction();
                    CherryCollect = false;
                }
                score++;
                Score.setText("" + score);
                BackGround.getChildren().remove(Bridge);
                double xx = 96 - EndBlock.getWidth() - EndBlock.getLayoutX();
                Banana1.setVisible(false);
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
            walking = true;
        });

        bridgeGrowthTimeline.stop();
        bridgeRotate.play();
    }

    private void Change_side(){
        if(walking) {
            if(!isFlipped) {
                Mushroom.setLayoutY(Mushroom.getLayoutY() + Mushroom.getFitHeight());
                isFlipped = !isFlipped;
            } else {
                Mushroom.setLayoutY(Mushroom.getLayoutY() - Mushroom.getFitHeight());
                isFlipped = !isFlipped;
            }
            Mushroom.setRotate(Mushroom.getRotate() + 180);
        }
    }
    private void handleAddCherryAction() {
        cherryCount++;
        cherries ++;
        Counter.setText("" + cherryCount);
//        yourController.setPlayerScore(cherryCount);
    }
    private void handleActionButtonAction() {

        Random random = new Random();
        double randomWidth = random.nextDouble(56 , 100);
        double rr = random.nextDouble(StartBlock.getLayoutX() + StartBlock.getWidth() + 60,300);

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
        EndBlock.setLayoutX(rr);
        EndBlock.setLayoutY(432);
        EndBlock.setWidth(randomWidth);
        EndBlock.setHeight(100);
        EndBlock.setFill(Color.BLACK);
        EndBlock.toFront();
        BackGround.getChildren().add(StartBlock);
        BackGround.getChildren().add(EndBlock);
        CherryMaker();
//        System.out.println("ActionButton clicked! EndRectangle width: " + randomWidth + ", position: " + randomPosition);
    }
    public double clamp(double min, double max, double value) {
        return Math.max(min, Math.min(max, value));
    }

    // function to move the 2 bridges and the mushroom to left (using multi-threading). after second bridge has reached to the point where first bridge was, the player can then again extend stick and move accordingly. use timeline to show the movement.

    public void mushroomFall()
    {
//        String resourcePath = "/assets/sound/fall.ogg";
//        MediaPlayer mediaPlayer = createPlayer(resourcePath);
//        mediaPlayer.play();

        score = Integer.parseInt(Score.getText()) ;
        MushroomTimeline = new TranslateTransition();
        MushroomTimeline.setNode(Mushroom);
        MushroomTimeline.setByY(BackGround.getHeight() - Mushroom.getFitHeight());
        MushroomTimeline.setDuration(Duration.seconds(1.5));
        MushroomTimeline.setCycleCount(1);
        MushroomTimeline.play();
        MushroomTimeline.setOnFinished(actionEvent -> {
            System.out.println("Game Over! Mushroom has reached the ground");
            try {
                // close current stage
                Stage stage = (Stage) BB.getScene().getWindow();
                FXMLLoader root = new FXMLLoader(getClass().getResource("GameOverScreenFXML.fxml"));
                Scene scene = new Scene(root.load());
                stage.setTitle("Game Over");
                stage.setScene(scene);
                stage.show();
                stage.setResizable(false);
            } catch (Exception e) {
                e.getMessage();
            }
        });
    }

    public void CherryMaker() {
        BackGround.getChildren().remove(Banana1);
        Banana1 = new ImageView(new Image(getClass().getResourceAsStream("/assets/Banana.png")));
        Banana1.setVisible(true);
        Random random = new Random();
        double randomValue = random.nextDouble(StartBlock.getWidth() + StartBlock.getLayoutX(), EndBlock.getLayoutX()-30);
        Banana1.setLayoutX(randomValue);
        Banana1.setLayoutY(440);
        Banana1.setFitHeight(20);
        Banana1.setFitWidth(20);
        Banana1.toFront();
        BackGround.getChildren().add(Banana1);
    }

    class ShapeFactory {
        public static Rectangle getShape(String shapeType, Rectangle Block) {//factory methods
            if (shapeType == null) {
                return null;
            } else if (shapeType.equalsIgnoreCase("StartBlock")) {
                Rectangle StartBlock = new Rectangle();
                StartBlock.setLayoutX(96 - Block.getWidth());
                StartBlock.setLayoutY(432);
                StartBlock.setWidth(Block.getWidth());
                StartBlock.setHeight(100);
                StartBlock.setFill(Color.BLACK);
                StartBlock.toFront();
                return StartBlock;
            } else if (shapeType.equalsIgnoreCase("EndBlock")) {
                Random random = new Random();
                double randomWidth = random.nextDouble(56, 100);
                double rr = random.nextDouble(Block.getLayoutX() + Block.getWidth() + 60, 300);
                Rectangle EndBlock = new Rectangle();
                EndBlock.setLayoutX(rr);
                EndBlock.setLayoutY(432);
                EndBlock.setWidth(randomWidth);
                EndBlock.setHeight(100);
                EndBlock.setFill(Color.BLACK);
                EndBlock.toFront();
                return EndBlock;
            }
            return null;
        }
}}

