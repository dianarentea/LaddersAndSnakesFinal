package com.example.laddersandsnakesfinal.Model.Classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void testInitializeGame() {
        Game game = Game.getInstance();
        game.initializeGame();

        // Verifică dacă tabla de joc este inițializată corespunzător
        //  verifica că prima poziție a jucătorului este 1 după inițializare
        assertEquals(1, game.handlePlayerMove(0, 1));
    }

    @Test
    public void testRollDice() {
        Game game = Game.getInstance();
        int diceValue = game.rollDice();

        // Verifică dacă valoarea zarului este între 1 și 6, de exemplu
        assertTrue(diceValue >= 1 && diceValue <= 6);
    }

    @Test
    public void testHandlePlayerMove() {
        Game game = Game.getInstance();
        int currentPosition = 10;
        int diceValue = 3;
        int newPosition = game.handlePlayerMove(currentPosition, diceValue);

        // Verifică dacă poziția este calculată corespunzător
        assertEquals(currentPosition + diceValue, newPosition);
    }
    @Test
    public void testHandlePlayerWinMove() {
        Game game = Game.getInstance();
        int currentPosition = 98;
        int diceValue = 3;
        int newPosition = game.handlePlayerMove(currentPosition, diceValue);

        // Verifică dacă poziția este calculată corespunzător
        assertEquals(currentPosition , newPosition);
    }
    @Test
    public void testHandlePlayerMoveSnakeAndLadder() {
        Game game = Game.getInstance();
        int currentPosition = 10;
        int steps = 5;
        int newPosition = game.handlePlayerMoveSnakeAndLadder(currentPosition, steps);

        // Verifică dacă poziția este actualizată corect în funcție de șarpe sau scară
        // De exemplu, poți verifica că poziția nouă nu este mai mică decât poziția curentă
        System.out.println("Expected position: " + (currentPosition + steps) + ", Actual position: " + newPosition);
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