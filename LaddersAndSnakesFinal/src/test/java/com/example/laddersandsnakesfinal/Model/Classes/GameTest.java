package com.example.laddersandsnakesfinal.Model.Classes;

import com.example.laddersandsnakesfinal.Model.Interfaces.IMoveStrategy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GameTest {
    @Test
    public void testInitializeGame() {
        Game game = Game.getInstance();
        game.initializeGame();

        assertEquals(1, game.handlePlayerMove(0, 1));
    }

    @Test
    public void testHandlePlayerMove() {
        Game game = Game.getInstance();
        int currentPosition = 10;
        int diceValue = 3;
        int newPosition = game.handlePlayerMove(currentPosition, diceValue);

        assertEquals(currentPosition + diceValue, newPosition);
    }
    @Test
    public void testHandlePlayerWinMove() {
        Game game = Game.getInstance();
        int currentPosition = 98;
        int diceValue = 3;
        int newPosition = game.handlePlayerMove(currentPosition, diceValue);

        assertEquals(currentPosition , newPosition);
    }
    @Test
    public void testHandlePlayerMoveSnakeAndLadder() {
        Game game = Game.getInstance();
        int currentPosition = 10;
        int steps = 5;
        int newPosition = game.handlePlayerMoveSnakeAndLadder(currentPosition, steps);

        assertEquals(game.handlePlayerMoveSnakeAndLadder(currentPosition, steps), newPosition);

    }
    @Test
    public void testHasPlayerWon() {
        Game game = Game.getInstance();
        int winPosition = 100;
        int losePosition = 50;
        assertTrue(game.hasPlayerWon(winPosition) == 1);
        assertFalse(game.hasPlayerWon(losePosition) == 1);
    }

    @Test
    public void testSwitchPlayer() {
        Game game = Game.getInstance();
        PlayerEnum initialPlayer = game.getCurrentPlayer();
        game.switchPlayer();

        PlayerEnum switchedPlayer = game.getCurrentPlayer();
        assertNotEquals(initialPlayer, switchedPlayer);
    }


}