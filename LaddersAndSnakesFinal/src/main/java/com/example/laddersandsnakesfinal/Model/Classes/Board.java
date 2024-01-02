package com.example.laddersandsnakesfinal.Model.Classes;
import com.example.laddersandsnakesfinal.Model.Interfaces.IMoveStrategy;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class Board {

    private Tile[] tiles;

    private Snake[] snakes;

    private Ladder[] ladders;

    List<Integer> snakePositions =List.of(6, 3, 42, 19, 45, 36, 51, 13, 67, 54, 83, 62, 90, 87, 96, 66);
    IMoveStrategy snakeMoveStrategy = new SnakeMoveStrategy(snakePositions);

    List<Integer> ladderPositions =List.of(5, 9, 15, 25, 18, 80, 44, 86, 47, 68, 63, 78, 71, 94, 81, 98);
    IMoveStrategy ladderMoveStrategy = new LadderMoveStrategy(ladderPositions);
    private void initializeLadders(int... positions) {

        if (ladders.length * 2 != positions.length) {
            throw new IllegalArgumentException("Number of positions does not match the number of ladders");
        }

        int positionIndex = 0;
        int ladderIndex=0;
        for (Ladder ladder : ladders) {
            ladder = new Ladder();
            int startTileNumber = positions[positionIndex++];
            int endTileNumber = positions[positionIndex++];

            ladder.setStartTile(new Tile(startTileNumber));
            ladder.setEndTile(new Tile(endTileNumber));

            ladders[ladderIndex]=ladder;

            ladderIndex++;

            tiles[startTileNumber - 1] = new Tile(-1);
            tiles[endTileNumber - 1] = new Tile(-1);
        }
    }
    private void initializeSnakes( int... positions) {

        if (snakes.length * 2 != positions.length) {
            throw new IllegalArgumentException("Number of positions does not match the number of snakes");
        }
        int positionIndex = 0;
        int snakeIndex=0;
        for (Snake snake : snakes) {
            snake=new Snake();
            int startTileNumber = positions[positionIndex++];
            int endTileNumber = positions[positionIndex++];

            snake.setStartTile(new Tile(startTileNumber));
            snake.setEndTile(new Tile(endTileNumber));

            snakes[snakeIndex]=snake;
            snakeIndex++;

            tiles[startTileNumber - 1] = new Tile(0);
            tiles[endTileNumber - 1] = new Tile(0);
        }
    }
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
    public int handleSnakeMove(int currentPosition) {
        return snakeMoveStrategy.handleMove(currentPosition);
    }
    public int handleLadderMove(int currentPosition) {
        return ladderMoveStrategy.handleMove(currentPosition);
    }

}
