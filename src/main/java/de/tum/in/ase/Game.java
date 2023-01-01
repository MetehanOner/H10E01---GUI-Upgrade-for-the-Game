package de.tum.in.ase;

import de.tum.in.ase.logic.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.List;

public class Game extends Application {
    private GameBoard gameBoard;
    private Hero hero;
    private GridPane gridPane = new GridPane();
    private Button[][] buttons = new Button[SIZE_X][SIZE_Y];
    private List<Button> directionButtons;
    private List<Button> specialDirectionButtons;
    private HBox firstControlButtonsRow;
    private HBox secondControlButtonsRow;

    // Constants used for configuration/setup.
    private static final int SIZE_X = 5;
    private static final int SIZE_Y = 5;
    private Scene scene;
    private Stage stage;
    private static final double BUTTON_SIZE = 70;
    private static final double SCENE_WIDTH = 400;
    private static final double SCENE_HEIGHT = 550;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        // Do not change the hero type.
        this.hero = new Mage(this);
        this.gameBoard = new GameBoard(SIZE_X, SIZE_Y);

        // TODO: Task 1.1, Initialization of the gameBoard visualization.

        // TODO: Task 1.2, Movement buttons configuration.

        // TODO: Task 1.3, Ability buttons configuration.

        // TODO: Task 2.1, Add an HBox for the movement buttons, an HBox for the ability buttons and add them to a VBox. Add the VBox to the gridPane.

        // Stage setup.
        stage.setScene(scene);
        stage.setTitle("Game");
        stage.setResizable(false);
        stage.show();

        // Displaying actual game status.
        updateUI();
    }

    /**
     * Applies custom (inline) css to the buttons.
     *
     * @param buttonsList List of the buttons without styles.
     */
    private void applyStyleForButtons(List<Button> buttonsList) {
        // TODO: Task 1.2, Movement buttons configuration.
    }

    /**
     * Adds functionality to specified direction buttons.
     * When a direction button is clicked, it will call the move method with the corresponding direction and then update the UI.
     */
    private void addDirectionButtonsFunctionality() {
        // TODO: Task 1.2, Movement buttons configuration.
    }

    /**
     * Adds functionality to specified hero's special ability buttons.
     * When a hero's special ability button is clicked, it will call the hero's special ability method with the corresponding direction and then update the UI.
     */
    private void addSpecialDirectionButtonsFunctionality() {
        // TODO: Task 1.3, Ability buttons configuration.
    }

    /**
     * Updates the current game status by updating text of the buttons in the
     * gridPane.
     */
    private void updateUI() {
        for (int i = 0; i < gameBoard.getSizeX(); i++) {
            for (int j = 0; j < gameBoard.getSizeY(); j++) {
                // TODO: Task 1.1
                // Uncomment this line, once you have implemented Task 1
                // buttons[i][j].setText(String.valueOf(gameBoard.get(i, j)));
            }
        }
    }

    /**
     * Moves the character on the gameBoard in the indicated direction.
     *
     * @param direction Direction to move.
     * @throws IllegalMoveException Thrown if unsupported move has been detected.
     */
    public void move(char direction) throws IllegalMoveException {
        int deltaX = 0;
        int deltaY = 0;
        if (direction == 'L') {
            deltaX = -1;
            if (this.hero.getPosX() == 0) {
                throw new IllegalMoveException("IllegalMoveException: Cannot move left, out of bounds!");
            }
        } else if (direction == 'R') {
            deltaX = 1;
            if (this.hero.getPosX() == this.gameBoard.getSizeX() - 1) {
                throw new IllegalMoveException("IllegalMoveException: Cannot move right, out of bounds!");
            }
        } else if (direction == 'U') {
            deltaY = -1;
            if (this.hero.getPosY() == 0) {
                throw new IllegalMoveException("IllegalMoveException: Cannot move up, out of bounds!");
            }
        } else if (direction == 'D') {
            deltaY = 1;
            if (this.hero.getPosY() == this.gameBoard.getSizeY() - 1) {
                throw new IllegalMoveException("IllegalMoveException: Cannot move down, out of bounds!");
            }
        }
        if (this.gameBoard.get(this.hero.getPosX() + deltaX, this.hero.getPosY() + deltaY) == 'M') {
            informationAlert("You died!", "A monster has killed you!");
            restart();
        }
        this.gameBoard.set(this.hero.getPosX(), this.hero.getPosY(), '_');
        this.hero.setPosX(this.hero.getPosX() + deltaX);
        this.hero.setPosY(this.hero.getPosY() + deltaY);
        this.gameBoard.set(this.hero.getPosX(), this.hero.getPosY(), 'H');
        if (isWon()) {
            informationAlert("You won!", "You won the game!");
            restart();
        }
    }

    private void restart() {
        stage.close();
        Game game = new Game();
        game.start(stage);
    }

    /**
     * Shows user information alert.
     *
     * @param title   Title of the alert window.
     * @param content Content text of the alert.
     */
    private void informationAlert(String title, String content) {
        // TODO: Task 2.2, Displaying information alerts.
    }

    /**
     * Verify if the hero reached the goal.
     *
     * @return Result of the verification.
     */
    public boolean isWon() {
        return gameBoard.get(gameBoard.getSizeX() - 1, gameBoard.getSizeY() - 1) == 'H' && this.hero.getPosX() == gameBoard.getSizeX() - 1 && this.hero.getPosY() == gameBoard.getSizeY() - 1;
    }

    // Required for logic.
    public GameBoard getGameBoard() {
        return this.gameBoard;
    }

    // Required for logic.
    public Hero getHero() {
        return this.hero;
    }

}
