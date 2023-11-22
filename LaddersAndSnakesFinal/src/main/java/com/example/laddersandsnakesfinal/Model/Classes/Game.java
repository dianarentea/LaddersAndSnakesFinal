package com.example.laddersandsnakesfinal.Model.Classes;

import com.example.laddersandsnakesfinal.Model.Interfaces.IGame;
import com.example.laddersandsnakesfinal.Model.Interfaces.ILadder;
import com.example.laddersandsnakesfinal.Model.Interfaces.ISnake;

import java.util.Scanner;

public class Game implements IGame {
    Dice dice=new Dice();

    Board board=new Board();

    private int numberOfPlayers;
    @Override
    public void InitializeBoard()
    {
        //se initializeaza serpii
        ISnake[] snakes = new Snake[3];
        board.initializeSnakes(snakes, 10,2,15,6);
        //se initializeaza scari
        ILadder[] ladders = new Ladder[3];
        board.initializeLadders(ladders, 4,16,17,9);
    }

    @Override
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

    @Override
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


    @Override
    public void play() {
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
