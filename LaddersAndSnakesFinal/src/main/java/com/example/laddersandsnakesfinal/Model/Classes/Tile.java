package com.example.laddersandsnakesfinal.Model.Classes;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tile  {

    private int tileNumber;
    private int currentTileNumber;

    public Tile(int tileNumber) {
        this.tileNumber = tileNumber;
    }

}
