package com.example.laddersandsnakesfinal.Model.Classes;

import com.example.laddersandsnakesfinal.Model.Interfaces.ISnake;
import com.example.laddersandsnakesfinal.Model.Interfaces.ITile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Snake implements ISnake {

    private ITile startTile;
    private ITile endTile;

    @Override
    public void setStartTile(ITile tile) {
        this.startTile = tile;
    }

    @Override
    public void setEndTile(ITile tile) {
        this.endTile = tile;
    }

    @Override
    public void display() {
        System.out.println("Snake");
        startTile.display();
        endTile.display();
    }
}
