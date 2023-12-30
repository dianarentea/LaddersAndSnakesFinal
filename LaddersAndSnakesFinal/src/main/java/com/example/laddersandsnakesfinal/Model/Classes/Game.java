package com.example.laddersandsnakesfinal.Model.Classes;

public class Game {
    private static Game instance;  // Instanta Singleton
    private Dice dice = new Dice();
    private Board board = new Board();
    private PlayerEnum currentPlayer = PlayerEnum.PLAYER1;
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
        return diceValue;
    }

    public int handlePlayerMove( int currentPosition, int diceValue) {

        int newPosition = currentPosition + diceValue;
        if(newPosition>100)
        {
            return currentPosition;
        }
        return newPosition;
    }

    public int handlePlayerMoveSnakeAndLadder(int currentPosition, int steps)
    {
        int newPosition = currentPosition + steps;

        int newPositionSnake = board.handleSnakeMove(newPosition);
        if (newPositionSnake != 0) {
            return newPositionSnake;
        }

        int newPositionLadder = board.handleLadderMove(newPosition);
        if (newPositionLadder != 0) {

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

    public PlayerEnum getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == PlayerEnum.PLAYER1) ? PlayerEnum.PLAYER2 : PlayerEnum.PLAYER1;
    }
    public void setFixedDiceValue(int fixedValue) {
        dice.setFixedValue(fixedValue);
    }
}
