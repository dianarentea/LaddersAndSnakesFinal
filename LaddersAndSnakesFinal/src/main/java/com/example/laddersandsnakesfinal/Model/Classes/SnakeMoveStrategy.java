package com.example.laddersandsnakesfinal.Model.Classes;

import com.example.laddersandsnakesfinal.Model.Interfaces.IMoveStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SnakeMoveStrategy implements IMoveStrategy {

    private Snake snake;
    private Snake[] snakes = new Snake[8];
    @Override
    public int handleMove(int currentPosition) {
        if (currentPosition == snake.getStartTile().getTileNumber()) {
            System.out.println("You stepped on a ladder");
            return snake.getEndTile().getTileNumber();
        }
        return currentPosition;
    }

}
