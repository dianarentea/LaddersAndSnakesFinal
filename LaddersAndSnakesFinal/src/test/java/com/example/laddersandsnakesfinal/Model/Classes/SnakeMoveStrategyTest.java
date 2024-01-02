package com.example.laddersandsnakesfinal.Model.Classes;

import com.example.laddersandsnakesfinal.Model.Interfaces.IMoveStrategy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SnakeMoveStrategyTest {
    @Test
    public void testHandleMove1() {

        testHandleMove(6,3);

    }
    @Test
    public void testHandleMove2() {
        testHandleMove(42,19);
    }
    @Test
    public void testHandleMove3() {
        testHandleMove(45,36);
    }
    @Test
    public void testHandleMove4() {
        testHandleMove(51,13);
    }
    @Test
    public void testHandleMove5() {
        testHandleMove(67,54);
    }
    @Test
    public void testHandleMove6() {
        testHandleMove(83,62);
    }
    @Test
    public void testHandleMove7() {
        testHandleMove(90,87);
    }
    @Test
    public void testHandleMove8() {
        testHandleMove(96,66);
    }

    private void testHandleMove(int initialPosition, int expectedNewPosition) {
        // Creăm un mock pentru IMoveStrategy
        IMoveStrategy mockMoveStrategy = Mockito.mock(IMoveStrategy.class);

        // Definim comportamentul mock-ului
        when(mockMoveStrategy.handleMove(initialPosition)).thenReturn(expectedNewPosition);

        // Apelăm metoda și verificăm rezultatul
        int actualNewPosition = mockMoveStrategy.handleMove(initialPosition);
        assertEquals(expectedNewPosition, actualNewPosition);
    }
}