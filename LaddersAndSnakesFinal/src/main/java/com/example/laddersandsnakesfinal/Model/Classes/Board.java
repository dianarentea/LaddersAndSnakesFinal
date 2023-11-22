package com.example.laddersandsnakesfinal.Model.Classes;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Board {

    private Tile[] tiles;
    private Snake[] snakes;
    private Ladder[] ladders;


    public void initializeSnakes(Snake[] snakes, int... positions) {
        if (snakes.length * 2 != positions.length) {
            throw new IllegalArgumentException("Number of positions does not match the number of snakes");
        }

        int positionIndex = 0;
        for (Snake snake : snakes) {
            snake=new Snake();
            int startTileNumber = positions[positionIndex++];
            int endTileNumber = positions[positionIndex++];

            snake.setStartTile(createTile(startTileNumber));
            snake.setEndTile(createTile(endTileNumber));

            tiles[startTileNumber - 1] = new Tile(0);
            tiles[endTileNumber - 1] = new Tile(0);
        }
       this.snakes=snakes;
    }
    public void initializeLadders(Ladder[] ladders, int... positions) {
        if (ladders.length * 2 != positions.length) {
            throw new IllegalArgumentException("Number of positions does not match the number of ladders");
        }

        int positionIndex = 0;
        for (Ladder ladder : ladders) {
            ladder = new Ladder();
            int startTileNumber = positions[positionIndex++];
            int endTileNumber = positions[positionIndex++];

            ladder.setStartTile(createTile(startTileNumber));
            ladder.setEndTile(createTile(endTileNumber));

            tiles[startTileNumber - 1] = new Tile(-1);
            tiles[endTileNumber - 1] = new Tile(-1);
        }
        this.ladders=ladders;
    }

    public void initializeBoard() {
        tiles = new Tile[100];
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new Tile(i + 1);
        }
        Snake[] snakes = new Snake[8];
        initializeSnakes(snakes, 6, 3, 42, 19, 45, 36, 51, 13, 67, 54, 83, 62, 90, 87, 96, 66);
        Ladder[] ladders = new Ladder[8];
        initializeLadders(ladders, 5, 9, 15, 25, 18, 80, 44, 86, 47, 68, 63, 78, 71, 94, 81, 98);
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

                System.out.print(getTileRepresentation(tiles[index]));

                if (col < cols - 1) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

    private String getTileRepresentation(Tile tile) {
        if (tile.getTileNumber() == 0) {
            return "S";
        } else if (tile.getTileNumber() == -1) {
            return "L";
        } else {
            return String.valueOf(tile.getTileNumber());
        }
    }

    public Tile createTile(int number) {
        return new Tile(number);
    }
}
