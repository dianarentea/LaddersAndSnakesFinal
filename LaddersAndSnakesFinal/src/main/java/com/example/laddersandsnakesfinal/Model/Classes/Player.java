package com.example.laddersandsnakesfinal.Model.Classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    private int idPLayer;
    private String username;
    private int currentPos;
    private boolean isWinner;
    private boolean isTurn;
}
