package com.project.stickhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.util.Vector;

class HomePage
{
    private Scene background ;

    public Scene getBackground() {
        return background;
    }

    public void setBackground(Scene background) {
        this.background = background;
    }

    void clickStart()
    {

    }
    void clickExit()
    {

    }
}

class GameOverScreen
{
    private GameScreen background ;

    public GameScreen getBackground() {
        return background;
    }

    public void setBackground(GameScreen background) {
        this.background = background;
    }

    public void generateScreen()
    {

    }
    public void clickExit()
    {

    }
    public void clickPlayAgain()
    {

    }
}

class GameScreen
{
    private Background background ;
    private Character character ;
    private Vector<Gold> gold ;

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Vector<Gold> getGold() {
        return gold;
    }

    public void setGold(Vector<Gold> gold) {
        this.gold = gold;
    }

    public void backgroundRight()
    {}
    public void update()
    {

    }
    public void generateGold()
    {

    }
}

class Gold
{
    private Image image ;
    private Pair<Double, Double> location ;
    private Boolean isCollected ;
    private GameScreen gameScreen ;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Pair<Double, Double> getLocation() {
        return location;
    }

    public void setLocation(Pair<Double, Double> location) {
        this.location = location;
    }

    public Boolean getCollected() {
        return isCollected;
    }

    public void setCollected(Boolean collected) {
        isCollected = collected;
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    public void setGameScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void generateOnPath()
    {

    }
    public void disappear()
    {

    }
}

class Character
{
    private Vector<Image> images ;
    private Integer score ;
    private Double x_coord ;
    private Double y_coord ;
    private Stick path ;
    private Boolean isUpsideDown ;
    private Tower currentTower ;
    private Tower nextTower ;

    public Vector<Image> getImages() {
        return images;
    }

    public void setImages(Vector<Image> images) {
        this.images = images;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Double getX_coord() {
        return x_coord;
    }

    public void setX_coord(Double x_coord) {
        this.x_coord = x_coord;
    }

    public Double getY_coord() {
        return y_coord;
    }

    public void setY_coord(Double y_coord) {
        this.y_coord = y_coord;
    }

    public Stick getPath() {
        return path;
    }

    public void setPath(Stick path) {
        this.path = path;
    }

    public Boolean getUpsideDown() {
        return isUpsideDown;
    }

    public void setUpsideDown(Boolean upsideDown) {
        isUpsideDown = upsideDown;
    }

    public Tower getCurrentTower() {
        return currentTower;
    }

    public void setCurrentTower(Tower currentTower) {
        this.currentTower = currentTower;
    }

    public Tower getNextTower() {
        return nextTower;
    }

    public void setNextTower(Tower nextTower) {
        this.nextTower = nextTower;
    }

    public void generateCharacter()
    {

    }
    public void movePath()
    {

    }
    public void collectGold()
    {

    }
    public void fallDown()
    {

    }
    public void gameOver()
    {

    }
}

class Stick
{
    private final Double width = 10.0 ;
    private Double height ;
    private Tower nextTower ;
    private Double angle ;

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Tower getNextTower() {
        return nextTower;
    }

    public void setNextTower(Tower nextTower) {
        this.nextTower = nextTower;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public void generateStick()
    {

    }
    public void rotateStick()
    {

    }
}

class Tower
{
    private Image image ;
    private Double width ;
    private Double height ;
    private Double x_coord ;
    private Double y_coord ;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getX_coord() {
        return x_coord;
    }

    public void setX_coord(Double x_coord) {
        this.x_coord = x_coord;
    }

    public Double getY_coord() {
        return y_coord;
    }

    public void setY_coord(Double y_coord) {
        this.y_coord = y_coord;
    }

    public void generateTower()
    {

    }
    public void show()
    {

    }
}

class Background
{
    private Image image ;
    private Double left_limit_for_image ;
    private Double right_limit_for_image ;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Double getLeft_limit_for_image() {
        return left_limit_for_image;
    }

    public void setLeft_limit_for_image(Double left_limit_for_image) {
        this.left_limit_for_image = left_limit_for_image;
    }

    public Double getRight_limit_for_image() {
        return right_limit_for_image;
    }

    public void setRight_limit_for_image(Double right_limit_for_image) {
        this.right_limit_for_image = right_limit_for_image;
    }
    public void moveRight()
    {

    }
    public void moveLeft()
    {

    }
    public void show()
    {
        
    }
}

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Stick Hero");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    public static void main(String[] args) {
        launch();
    }
}
