package com.example.laddersandsnakesfinal.Model.Classes;

import java.util.Scanner;

public class Game  {
    Dice dice=new Dice();

    Board board=new Board();

    private int numberOfPlayers;


    public void joinGame()
    {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of players");

        int numberOfPlayers = sc.nextInt();
        Player[] players = new Player[numberOfPlayers];


        //se seteaza numele jucatorilor
        for (int i = 0; i < numberOfPlayers; i++)
        {
            int index=i+1;
            System.out.println("Enter the name of player " + index);
            String username = sc.next();
            players[i] = new Player(index,username,1,false,false);
        }

    }

    public void chooseFirstPLayer()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the first player");
        int firstPlayer = sc.nextInt();
        Player[] players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++)
        {
            if(i+1==firstPlayer)
            {
                players[i].setTurn(true);
            }
            else
            {
                players[i].setTurn(false);
            }
        }
    }


    public void play() {
        board.displayBoard();
        joinGame();
        chooseFirstPLayer();
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
