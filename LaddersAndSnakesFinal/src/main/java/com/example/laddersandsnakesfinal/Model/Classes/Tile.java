package com.example.laddersandsnakesfinal.Model.Classes;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Tile  {

    private int tileNumber;
    private String tileCharacter;

    public Tile(String tileCharacter) {

        this.tileCharacter = tileCharacter;
    }
    public Tile(int tileNumber) {
        this.tileNumber = tileNumber;
    }

}
