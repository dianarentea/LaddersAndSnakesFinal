package com.example.laddersandsnakesfinal.Controller;

import javafx.scene.paint.Paint;
import org.junit.jupiter.api.Test;
import javafx.scene.paint.Color;

import static org.junit.jupiter.api.Assertions.*;

class IndexedRegionTest {
    @Test
    public void testInitialization() {
        IndexedRegion indexedRegion = new IndexedRegion(1);
        // Verificăm că obiectul a fost creat cu succes
        assertNotNull(indexedRegion);
        // Verificăm că indexul a fost setat corect
        assertEquals(1, indexedRegion.getIndex());
        // Verificăm că dimensiunile sunt setate corect
        assertEquals(50.0, indexedRegion.getMinWidth());
        assertEquals(50.0, indexedRegion.getMinHeight());
        assertEquals(50.0, indexedRegion.getMaxWidth());
        assertEquals(50.0, indexedRegion.getMaxHeight());
        // Verificăm că stilul a fost setat corect
        assertEquals("-fx-border-color: black; -fx-padding: 10px;", indexedRegion.getStyle());
    }

    @Test
    public void testSetIndex() {
        IndexedRegion indexedRegion = new IndexedRegion(1);

        // Setăm un nou index
        indexedRegion.setIndex(2);

        // Verificăm că indexul a fost actualizat
        assertEquals(2, indexedRegion.getIndex());
    }

}