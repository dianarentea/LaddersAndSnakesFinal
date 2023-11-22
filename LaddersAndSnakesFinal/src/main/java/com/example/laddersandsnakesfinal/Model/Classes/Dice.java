package com.example.laddersandsnakesfinal.Model.Classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dice implements com.example.laddersandsnakesfinal.Model.Interfaces.Dice {

    private boolean showDice;
    private int currentDiceNumber;
    @Override
    public int rollDice() {
        showDice = true;
        currentDiceNumber = (int) (Math.random() * 6 + 1);
        return currentDiceNumber;
    }
}
