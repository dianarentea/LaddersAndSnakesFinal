package com.example.laddersandsnakesfinal.Model.Classes;

public class Game {
    private static Game instance;  // Instanta Singleton
    private Dice dice = new Dice();
    private Board board = new Board();
    private Game() {
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void initializeGame() {
        board.initializeBoard();
    }

    public int rollDice() {
        int diceValue = dice.rollDice();
        System.out.println("Your dice value is " + diceValue);
        return diceValue;
    }

    public int handlePlayerMove( int currentPosition, int diceValue) {
        int newPosition = currentPosition + diceValue;
        System.out.println("Your position is " + newPosition);
        return newPosition;
    }

    public int handlePlayerMoveSnakeAndLadder(int currentPosition, int steps)
    {
        int newPosition = currentPosition + steps;

        int newPositionSnake = board.handleSnakeMove(newPosition);
        if (newPositionSnake != 0) {
            System.out.println("You hit a snake! Go back to position " + newPositionSnake);
            return newPositionSnake;
        }

        int newPositionLadder = board.handleLadderMove(newPosition);
        if (newPositionLadder != 0) {
            System.out.println("You hit a ladder! Go to position " + newPositionLadder);
            return newPositionLadder;
        }
        return 0;
    }

    public int hasPlayerWon(int currentPosition) {
        if (currentPosition == 100) {
            return 1;
        }
        return 0;
    }

}
