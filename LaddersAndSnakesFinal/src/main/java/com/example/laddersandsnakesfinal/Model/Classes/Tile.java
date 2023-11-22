package com.example.laddersandsnakesfinal.Model.Classes;

import com.example.laddersandsnakesfinal.Model.Interfaces.ITile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tile implements ITile {

    private int tileNumber;
    @Override
    public void display() {
        System.out.println("Simple Tile " + tileNumber);
    }

    @Override
    public int getTileNumber() {
        return tileNumber;
    }
    @Override
    public void setTileNumber(int number) {
        this.tileNumber = number;
    }

    @Override
    public ITile createTile(int number) {
        return new Tile(number);
    }


}
