package com.example.laddersandsnakesfinal.Model.Interfaces;

public interface ILadder {

        void display();
        int getStartTile();
        int getEndTile();

        void setStartTile(ITile tile);
        void setEndTile(ITile tile);

}
