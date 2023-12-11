Stick Hero Game

Overview:
Stick Hero is a simple game where the player controls a character (represented by a mushroom) that needs to cross a gap between two platforms. The player can extend a stick to bridge the gap and must release the stick at the right time to successfully reach the other side. The game also features collectible cherries that increase the player's score.

Features:
- Stick Extension: Press and hold the button to extend the stick.
- Stick Release: Release the button to drop the stick and bridge the gap.
- Dynamic Platforms: Platforms (start and end blocks) change size and position with each successful crossing.
- Cherry Collection: Collect cherries on successful crossings to increase your score.
- Game Over: If the mushroom falls without bridging the gap, the game ends.

How to Play:
1. Run the Stick Hero game.
2. Press and hold the button (BB) to extend the stick.
3. Release the button to drop the stick and bridge the gap.
4. Successfully cross the gap to continue playing.
5. Collect cherries to increase your score.
6. If the mushroom falls without bridging the gap, the game ends.

Code Structure:
- Main Class: PlayScreenController - Manages the game screen, controls, and animations.
- FXML: PlayScreenFXML.fxml - Defines the game screen layout using JavaFX.
- Assets: /assets - Contains images and sounds used in the game.

Classes and Methods:
- PlayScreenController
  - initialize(): Initializes the game elements and sets up the background.
  - handleBBButtonPressed(): Handles the stick extension when the button is pressed.
  - handleBBButtonReleased(): Handles the stick release and checks for successful crossing.
  - Change_side(): Flips the mushroom to the other side during gameplay.
  - handleAddCherryAction(): Handles the collection of cherries.
  - handleActionButtonAction(): Handles the creation of new platforms.
  - mushroomFall(): Initiates the falling animation when the mushroom fails to cross.
  - CherryMaker(): Creates cherries on the platforms.

Dependencies:
- JavaFX: Used for the graphical user interface.
- FXML: Defines the game screen layout.
- Media and Animation: Utilizes JavaFX for media (sounds) and animations.

How to Customize:
- Adjust platform creation parameters in handleActionButtonAction() for different platform sizes and positions.
- Modify the CherryMaker() method for customizing cherry appearance and placement.
- Customize the game over screen in the mushroomFall() method.
- Explore additional JavaFX features to enhance the game's visuals and user experience.

License:
This Stick Hero game is licensed under [License Name]. See the LICENSE file for details.
