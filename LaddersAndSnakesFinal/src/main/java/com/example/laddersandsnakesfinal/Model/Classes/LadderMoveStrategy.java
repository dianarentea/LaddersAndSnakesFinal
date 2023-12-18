package com.example.laddersandsnakesfinal.Model.Classes;

import com.example.laddersandsnakesfinal.Model.Interfaces.IMoveStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LadderMoveStrategy implements IMoveStrategy {

    private List<Integer> laddersPos;

    @Override
    public int handleMove(int currentPosition) {
        for(int i=0;i<laddersPos.size();i+=2) {
            if (currentPosition == laddersPos.get(i)) {
                System.out.println("You stepped on a ladder");
                return laddersPos.get(i + 1);
            }
        }
            return 0;
    }

}
