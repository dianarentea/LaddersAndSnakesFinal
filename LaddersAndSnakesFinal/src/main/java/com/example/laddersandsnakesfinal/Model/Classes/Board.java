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

    @Getter
    private Snake[] snakes;
    @Getter
    private Ladder[] ladders;
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";

    public Tile createTile(int number) {
        return new Tile(number);
    }

//    public void initializeSnakes(int[][] snakePositions) {
//    if (snakes.length != snakePositions.length) {
//        throw new IllegalArgumentException("Number of positions does not match the number of snakes");
//    }
//
//    int snakeIndex = 0;
//    for (int i = 0; i < snakes.length; i++) {
//        Snake snake = new Snake();
//        int startRow = snakePositions[i][0];
//        int startCol = snakePositions[i][1];
//        int endRow = snakePositions[i][2];
//        int endCol = snakePositions[i][3];
//
//        snake.setStartTile(createTile(startRow * 10 + startCol + 1));
//        snake.setEndTile(createTile(endRow * 10 + endCol + 1));
//
//        snakes[snakeIndex++] = snake;
//
//        tiles[snake.getStartTile().getTileNumber() - 1] = new Tile(0);
//        tiles[snake.getEndTile().getTileNumber() - 1] = new Tile(0);
//    }
//}
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

//    public void initializeLadders(int[][] ladderPositions) {
//        if (ladders.length != ladderPositions.length) {
//            throw new IllegalArgumentException("Number of positions does not match the number of ladders");
//        }
//
//        int ladderIndex = 0;
//        for (int i = 0; i < ladders.length; i++) {
//            Ladder ladder = new Ladder();
//            int startTileNumber = ladderPositions[i][0];
//            int endTileNumber = ladderPositions[i][1];
//
//            ladder.setStartTile(createTile(startTileNumber));
//            ladder.setEndTile(createTile(endTileNumber));
//
//            ladders[ladderIndex++] = ladder;
//
//            tiles[startTileNumber - 1] = new Tile(-1);
//            tiles[endTileNumber - 1] = new Tile(-1);
//        }
//    }
    public void initializeBoard() {
        tiles = new Tile[100];
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new Tile(i + 1);
        }

            ladders = new Ladder[8];
            snakes = new Snake[8];

        initializeSnakes(6, 3, 42, 19, 45, 36, 51, 13, 67, 54, 83, 62, 90, 87, 96, 66);
        initializeLadders(5, 9, 15, 25, 18, 80, 44, 86, 47, 68, 63, 78, 71, 94, 81, 98);
    }
//            int[][] laddersPositions = {
//                     {0, 4}, {0, 8},
//                     {1, 5}, {2, 4},
//                     {1, 2}, {7, 0},
//                     {6, 2}, {7, 2},
//                     {4, 3}, {8, 5},
//                     {4, 6}, {6, 7},
//                     {8, 0}, {9, 2},
//                     {7, 9}, {9, 6}
//            };
            //initializeLadders(laddersPositions);
//            int[][] snakesPositions = {
//                    {0, 5},{ 0, 2},
//                    {4, 1},{ 1, 1},
//                    {5, 8},{ 1, 7},
//                    {4, 4},{ 3, 4},
//                    {6, 6},{ 5, 6},
//                    {8, 2},{ 6, 1},
//                    {9, 4},{ 6, 5},
//                    {8, 6},{ 8, 9}
//            };
           // initializeSnakes(snakesPositions);




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
