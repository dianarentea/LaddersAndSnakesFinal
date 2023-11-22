package com.example.laddersandsnakesfinal.Model.Classes;

import com.example.laddersandsnakesfinal.Model.Interfaces.ILadder;
import com.example.laddersandsnakesfinal.Model.Interfaces.ISnake;
import com.example.laddersandsnakesfinal.Model.Interfaces.ITile;

public class Board extends BoardFactory{

    private ITile[] tiles;
    @Override
    public ITile createTile() {
        return new Tile();
    }

    @Override
    public ISnake createSnake() {
        ISnake snake = new Snake();
        snake.setStartTile(createTile());
        snake.setEndTile(createTile());
        return snake;
    }

    public ILadder createLadder() {
        ILadder ladder = new Ladder();
        ladder.setStartTile(createTile());
        ladder.setEndTile(createTile());
        return ladder;
    }

    public void initializeSnakes(ISnake[] snakes, int... positions) {
        if (snakes.length * 2 != positions.length) {
            throw new IllegalArgumentException("Numărul de poziții nu corespunde numărului de Snakes");
        }

        int positionIndex = 0;
        for (ISnake snake : snakes) {
            snake=createSnake();
            int startTileNumber = positions[positionIndex++];
            int endTileNumber = positions[positionIndex++];

            snake.setStartTile(createTile(startTileNumber));
            snake.setEndTile(createTile(endTileNumber));
        }
    }
    public void initializeLadders(ILadder[] ladders, int... positions) {
        if (ladders.length * 2 != positions.length) {
            throw new IllegalArgumentException("Numărul de poziții nu corespunde numărului de Ladders");
        }

        int positionIndex = 0;
        for (ILadder ladder : ladders) {
            ladder=createLadder();
            int startTileNumber = positions[positionIndex++];
            int endTileNumber = positions[positionIndex++];

            ladder.setStartTile(createTile(startTileNumber));
            ladder.setEndTile(createTile(endTileNumber));
        }
    }

    public void initializeBoard()
    {
        tiles=new Tile[100];
        for(int i=0; i<tiles.length; i++)
        {
            tiles[i]=new Tile(i+1);
        }
        ISnake[] snakes = new Snake[2];
        initializeSnakes(snakes, 10,2,15,6);
        ILadder[] ladders = new Ladder[2];
        initializeLadders(ladders, 4,16,17,9);

        // Set 'S' and 'L' on the board based on snake and ladder positions
//        for (ISnake snake : snakes) {
//            int startTileNumber = ((Snake) snake).getStartTile().getTileNumber();
//            int endTileNumber = ((Snake) snake).getEndTile().getTileNumber();
//            tiles[startTileNumber - 1] = new Tile(0);
//            tiles[endTileNumber - 1] = new Tile(0);
//        }
//
//        for (ILadder ladder : ladders) {
//            int startTileNumber = ((Ladder) ladder).getStartTile().getTileNumber();
//            int endTileNumber = ((Ladder) ladder).getEndTile().getTileNumber();
//            tiles[startTileNumber - 1] = new Tile(1);
//            tiles[endTileNumber - 1] = new Tile(1);
//        }
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
