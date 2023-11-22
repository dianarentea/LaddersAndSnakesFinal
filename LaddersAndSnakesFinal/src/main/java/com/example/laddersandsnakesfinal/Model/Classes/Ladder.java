package com.example.laddersandsnakesfinal.Model.Classes;

import com.example.laddersandsnakesfinal.Model.Interfaces.MovementStrategy;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ladder implements MovementStrategy {

    private Tile startTile;
    private Tile endTile;

    private Ladder[] ladders;

    @Override
    public void move(Tile startTile, Tile endTile){
        startTile = endTile;
    }

}
