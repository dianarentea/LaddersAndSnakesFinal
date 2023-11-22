package com.example.laddersandsnakesfinal.Model.Classes;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ladder {

    private Tile startTile;
    private Tile endTile;

}
