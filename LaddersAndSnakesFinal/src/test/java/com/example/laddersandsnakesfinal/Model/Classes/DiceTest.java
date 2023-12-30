package com.example.laddersandsnakesfinal.Model.Classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    @Test
    public void testRollDice() {
        Dice dice=new Dice();
        int diceValue = dice.rollDice();
        assertTrue(diceValue >= 1 && diceValue <= 6);
    }
}