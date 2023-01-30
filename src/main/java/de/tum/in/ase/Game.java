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
import java.util.ArrayList;
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
        GridPane gpane = new GridPane();

        gpane.setHgap(3);
        gpane.setVgap(2);

        directionButtons = new ArrayList<>();
        specialDirectionButtons = new ArrayList<>();

        for (int i=0; i < gameBoard.getSizeX(); i++) {

            for (int j=0; j < gameBoard.getSizeY(); j++) {

                Button button = new Button();
                button.setTextAlignment(TextAlignment.CENTER);
                button.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
                button.setStyle("-fx-background-color: rgba(244, 67, 54, 0.75); " +
                        "-fx-border-color: rgba(255, 255, 255, 0.9);");
                buttons[i][j] = button;
                button.setAlignment(Pos.CENTER);

                gpane.add(button, i, j);

            }

        }

        Button buttonUP = new Button("Up");
        Button buttonDOWN = new Button("Down");
        Button buttonLEFT = new Button("Left");
        Button buttonRIGHT = new Button("Right");

        directionButtons.add(buttonUP);
        directionButtons.add(buttonDOWN);
        directionButtons.add(buttonLEFT);
        directionButtons.add(buttonRIGHT);

        Button specialUP = new Button("Special Up");
        Button specialDOWN = new Button("Special Down");
        Button specialLEFT = new Button("Special Left");
        Button specialRIGHT = new Button("Special Right");

        specialDirectionButtons.add(specialUP);
        specialDirectionButtons.add(specialDOWN);
        specialDirectionButtons.add(specialLEFT);
        specialDirectionButtons.add(specialRIGHT);

        HBox hBox = new HBox(10);
        hBox.setStyle("-fx-border-color: #c9c9f5");
        hBox.setAlignment(Pos.CENTER);

        HBox specialBox = new HBox(10);
        specialBox.setStyle("-fx-border-color: #c9c9f5");

        specialBox.setAlignment(Pos.CENTER);

        hBox.getChildren().add(buttonUP);
        hBox.getChildren().add(buttonDOWN);
        hBox.getChildren().add(buttonLEFT);
        hBox.getChildren().add(buttonRIGHT);

        specialBox.getChildren().add(specialUP);
        specialBox.getChildren().add(specialDOWN);
        specialBox.getChildren().add(specialLEFT);
        specialBox.getChildren().add(specialRIGHT);

        applyStyleForButtons(directionButtons);
        applyStyleForButtons(specialDirectionButtons);

        addSpecialDirectionButtonsFunctionality();
        addDirectionButtonsFunctionality();

        VBox root = new VBox();
        root.getChildren().add(hBox);
        root.getChildren().add(specialBox);
        root.setAlignment(Pos.CENTER);

        gpane.add(root, 1, 6, 4, 10);
        gpane.setAlignment(Pos.CENTER);

        // TODO: Task 2.1, Add an HBox for the movement buttons, an HBox for the ability buttons and add them to a VBox. Add the VBox to the gridPane.

        Scene scene = new Scene(gpane, 600, 600);
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

        for (int i=0; i < buttonsList.size(); i++) {

            buttonsList.get(i).setTextAlignment(TextAlignment.CENTER);
            buttonsList.get(i).setStyle("-fx-background-color: rgb(236,172,111); " +
                    "-fx-border-color: rgba(0,0,0,0.9);");

        }

        /*
        buttonsList.stream().map(b -> b.setStyle("-fx-background-color: rgba(244, 67, 54, 0.75); " +
                "-fx-border-color: rgba(255, 255, 255, 0.9);")).collect(Collectors.toList()); */
    }

    /**
     * Adds functionality to specified direction buttons.
     * When a direction button is clicked, it will call the move method with the corresponding direction and then update the UI.
     */
    private void addDirectionButtonsFunctionality() {
        // TODO: Task 1.2, Movement buttons configuration.
        /*
        switch(expression) {
            case expression.UP:
                directionButtons.get(1).onMouseClickedProperty();
                break;
            case expression.DOWN:
                directionButtons.get(1).onMouseClickedProperty();
                break;
            case expression.LEFT:
                directionButtons.get(1).onMouseClickedProperty();
                break;
            case expression.RIGHT:
                directionButtons.get(1).onMouseClickedProperty();
                break;
            default:
                // code block
        }*/

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
                buttons[i][j].setText(String.valueOf(gameBoard.get(i, j)));
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
