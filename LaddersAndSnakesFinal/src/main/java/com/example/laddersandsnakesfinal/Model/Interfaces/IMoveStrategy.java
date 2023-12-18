package com.example.laddersandsnakesfinal.Model.Interfaces;

import com.example.laddersandsnakesfinal.Model.Classes.Ladder;
import com.example.laddersandsnakesfinal.Model.Classes.Snake;

public interface IMoveStrategy {
    int handleMove(int currentPosition);
}
