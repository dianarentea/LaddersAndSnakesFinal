package com.example.laddersandsnakesfinal.Model.Interfaces;

public interface IBoardFactory {
    ITile createTile();
    ISnake createSnake();
    ILadder createLadder();

    void initializeSnakes(ISnake[] snakes, int... positions);
}
