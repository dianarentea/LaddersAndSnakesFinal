package com.example.laddersandsnakesfinal.Model.Classes;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tile  {

    private int tileNumber;

    public Tile createTile(int tileNumber){
       return new Tile(tileNumber);
    }

}
