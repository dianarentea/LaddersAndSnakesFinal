package com.example.laddersandsnakesfinal.Model.Classes;

import com.example.laddersandsnakesfinal.Model.Interfaces.ILadder;
import com.example.laddersandsnakesfinal.Model.Interfaces.ISnake;
import com.example.laddersandsnakesfinal.Model.Interfaces.ITile;

public class Board extends BoardFactory{
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
            int startTileNumber = positions[positionIndex++];
            int endTileNumber = positions[positionIndex++];

            ladder.setStartTile(createTile(startTileNumber));
            ladder.setEndTile(createTile(endTileNumber));
        }
    }

    public ITile createTile(int number) {
        return new Tile(number);
    }
}
