package com.example.laddersandsnakesfinal.Controller;

import com.example.laddersandsnakesfinal.Model.Classes.Board;
import com.example.laddersandsnakesfinal.Model.Classes.Dice;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image ;

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

        if(board.handleSnakeMove(currentPosition)!=0)
        {
            // Elimină imaginea jucătorului curent de pe poziția curentă
            removePlayerImage(currentPosition);

            // Calculează noua poziție
            int newPosition =  board.handleSnakeMove(currentPosition);

            System.out.println("You stepped on a snake, new position is " + newPosition);

            // Verifică dacă jucătorul a câștigat
            if (newPosition >= 100) {
                wintext.setText("Player " + currentPlayer + " has won!");
                return;
            }
            // Actualizează poziția jucătorului curent
            updatePlayerPosition(currentPlayer, newPosition, imageUrl);

            // Actualizează evidența poziției jucătorului curent
            playerPositions.put(currentPlayer, newPosition);

        }
        else if(board.handleLadderMove(currentPosition)!=0)
        {
            // Elimină imaginea jucătorului curent de pe poziția curentă
            removePlayerImage(currentPosition);

            // Calculează noua poziție
            int newPosition = board.handleLadderMove(currentPosition);

            System.out.println("You stepped on a ladder, new position is " + newPosition);

            // Verifică dacă jucătorul a câștigat
            if (newPosition >= 100) {
                wintext.setText("Player " + currentPlayer + " has won!");
                return;
            }
            // Actualizează poziția jucătorului curent
            updatePlayerPosition(currentPlayer, newPosition, imageUrl);

            // Actualizează evidența poziției jucătorului curent
            playerPositions.put(currentPlayer, newPosition);
        }
        else {

            // Elimină imaginea jucătorului curent de pe poziția curentă
            removePlayerImage(currentPosition);

            // Calculează noua poziție
            int newPosition = currentPosition + steps;

            // Verifică dacă jucătorul a câștigat
            if (newPosition >= 100) {
                wintext.setText("Player " + currentPlayer + " has won!");
                return;
            }

            // Actualizează poziția jucătorului curent
            updatePlayerPosition(currentPlayer, newPosition, imageUrl);

            // Actualizează evidența poziției jucătorului curent
            playerPositions.put(currentPlayer, newPosition);
        }
        // Schimbă jucătorul curent
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
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