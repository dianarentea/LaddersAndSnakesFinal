package com.example.laddersandsnakesfinal.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image ;
import javafx.scene.layout.Region;

public class BoardController {
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
        double cellSize = 50.0;

        for (int row = numCells - 1; row >= 0; row--) {
            for (int col = 0; col < numCells; col++) {
                int index;
                if (row % 2 == 0) {
                    index = 101 - (row * numCells + col + 1);
                } else {
                    index = 101- (row * numCells + (numCells - 1 - col) + 1);
                }
                Region cell = new Region();
                cell.setMinSize(cellSize, cellSize);
                cell.setMaxSize(cellSize, cellSize);
                cell.setStyle("-fx-border-color: black; -fx-padding: 10px;");

                if (index == 2) {
                    String imageUrl = "/p1.png";
                    String imageStyle = "-fx-background-image: url('" + imageUrl + "'); " +
                            "-fx-background-size: cover;";

                    cell.setStyle(cell.getStyle() + imageStyle);
                }
                else if (index == 1) {
                    String imageUrl = "/p2.png";
                    String imageStyle = "-fx-background-image: url('" + imageUrl + "'); " +
                            "-fx-background-size: cover;";

                    cell.setStyle(cell.getStyle() + imageStyle);
                }

                gridpane.add(cell, col, row);
            }
        }
        gridpane.toBack();
    }
    @FXML
    public void test()
    {

    }

    @FXML
    protected void onExitButtonClick() {
        System.exit(0);
    }
}