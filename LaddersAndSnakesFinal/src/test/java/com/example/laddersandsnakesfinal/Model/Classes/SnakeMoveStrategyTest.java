package com.example.laddersandsnakesfinal.Model.Classes;

import com.example.laddersandsnakesfinal.Model.Interfaces.IMoveStrategy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SnakeMoveStrategyTest {
    @Test
    public void testHandleMove1() {
        List<Integer> snakePos1= Arrays.asList(6, 3);
        IMoveStrategy snakeMoveStrategy1= new SnakeMoveStrategy(snakePos1);
        int initialPosition=6;
        int newPosition=snakeMoveStrategy1.handleMove(initialPosition);
        assertEquals(3,newPosition);

    }
    @Test
    public void testHandleMove2() {
        List<Integer> snakePos2= Arrays.asList(42, 19);
        IMoveStrategy snakeMoveStrategy2= new SnakeMoveStrategy(snakePos2);
        int initialPosition2=42;
        int newPosition2=snakeMoveStrategy2.handleMove(initialPosition2);
        assertEquals(19,newPosition2);
    }
    @Test
    public void testHandleMove3() {
        List<Integer> snakePos2= Arrays.asList(45, 36);
        IMoveStrategy snakeMoveStrategy2= new SnakeMoveStrategy(snakePos2);
        int initialPosition2=45;
        int newPosition2=snakeMoveStrategy2.handleMove(initialPosition2);
        assertEquals(36,newPosition2);
    }
    @Test
    public void testHandleMove4() {
        List<Integer> snakePos2= Arrays.asList(51, 13);
        IMoveStrategy snakeMoveStrategy2= new SnakeMoveStrategy(snakePos2);
        int initialPosition2=51;
        int newPosition2=snakeMoveStrategy2.handleMove(initialPosition2);
        assertEquals(13,newPosition2);
    }
    @Test
    public void testHandleMove5() {
        List<Integer> snakePos2= Arrays.asList(67, 54);
        IMoveStrategy snakeMoveStrategy2= new SnakeMoveStrategy(snakePos2);
        int initialPosition2=67;
        int newPosition2=snakeMoveStrategy2.handleMove(initialPosition2);
        assertEquals(54,newPosition2);
    }
    @Test
    public void testHandleMove6() {
        List<Integer> snakePos2= Arrays.asList(83, 62);
        IMoveStrategy snakeMoveStrategy2= new SnakeMoveStrategy(snakePos2);
        int initialPosition2=83;
        int newPosition2=snakeMoveStrategy2.handleMove(initialPosition2);
        assertEquals(62,newPosition2);
    }
    @Test
    public void testHandleMove7() {
        List<Integer> snakePos2= Arrays.asList(90, 87);
        IMoveStrategy snakeMoveStrategy2= new SnakeMoveStrategy(snakePos2);
        int initialPosition2=90;
        int newPosition2=snakeMoveStrategy2.handleMove(initialPosition2);
        assertEquals(87,newPosition2);
    }
    @Test
    public void testHandleMove8() {
        List<Integer> snakePos2= Arrays.asList(96, 66);
        IMoveStrategy snakeMoveStrategy2= new SnakeMoveStrategy(snakePos2);
        int initialPosition2=96;
        int newPosition2=snakeMoveStrategy2.handleMove(initialPosition2);
        assertEquals(66,newPosition2);
    }
}