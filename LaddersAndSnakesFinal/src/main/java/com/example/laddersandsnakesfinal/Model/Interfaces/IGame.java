package com.example.laddersandsnakesfinal.Model.Interfaces;

public interface IGame {

    int numberOfPlayers = 0;
    void joinGame();

    void chooseFirstPLayer();
    void InitializeBoard();

    void play();


}
