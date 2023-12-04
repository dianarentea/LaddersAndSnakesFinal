package com.example.laddersandsnakesfinal.Controller;

import com.example.laddersandsnakesfinal.Model.Classes.Dice;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image ;
import javafx.scene.layout.Region;

public class BoardController {
    private Dice dice=new Dice();

    @FXML
    private Label welcomeText;

    @FXML
    private GridPane gridpane = new GridPane();

    @FXML
    public void initialize() {
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
                    index = 101- (row * numCells + (numCells - 1 - col) + 1);
                }
                IndexedRegion cell = new IndexedRegion(index);

                if (index == 2) {
                    String imageUrl = "/p1.png";
                    String imageStyle = "-fx-background-image: url('" + imageUrl + "'); " +
                            "-fx-background-size: cover;";

                    cell.setStyle(cell.getStyle() + imageStyle);
                }
//                else if (index == 1) {
//                    String imageUrl = "/p2.png";
//                    String imageStyle = "-fx-background-image: url('" + imageUrl + "'); " +
//                            "-fx-background-size: cover;";
//
//                    cell.setStyle(cell.getStyle() + imageStyle);
//                }

                gridpane.add(cell, col, row);
            }
        }
        gridpane.toBack();
    }

     @FXML
    protected void onExitButtonClick() {
        System.exit(0);
    }

    @FXML
    protected void onRollDiceButtonClick() {
        int indexToCheck = 6;
        int diceValue=dice.rollDice();
        for (Node node : gridpane.getChildren())
        {
            if (node instanceof IndexedRegion) {
                IndexedRegion cell = (IndexedRegion) node;

                if (cell.getIndex() == indexToCheck)
                {
                    // Am găsit celula cu indexul dorit
                    String imageUrl = "/p1.png";
                    String imageStyle = "-fx-background-image: url('" + imageUrl + "'); " +
                            "-fx-background-size: cover;";

                    // Setează stilul pentru celula cu indexul 2
                    cell.setStyle(cell.getStyle() + imageStyle);
                }
            }
        }
    }
}