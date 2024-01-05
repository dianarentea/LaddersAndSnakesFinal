package com.example.laddersandsnakesfinal.Controller;
import com.example.laddersandsnakesfinal.Model.Classes.Game;
import com.example.laddersandsnakesfinal.Model.Classes.PlayerEnum;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image ;
import javafx.util.Duration;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class BoardController {
    private Game game = Game.getInstance();
    @FXML
    private Label wintext;
    @FXML
    private ImageView diceImageView;
    @FXML
    private GridPane gridpane = new GridPane();

    private HashMap<Integer, List<PlayerEnum>> cellPlayerMap = new HashMap<>();
    @FXML
    public void initialize() {

        game.initializeGame();
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
        int diceValue = game.rollDice();

        diceImageView.setImage(new Image(getClass().getResource("/dice/" + diceValue + ".png").toExternalForm()));

        PlayerEnum currentPlayer = game.getCurrentPlayer();
        int currentPosition = currentPlayer.getPosition();

        int newPosition = game.handlePlayerMove(currentPosition, diceValue);
        removePlayerImage(currentPosition,currentPlayer);

        int newPositionSnakeOrLadder = game.handlePlayerMoveSnakeAndLadder(currentPosition, diceValue);


        if (newPositionSnakeOrLadder != 0) {
            Timeline timeline1 = new Timeline(
                    new KeyFrame(Duration.millis(1000), event -> {
                        updatePlayerPosition(currentPlayer, newPosition);
                    }),
                    new KeyFrame(Duration.millis(1000), event -> {
                        PauseTransition pause = new PauseTransition(Duration.seconds(1));
                        pause.setOnFinished(pauseEvent -> {
                            updatePlayerPosition(currentPlayer, newPositionSnakeOrLadder);
                            game.switchPlayer();
                        });
                        pause.play();
                    }),
                    new KeyFrame(Duration.millis(1000), event -> {
                        removePlayerImage(newPosition,currentPlayer);
                    })
            );
            timeline1.play();
        }

         else {
            if (game.hasPlayerWon(newPosition) == 1)
            {
                wintext.setText("Player " + currentPlayer.getName() + " has won!");
                return;
            }
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.millis(1000), event -> {
                        updatePlayerPosition(currentPlayer, newPosition);
                        game.switchPlayer();
                    })
            );
            timeline.play();
        }

        wintext.setText(currentPlayer.getName() + " has moved!");
    }
    void removePlayerImage(int position, PlayerEnum player) {
        if (cellPlayerMap.containsKey(position)) {
            List<PlayerEnum> playersOnCell = cellPlayerMap.get(position);
            playersOnCell.remove(player);
            updateCellImage(position, playersOnCell);
        }
    }
    void updatePlayerPosition(PlayerEnum player, int position) {
        cellPlayerMap.putIfAbsent(position, new ArrayList<>());
        List<PlayerEnum> playersOnCell = cellPlayerMap.get(position);
        if (!playersOnCell.contains(player)) {
            playersOnCell.add(player);
        }
        updateCellImage(position, playersOnCell);

        player.setPosition(position);
    }
    void updateCellImage(int position, List<PlayerEnum> playersOnCell) {
        for (Node node : gridpane.getChildren()) {
            if (node instanceof IndexedRegion && ((IndexedRegion) node).getIndex() == position) {
                IndexedRegion cell = (IndexedRegion) node;
                cell.getChildren().clear(); // Curățăm orice conținut existent

                for (PlayerEnum player : playersOnCell) {
                    ImageView playerImage = new ImageView(new Image(getClass().getResource(player.getImageUrl()).toExternalForm()));
                    playerImage.setFitHeight(50); // Setează înălțimea imaginii
                    playerImage.setFitWidth(50); // Setează lățimea imaginii
                    cell.getChildren().add(playerImage); // Adăugăm imaginea jucătorului în celulă
                }
                break;
            }
        }
    }


}