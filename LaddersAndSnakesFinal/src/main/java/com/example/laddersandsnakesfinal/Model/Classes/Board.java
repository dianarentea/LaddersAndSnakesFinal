package com.example.laddersandsnakesfinal.Model.Classes;

import com.example.laddersandsnakesfinal.Model.Interfaces.ILadder;
import com.example.laddersandsnakesfinal.Model.Interfaces.ISnake;
import com.example.laddersandsnakesfinal.Model.Interfaces.ITile;
import lombok.Data;

@Data
public class Board extends BoardFactory{

    private ITile[] tiles;
    private ISnake[] snakes;
    private ILadder[] ladders;


    public void initializeSnakes(ISnake[] snakes, int... positions) {
        if (snakes.length * 2 != positions.length) {
            throw new IllegalArgumentException("Number of positions does not match the number of snakes");
        }

        int positionIndex = 0;
        for (ISnake snake : snakes) {
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
    public void initializeLadders(ILadder[] ladders, int... positions) {
        if (ladders.length * 2 != positions.length) {
            throw new IllegalArgumentException("Number of positions does not match the number of ladders");
        }

        int positionIndex = 0;
        for (ILadder ladder : ladders) {
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
        ISnake[] snakes = new Snake[8];
        initializeSnakes(snakes, 6, 3, 42, 19, 45, 36, 51, 13, 67, 54, 83, 62, 90, 87, 96, 66);
        ILadder[] ladders = new Ladder[8];
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

    private String getTileRepresentation(ITile tile) {
        if (tile.getTileNumber() == 0) {
            return "S";
        } else if (tile.getTileNumber() == -1) {
            return "L";
        } else {
            return String.valueOf(tile.getTileNumber());
        }
    }

    public ITile createTile(int number) {
        return new Tile(number);
    }
}
