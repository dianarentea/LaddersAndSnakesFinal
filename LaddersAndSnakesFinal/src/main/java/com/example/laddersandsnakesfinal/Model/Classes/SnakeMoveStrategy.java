package com.example.laddersandsnakesfinal.Model.Classes;

import com.example.laddersandsnakesfinal.Model.Interfaces.IMoveStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SnakeMoveStrategy implements IMoveStrategy {

    private List<Integer> snakesPos;
    @Override
    public int handleMove(int currentPosition)
    {
        for(int i=0;i<snakesPos.size();i+=2) {
            if (currentPosition == snakesPos.get(i)) {
                System.out.println("You stepped on a snake");
                return snakesPos.get(i + 1);
            }
        }
            return 0;
    }

}
