package com.example.laddersandsnakesfinal.Model.Classes;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Snake{
    private Tile startTile;
    private Tile endTile;
}
