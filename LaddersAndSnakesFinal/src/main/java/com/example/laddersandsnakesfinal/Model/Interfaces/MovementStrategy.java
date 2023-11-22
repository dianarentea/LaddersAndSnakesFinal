package com.example.laddersandsnakesfinal.Model.Interfaces;

import com.example.laddersandsnakesfinal.Model.Classes.Tile;

public interface MovementStrategy {
    void move(Tile startTile, Tile endTile);
}
