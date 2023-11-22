package com.example.laddersandsnakesfinal.Model.Interfaces;

public interface ITile {

   void display();
   ITile createTile(int number);

   int getTileNumber();

   void setTileNumber(int number);
}
