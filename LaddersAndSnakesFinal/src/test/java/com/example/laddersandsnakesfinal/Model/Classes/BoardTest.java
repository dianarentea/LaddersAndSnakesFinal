package com.example.laddersandsnakesfinal.Model.Classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testSnakeMove() {
        Board board = new Board();
        board.initializeBoard();

        assertEquals(3, board.handleSnakeMove(6));
        assertEquals(19, board.handleSnakeMove(42));

        assertEquals(0, board.handleSnakeMove(7));
        assertEquals(0, board.handleSnakeMove(66));
    }
    @Test
    void testLadderMove() {
        Board board = new Board();
        board.initializeBoard();

        assertEquals(9, board.handleLadderMove(5));
        assertEquals(25, board.handleLadderMove(15));

        assertEquals(0, board.handleLadderMove(25));
        assertEquals(0, board.handleLadderMove(98));
    }

}