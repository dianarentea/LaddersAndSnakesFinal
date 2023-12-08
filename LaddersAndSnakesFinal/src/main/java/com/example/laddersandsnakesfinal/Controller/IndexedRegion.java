package com.example.laddersandsnakesfinal.Controller;
import javafx.scene.layout.Region;

public class IndexedRegion extends Region{
    private int index;

    public IndexedRegion(int index) {
        this.index = index;
        setMinSize(50.0, 50.0);
        setMaxSize(50.0, 50.0);
        setStyle("-fx-border-color: black; -fx-padding: 10px;");
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
