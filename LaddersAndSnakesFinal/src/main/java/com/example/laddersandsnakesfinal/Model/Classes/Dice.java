package com.example.laddersandsnakesfinal.Model.Classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dice  {

    private boolean showDice;
    private int currentDiceNumber;
    private int fixedValue;

    public int rollDice() {
        showDice = true;
        currentDiceNumber = (int) (Math.random() * 6 + 1);
        return currentDiceNumber;
    }
    public void setFixedValue(int fixedValue) {
        this.fixedValue = fixedValue;
    }
}
