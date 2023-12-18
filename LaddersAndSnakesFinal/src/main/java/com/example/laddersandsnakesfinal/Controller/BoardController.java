package com.example.laddersandsnakesfinal.Controller;

import com.example.laddersandsnakesfinal.Model.Classes.Board;
import com.example.laddersandsnakesfinal.Model.Classes.Dice;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image ;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;

public class BoardController {
    private Board board=new Board();
    private Dice dice = new Dice();
    private int currentPlayer = 1;
    private Map<Integer, Integer> playerPositions = new HashMap<>();

    @FXML
    private Label wintext;

    @FXML
    private Label diceText;

    @FXML
    private GridPane gridpane = new GridPane();

    @FXML
    public void initialize() {

        board.initializeBoard();
        // Set the background image
        Image backgroundImage = new Image(getClass().getResource("/l2.jpg").toExternalForm());

        gridpane.setStyle("-fx-background-image: url('" + backgroundImage.getUrl() + "'); " +
                "-fx-background-size: 525px 525px; " +
                "-fx-background-repeat: no-repeat; " +
                "-fx-background-position: center center;");

        int numCells = 10;

        for (int row = numCells - 1; row >= 0; row--) {
            for (int col = 0; col < numCells; col++) {
                int index;
                if (row % 2 == 0) {
                    index = 101 - (row * numCells + col + 1);
                } else {
                    index = 101 - (row * numCells + (numCells - 1 - col) + 1);
                }
                IndexedRegion cell = new IndexedRegion(index);

                gridpane.add(cell, col, row);
            }
        }
        gridpane.toBack();
    }
    @FXML
    protected void onRollDiceButtonClick() {
        int diceValue = dice.rollDice();
        int steps = diceValue;

        // Alege jucătorul curent
        String imageUrl = (currentPlayer == 1) ? "/p1.png" : "/p2.png";

        // Obține poziția curentă a jucătorului
        int currentPosition = playerPositions.getOrDefault(currentPlayer, 0);

        System.out.println("Poz curenta: " + currentPosition);

        System.out.println("Dice value: " + diceValue);

        int newPosition = currentPosition + steps;

        System.out.println("Poz noua: " + newPosition);

        removePlayerImage(currentPosition);

        if (board.handleSnakeMove(newPosition) != 0) {
            int newPositionSnake = board.handleSnakeMove(newPosition);
            System.out.println("You stepped on a snake, new position is " + newPositionSnake);

            Timeline timeline1 = new Timeline(
                    new KeyFrame(Duration.millis(1000), event -> {
                        // Afișează valoarea zarului
                        diceText.setText("Dice value: " + diceValue);
                    }),
                    new KeyFrame(Duration.millis(1000), event -> {
                        // Actualizează poziția jucătorului și schimbă jucătorul curent
                        updatePlayerPosition(currentPlayer, newPosition, imageUrl);
                        playerPositions.put(currentPlayer, newPosition);
                    }),
                    new KeyFrame(Duration.millis(1000), event -> {
                        removePlayerImage(newPosition);

                    })

            );
            timeline1.play();

            Timeline timeline2 = new Timeline(
                    new KeyFrame(Duration.millis(1000), event -> {
                        // Actualizează poziția jucătorului și schimbă jucătorul curent
                        updatePlayerPosition(currentPlayer, newPositionSnake, imageUrl);
                        playerPositions.put(currentPlayer, newPositionSnake);

                        // Schimbă jucătorul curent
                        currentPlayer = (currentPlayer == 1) ? 2 : 1;
                    })
            );
            timeline2.play();

        } else if (board.handleLadderMove(newPosition) != 0) {
            int newPositionLadder = board.handleLadderMove(newPosition);
            System.out.println("You stepped on a ladder, new position is " + newPositionLadder);

            Timeline timeline1 = new Timeline(
                    new KeyFrame(Duration.millis(1000), event -> {
                        // Afișează valoarea zarului
                        diceText.setText("Dice value: " + diceValue);
                    }),
                    new KeyFrame(Duration.millis(1000), event -> {
                        // Actualizează poziția jucătorului și schimbă jucătorul curent
                        updatePlayerPosition(currentPlayer, newPosition, imageUrl);
                        playerPositions.put(currentPlayer, newPosition);
                    }),
                    new KeyFrame(Duration.millis(1000), event -> {
                        removePlayerImage(newPosition);

                    })

            );
            timeline1.play();
            Timeline timeline2 = new Timeline(
                    new KeyFrame(Duration.millis(1000), event -> {
                        // Afișează valoarea zarului
                        diceText.setText("Dice value: " + diceValue);
                    }),
                    new KeyFrame(Duration.millis(1000), event -> {
                        // Actualizează poziția jucătorului și schimbă jucătorul curent
                        updatePlayerPosition(currentPlayer, newPositionLadder, imageUrl);
                        playerPositions.put(currentPlayer, newPositionLadder);

                        // Schimbă jucătorul curent
                        currentPlayer = (currentPlayer == 1) ? 2 : 1;
                    })
            );
            timeline2.play();

        } else {

            if (newPosition >= 100) {
                wintext.setText("Player " + currentPlayer + " has won!");
                return;
            }

            // Adaugă un delay înainte de a schimba jucătorul
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.millis(1000), event -> {
                        // Afișează valoarea zarului
                       diceText.setText("Dice value: " + diceValue);
                    }),
                    new KeyFrame(Duration.millis(1000), event -> {
                        // Actualizează poziția jucătorului și schimbă jucătorul curent
                        updatePlayerPosition(currentPlayer, newPosition, imageUrl);
                        playerPositions.put(currentPlayer, newPosition);


                        // Schimbă jucătorul curent
                        currentPlayer = (currentPlayer == 1) ? 2 : 1;
                    })
            );
            timeline.play();
        }
    }


    private void removePlayerImage(int position) {
        for (Node node : gridpane.getChildren()) {
            if (node instanceof IndexedRegion) {
                IndexedRegion cell = (IndexedRegion) node;
                if (cell.getIndex() == position) {

                    // A găsit celula curentă
                    cell.setStyle("");
                    break;
                }
            }
        }
    }
    private void updatePlayerPosition(int player, int position, String imageUrl) {
        for (Node node : gridpane.getChildren()) {
            if (node instanceof IndexedRegion) {
                IndexedRegion cell = (IndexedRegion) node;
                if (cell.getIndex() == position) {
                    // A găsit noua celulă
                    String newImageStyle = "-fx-background-image: url('" + imageUrl + "'); " +
                            "-fx-background-size: cover;";

                    // Setează stilul pentru noua celulă
                    cell.setStyle(newImageStyle);
                    break;
                }
            }
        }
    }
}