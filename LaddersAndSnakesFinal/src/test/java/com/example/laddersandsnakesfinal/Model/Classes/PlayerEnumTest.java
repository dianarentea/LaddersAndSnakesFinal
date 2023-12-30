package com.example.laddersandsnakesfinal.Model.Classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerEnumTest {
    @Test
    public void testGetName() {
        PlayerEnum player = PlayerEnum.PLAYER1;
        assertEquals("Player 1", player.getName());
    }

    @Test
    public void testGetImageUrl() {
        PlayerEnum player = PlayerEnum.PLAYER2;
        assertEquals("/p2.png", player.getImageUrl());
    }

    @Test
    public void testInitialPosition() {
        PlayerEnum player = PlayerEnum.PLAYER1;
        assertEquals(1, player.getPosition());
    }

    @Test
    public void testSetPosition() {
        PlayerEnum player = PlayerEnum.PLAYER2;
        player.setPosition(5);
        assertEquals(5, player.getPosition());
    }

}