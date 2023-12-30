package com.example.laddersandsnakesfinal.Model.Classes;

import com.example.laddersandsnakesfinal.Model.Interfaces.IMoveStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderMoveStrategyTest {
    @Test
    public void testHandleMove1() {
        List<Integer> laddersPos = Arrays.asList(5, 9);
        IMoveStrategy ladderMoveStrategy = new LadderMoveStrategy(laddersPos);
        int initialPosition = 5;
        int newPosition = ladderMoveStrategy.handleMove(initialPosition);
        assertEquals(9, newPosition);
    }
    @Test
    public void testHandleMove2() {
        List<Integer> laddersPos = Arrays.asList(15, 25);
        IMoveStrategy ladderMoveStrategy = new LadderMoveStrategy(laddersPos);
        int initialPosition = 15;
        int newPosition = ladderMoveStrategy.handleMove(initialPosition);
        assertEquals(25, newPosition);
    }
    @Test
    public void testHandleMove3() {
        List<Integer> laddersPos = Arrays.asList(18, 80);
        IMoveStrategy ladderMoveStrategy = new LadderMoveStrategy(laddersPos);
        int initialPosition = 18;
        int newPosition = ladderMoveStrategy.handleMove(initialPosition);
        assertEquals(80, newPosition);
    }
    @Test
    public void testHandleMove4() {
        List<Integer> laddersPos = Arrays.asList(44, 86);
        IMoveStrategy ladderMoveStrategy = new LadderMoveStrategy(laddersPos);
        int initialPosition = 44;
        int newPosition = ladderMoveStrategy.handleMove(initialPosition);
        assertEquals(86, newPosition);
    }
    @Test
    public void testHandleMove5() {
        List<Integer> laddersPos = Arrays.asList(47, 68);
        IMoveStrategy ladderMoveStrategy = new LadderMoveStrategy(laddersPos);
        int initialPosition = 47;
        int newPosition = ladderMoveStrategy.handleMove(initialPosition);
        assertEquals(68, newPosition);
    }

    @Test
    public void testHandleMove6() {
        List<Integer> laddersPos = Arrays.asList(63, 78);
        IMoveStrategy ladderMoveStrategy = new LadderMoveStrategy(laddersPos);
        int initialPosition = 63;
        int newPosition = ladderMoveStrategy.handleMove(initialPosition);
        assertEquals(78, newPosition);
    }
    @Test
    public void testHandleMove7() {
        List<Integer> laddersPos = Arrays.asList(71, 94);
        IMoveStrategy ladderMoveStrategy = new LadderMoveStrategy(laddersPos);
        int initialPosition = 71;
        int newPosition = ladderMoveStrategy.handleMove(initialPosition);
        assertEquals(94, newPosition);
    }
    @Test
    public void testHandleMove8() {
        List<Integer> laddersPos = Arrays.asList(81, 98);
        IMoveStrategy ladderMoveStrategy = new LadderMoveStrategy(laddersPos);
        int initialPosition = 81;
        int newPosition = ladderMoveStrategy.handleMove(initialPosition);
        assertEquals(98, newPosition);
    }
}