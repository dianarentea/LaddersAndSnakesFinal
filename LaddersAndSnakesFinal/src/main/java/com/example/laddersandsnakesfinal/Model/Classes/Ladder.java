package com.example.laddersandsnakesfinal.Model.Classes;

import com.example.laddersandsnakesfinal.Model.Interfaces.ILadder;
import com.example.laddersandsnakesfinal.Model.Interfaces.ITile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ladder implements ILadder {

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
    public int getStartTile() {
        return startTile.getTileNumber();
    }
    @Override
    public int getEndTile() {
        return endTile.getTileNumber();
    }
    @Override
    public void display() {
        System.out.println("Ladder");
        startTile.display();
        endTile.display();
    }
}
