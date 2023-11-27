package com.example.laddersandsnakesfinal.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image ;

public class BoardController {
    @FXML
    private Label welcomeText;

    @FXML
    private GridPane gridpane = new GridPane();

    @FXML
    public void initialize() {
        // Set the background image
        Image backgroundImage = new Image(getClass().getResource("/l2.jpg").toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(500);
        backgroundImageView.setFitHeight(500);
        gridpane.getChildren().add(backgroundImageView);

    }
    @FXML
    protected void onExitButtonClick() {
        System.exit(0);
    }
}