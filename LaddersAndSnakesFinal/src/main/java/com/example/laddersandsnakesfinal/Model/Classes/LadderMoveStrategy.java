package com.example.laddersandsnakesfinal.Model.Classes;

import com.example.laddersandsnakesfinal.Model.Interfaces.IMoveStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LadderMoveStrategy implements IMoveStrategy {

    private Ladder ladder;
    private Ladder[] ladders = new Ladder[8];
    @Override
    public int handleMove(int currentPosition) {
        if (currentPosition == ladder.getStartTile().getTileNumber()) {
            System.out.println("You stepped on a ladder");
            return ladder.getEndTile().getTileNumber();
        }
        return currentPosition;
    }

}
