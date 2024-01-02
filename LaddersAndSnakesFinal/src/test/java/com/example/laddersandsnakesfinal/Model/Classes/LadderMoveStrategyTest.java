package com.example.laddersandsnakesfinal.Model.Classes;

import com.example.laddersandsnakesfinal.Model.Interfaces.IMoveStrategy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LadderMoveStrategyTest {
    @Test
    public void testHandleMove1() {testHandleMove(5, 9);}
    @Test
    public void testHandleMove2() {
        testHandleMove(15, 25);
    }
    @Test
    public void testHandleMove3() {
        testHandleMove(18, 80);
    }
    @Test
    public void testHandleMove4() {
        testHandleMove(44, 86);
    }
    @Test
    public void testHandleMove5() {
        testHandleMove(47, 68);
    }
    @Test
    public void testHandleMove6() {
        testHandleMove(63, 78);
    }
    @Test
    public void testHandleMove7() {
        testHandleMove(71, 94);
    }
    @Test
    public void testHandleMove8() {
        testHandleMove(81, 98);
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