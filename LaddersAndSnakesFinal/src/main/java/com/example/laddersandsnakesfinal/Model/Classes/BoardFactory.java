package com.example.laddersandsnakesfinal.Model.Classes;

import com.example.laddersandsnakesfinal.Model.Interfaces.ILadder;
import com.example.laddersandsnakesfinal.Model.Interfaces.ISnake;
import com.example.laddersandsnakesfinal.Model.Interfaces.ITile;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class BoardFactory  {


    public abstract ITile createTile();

    public abstract ISnake createSnake();

    public abstract ILadder createLadder();

    public abstract void initializeSnakes(ISnake[] snakes, int... positions);

    public abstract void initializeLadders(ILadder[] ladders, int... positions);

    public abstract ITile createTile(int number);


}
