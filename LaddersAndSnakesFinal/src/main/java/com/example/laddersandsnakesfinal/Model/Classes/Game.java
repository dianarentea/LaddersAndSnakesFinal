package com.example.laddersandsnakesfinal.Model.Classes;

import java.util.Scanner;

public class Game  {
    private Dice dice=new Dice();
    private Board board=new Board();
    private Player [] players;
    private int numberOfPlayers;
    private boolean isOver=false;

    public void joinGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of players");

        numberOfPlayers = sc.nextInt();
        players = new Player[numberOfPlayers];

        //se seteaza numele jucatorilor
        for (int i = 0; i < numberOfPlayers; i++)
        {
            int index=i+1;
            System.out.println("Enter the name of player " + index);
            String username = sc.next();
            players[i] = new Player(index,username,1,false,false);
        }
    }
    public void chooseFirstPlayer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the first player");
        int firstPlayer = sc.nextInt();
        for (int i = 0; i < numberOfPlayers; i++)
        {
            if(i+1==firstPlayer)
            {
                players[i].setTurn(true);
                break;
            }
        }
    }
    public void showPlayers() {
        for (int i = 0; i < numberOfPlayers; i++)
        {
            System.out.println("Player "+ players[i].getIdPLayer()+" "+players[i].getUsername()+" is at position "+players[i].getCurrentPos());
        }
    }

    //logica pentru a verifica in consola


    public void play() {
        board.displayBoard();
        joinGame();
        chooseFirstPlayer();
        showPlayers();
            while(isOver == false)
            {
                for (int i = 0; i < numberOfPlayers; i++)
                {
                    if(players[i].isTurn()==true)
                    {
                        System.out.println("It's "+players[i].getUsername()+"'s turn");
                        int diceValue = dice.rollDice();
                        System.out.println("Dice value is " + diceValue);
                        try {
                    // Pause execution for 1 second (1000 milliseconds)
                    Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                             }

                        int newPos=players[i].getCurrentPos()+diceValue;

                        //VERIFIC DACA JUCATORUL A AJUNS LA POZITIA 100
                        if(newPos>100)
                        {
                            System.out.println("You can't move");
                        }

                        //VERIFIC DACA JUCATORUL A AJUNS LA POZITIA 100
                        else
                        {
                            players[i].setCurrentPos(newPos);
                            System.out.println(players[i].getUsername()+ " is now at position "+players[i].getCurrentPos());

                            if(players[i].getCurrentPos()==100)
                            {
                                System.out.println("You won");
                                players[i].setWinner(true);
                                isOver=true;
                                break;
                            }
                            ///////////////////////////////////////////////////
                            //VERIFIC DACA JUCATORUL A AJUNS LA SARPE SAU SCARA
                            ///////////////////////////////////////////////////
                            else
                            {
                                players[i].setCurrentPos((board.handleSnakeMove(players[i].getCurrentPos())));
                                players[i].setCurrentPos((board.handleLadderMove(players[i].getCurrentPos())));
//                                board.handleSnake(players[i].getCurrentPos(), players[i]);
//                                board.handleLadder(players[i].getCurrentPos(), players[i]);
                            }
                        }

                        ////////////////////////////////////////////

                        //STATUSUL JOCULUI

                        ////////////////////////////////////////////
                        board.markCurrentPositions(players[0].getCurrentPos(), players[1].getCurrentPos());

                        players[i].setTurn(false);
                        if(i+1==numberOfPlayers)
                        {
                            players[0].setTurn(true);
                        }
                        else
                        {
                            players[i+1].setTurn(true);
                        }
                        break;
                    }
                }
            }
        }
}
