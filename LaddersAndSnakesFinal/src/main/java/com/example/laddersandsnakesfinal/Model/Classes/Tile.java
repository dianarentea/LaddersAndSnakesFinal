package com.example.laddersandsnakesfinal.Model.Classes;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tile  {

    private int tileNumber;

    public void display() {
        System.out.println("Simple Tile " + tileNumber);
    }



}
