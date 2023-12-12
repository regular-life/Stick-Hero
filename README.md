# Stick-Hero

<br />

## Introduction
Stick Hero is a simple Java game developed using JavaFX. It provides an engaging gaming experience where players control a character to jump between platforms and collect cherries. The game features multiple screens, including a main menu, gameplay screen, and game-over screen.

## Table of Contents
1. [How to Run the Game](#how-to-run-the-game)
2. [Code Structure](#code-structure)
3. [Screen Connection Map](#screen-connection-map)
4. [Testing](#testing)
5. [Contributors](#contributors)

## How to Run the Game
1. **Prerequisites:**
   - Java Development Kit (JDK) installed on your computer.
   - Apache Maven installed.

2. **Cloning the Repository:**
   - Clone the repository to your local machine using the following command:
     ```bash
     git clone https://github.com/regular-life/Stick-Hero.git
     ```
     **OR**
   - Download the .zip file from https://github.com/regular-life/Stick-Hero.

3. **Running the Game:**
   - Open a terminal.
   - Navigate to the project directory.
   - Run the following Maven commands:
     ```bash
     mvn javafx:run
     ```
   - To clean the JAR files, run the following:
    ```bash
    mvn clean
    ```
   - Alternatively, you can run the game directly from the IDE by locating the `MainScreen.java` file and running `MainScreen.main()`.

4. **Playing the Game:**
   - Use button controls to navigate and jump in the game.
   - Collect cherries and avoid falling off the platforms.
   - Try to achieve the highest score.

## Code Structure
The Stick Hero game consists of multiple classes, each responsible for a specific part of the game. Here's an overview of the key classes:

### 1. MainScreen.java
   - Launches the main menu screen.
   - Integrates background music.

### 2. MainScreenController.java
   - Controls main menu interactions.
   - Handles events like starting the game.

### 3. PlayScreen.java
   - Displays the gameplay screen.
   - Loads layout from FXML.

### 4. PlayScreenController.java
   - Manages gameplay logic.
   - Handles player movements and scoring.

### 5. GameOverScreen.java
   - Displays the game-over screen.
   - Shows final score and options.

### 6. GameOverScreenController.java
   - Controls game-over interactions.
   - Manages score display and high scores.

### 7. Test.java
   - Contains JUnit tests covering various aspects of the game logic.

### 8. TestRunner.java
   - Executes the JUnit tests in the `Test` class.

### 9. TextFileHandler.java
   - Handles reading and writing data to a text file.

## Screen Connection Map
```
+---------------------+          +------------------------+          +-----------------------+
|    MainScreen      |   start  |    PlayScreen          |   game   |    GameOverScreen     |
|---------------------| -------->|------------------------| -------->|-----------------------|
| MainScreenController|          | PlayScreenController   |          | GameOverScreenController|
+---------------------+          +------------------------+          +-----------------------+
```

## Testing
The game includes a set of JUnit tests in the `Test` class, covering various aspects such as clamping values and handling text file operations. The `TestRunner` class executes these tests.

<br />

---

## Contributors
- Nakul Garg - [GitHub Profile](https://github.com/NakulGarg-IIITD)
- Yash Bhardwaj - [GitHub Profile](https://github.com/regular-life)

Feel free to reach to any of us at yash22586@iiitd.ac.in or nakul22309@iiitd.ac.in for any questions or issues related to the above project.
