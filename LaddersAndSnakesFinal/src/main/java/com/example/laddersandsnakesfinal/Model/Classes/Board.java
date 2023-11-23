package com.example.laddersandsnakesfinal.Model.Classes;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;


@Data
@Getter
@Setter
public class Board {

    private Tile[] tiles;
    private Snake[] snakes;
    private Ladder[] ladders;
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";

    public Tile createTile(int number) {
        return new Tile(number);
    }
    public void initializeSnakes( int... positions) {

        if (snakes.length * 2 != positions.length) {
            throw new IllegalArgumentException("Number of positions does not match the number of snakes");
        }

        int positionIndex = 0;
        int snakeIndex=0;
        for (Snake snake : snakes) {
            snake=new Snake();
            int startTileNumber = positions[positionIndex++];
            int endTileNumber = positions[positionIndex++];

            snake.setStartTile(createTile(startTileNumber));
            snake.setEndTile(createTile(endTileNumber));

            snakes[snakeIndex]=snake;
            snakeIndex++;

            tiles[startTileNumber - 1] = new Tile(0);
            tiles[endTileNumber - 1] = new Tile(0);
        }
    }
    public void initializeLadders(int... positions) {

        if (ladders.length * 2 != positions.length) {
            throw new IllegalArgumentException("Number of positions does not match the number of ladders");
        }

        int positionIndex = 0;
        int ladderIndex=0;
        for (Ladder ladder : ladders) {
            ladder = new Ladder();
            int startTileNumber = positions[positionIndex++];
            int endTileNumber = positions[positionIndex++];

            ladder.setStartTile(createTile(startTileNumber));
            ladder.setEndTile(createTile(endTileNumber));

            ladders[ladderIndex]=ladder;

            ladderIndex++;

            tiles[startTileNumber - 1] = new Tile(-1);
            tiles[endTileNumber - 1] = new Tile(-1);
        }
        for(int i=0; i<ladders.length;i++)
            System.out.println(ladders[i].getStartTile().getTileNumber()+" "+ladders[i].getEndTile().getTileNumber());
    }
    public void initializeBoard() {
        tiles = new Tile[100];
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new Tile(i + 1);
        }
        ladders = new Ladder[8];
        snakes = new Snake[8];

        initializeSnakes( 6, 3, 42, 19, 45, 36, 51, 13, 67, 54, 83, 62, 90, 87, 96, 66);
        initializeLadders( 5, 9, 15, 25, 18, 80, 44, 86, 47, 68, 63, 78, 71, 94, 81, 98);
    }
    public void displayBoard() {
        initializeBoard();
        int rows = 10;
        int cols = 10;

        for (int row = rows - 1; row >= 0; row--) {
            for (int col = 0; col < cols; col++) {
                int index;
                if (row % 2 == 0) {
                    index = row * cols + col;
                } else {
                    index = row * cols + (cols - 1 - col);
                }

                System.out.print("| " + getTileRepresentation(tiles[index]) + " ");


            }

            System.out.println("|");

            if (row > 0) {
                // Add horizontal line between rows
                for (int col = 0; col < cols; col++) {
                    System.out.print(" --- ");
                }
                System.out.println();
            }
        }
    }
    private String getTileRepresentation(Tile tile) {
        if (tile.getTileNumber() == 0) {
            return RED + "S " + RESET;
        } else if (tile.getTileNumber() == -1) {
            return GREEN + "L " + RESET;
        } else {
            return String.valueOf(tile.getTileNumber()) + " ";
        }
    }
    private String getTileRepresentation(Tile tile, char playerMarker) {
        if (tile.getTileNumber() == 0) {
            return RED + "S" + playerMarker + " " + RESET;
        } else if (tile.getTileNumber() == -1) {
            return GREEN + "L" + playerMarker + " " + RESET;
        } else {
            return playerMarker != ' ' ? playerMarker + " " : String.valueOf(tile.getTileNumber()) + " ";
        }
    }
    public void markCurrentPositions(int playerOnePos, int playerTwoPos) {
        int rows = 10;
        int cols = 10;

        for (int row = rows - 1; row >= 0; row--) {
            for (int col = 0; col < cols; col++) {
                int index;
                if (row % 2 == 0) {
                    index = row * cols + col;
                } else {
                    index = row * cols + (cols - 1 - col);
                }

                char playerMarker = getPlayerMarker(playerOnePos, playerTwoPos, index + 1);

                System.out.print("| " + getTileRepresentation(tiles[index], playerMarker) + " ");
            }

            System.out.println("|");

            if (row > 0) {
                // Add horizontal line between rows
                for (int col = 0; col < cols; col++) {
                    System.out.print(" --- ");
                }
                System.out.println();
            }
        }
    }
    private char getPlayerMarker(int playerOnePos, int playerTwoPos, int tileNumber) {
        if (playerOnePos == tileNumber) {
            return 'X';
        } else if (playerTwoPos == tileNumber) {
            return 'Y';
        } else {
            return ' ';
        }
    }
}
