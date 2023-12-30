package com.example.laddersandsnakesfinal.Controller;

import com.almasb.fxgl.scene.Scene;
import com.example.laddersandsnakesfinal.Model.Classes.Game;
import com.example.laddersandsnakesfinal.Model.Classes.PlayerEnum;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class BoardControllerTest {

    private BoardController boardController;
    private Game game=Game.getInstance();


    @BeforeEach
    public void setUp() {
        new JFXPanel();  // Se creează un JFXPanel pentru a inițializa JavaFX Toolkit
        boardController = new BoardController();
        boardController.initialize();  // Inițializăm controller-ul înainte de fiecare test
    }

    @Test
    public void testInitialize() {
        // Verificăm dacă gridpane a fost inițializat corect
        assertNotNull(boardController.getGridpane());
        // Verificăm dacă gridpane are copii și are dimensiunea corectă
        assertEquals(100, boardController.getGridpane().getChildren().size());
    }

    @Test
    public void testRemovePlayerImage() {
        // Adăugăm un jucător fictiv pe poziția 5
        boardController.updatePlayerPosition(PlayerEnum.PLAYER1, 5);

        // Apelăm metoda pentru a elimina imaginea jucătorului de pe poziția 5
        boardController.removePlayerImage(5);

        // Verificăm dacă stilul a fost eliminat
        assertFalse(boardController.getGridpane().getChildren().stream()
                .filter(node -> node instanceof IndexedRegion)
                .anyMatch(node -> ((IndexedRegion) node).getIndex() == 5
                        && ((IndexedRegion) node).getStyle().contains(PlayerEnum.PLAYER1.getImageUrl())));
    }

    @Test
    public void testUpdatePlayerPosition() {
        // Adăugăm un jucător fictiv pe poziția 8
        boardController.updatePlayerPosition(PlayerEnum.PLAYER2, 8);

        // Verificăm dacă stilul a fost actualizat
        assertTrue(boardController.getGridpane().getChildren().stream()
                .filter(node -> node instanceof IndexedRegion)
                .anyMatch(node -> ((IndexedRegion) node).getIndex() == 8
                        && ((IndexedRegion) node).getStyle().contains(PlayerEnum.PLAYER2.getImageUrl())));
    }

    @Test
    public void testWinningScenario() {
        game.initializeGame();
        // Presupunem că jucătorul curent este pe poziția 97 și aruncă un zar cu valoarea 3
        PlayerEnum currentPlayer = PlayerEnum.PLAYER1;
        currentPlayer.setPosition(97);
        int diceValue=3;
        game.hasPlayerWon(currentPlayer.getPosition()+diceValue);
        // Verificăm dacă mesajul de câștig a fost setat corespunzător
        assertEquals(97,game.handlePlayerMove(currentPlayer.getPosition(), 4));
    }
}