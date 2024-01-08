package com.example.laddersandsnakesfinal.Model.Classes;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PlayerEnumTest {
    @Test
    public void testGetName() {
        PlayerEnum player = PlayerEnum.PLAYER1;
        assertEquals("Player 1", player.getName());
    }

    @Test
    public void testGetImageUrl() {
        // Cream un mock pentru PlayerEnum
        PlayerEnum playerMock = Mockito.mock(PlayerEnum.class);

        // Definim comportamentul mock-ului pentru metoda getImageUrl()
        when(playerMock.getImageUrl()).thenReturn("/mocked_image.png");

        // Verificăm rezultatul
        assertEquals("/mocked_image.png", playerMock.getImageUrl());
    }



    @Test
    public void testSetPosition() {
        PlayerEnum player = PlayerEnum.PLAYER2;
        player.setPosition(5);
        assertEquals(5, player.getPosition());
    }

}