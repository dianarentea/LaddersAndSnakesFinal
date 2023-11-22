package com.example.laddersandsnakesfinal.Model.Classes;

public class Game {
    Dice dice=new Dice();

    public void play() {
        for (int i = 0; i < 10; i++) {
            int diceValue = dice.rollDice();
            if (dice.isShowDice()) {
                System.out.println("Dice value is " + diceValue);
            } else {
                System.out.println("Dice value is hidden");
            }

            try {
                // Pause execution for 1 second (1000 milliseconds)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
