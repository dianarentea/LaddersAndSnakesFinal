package com.example.laddersandsnakesfinal.Model.Classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testSnakeMove() {
        Board board = new Board();
        board.initializeBoard();
        // Testează câteva mișcări de șarpe
        assertEquals(3, board.handleSnakeMove(6));  // Dacă șarpele începe de la 15, ar trebui să se mute la 16
        assertEquals(19, board.handleSnakeMove(42));  // Dacă șarpele începe de la 43, ar trebui să se mute la 42

        // Adăugați mai multe teste aici în funcție de scenariile relevante pentru jocul dvs.
        // Testați dacă șarpele nu se mișcă dacă nu este pe o poziție de șarpe
        assertEquals(0, board.handleSnakeMove(7));
        // Testează dacă șarpele nu se mișcă dacă este pe o poziție de șarpe, dar aceasta este poziția finală a șarpelui
        assertEquals(0, board.handleSnakeMove(66));
    }
    @Test
    void testLadderMove() {
        Board board = new Board();
        board.initializeBoard();

        // Testează câteva mișcări pe scară
        assertEquals(9, board.handleLadderMove(5));   // Dacă este la poziția 5, ar trebui să se mute la 9
        assertEquals(25, board.handleLadderMove(15));  // Dacă este la poziția 18, ar trebui să se mute la 80
        // Adăugați mai multe teste aici în funcție de scenariile relevante pentru jocul dvs.

        // Testați dacă scară nu se mișcă dacă nu este pe o poziție de scară
        assertEquals(0, board.handleLadderMove(25));

        // Testează dacă scară nu se mișcă dacă este pe o poziție de scară, dar aceasta este poziția finală a scării
        assertEquals(0, board.handleLadderMove(98));
    }
}