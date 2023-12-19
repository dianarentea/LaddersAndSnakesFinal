package com.example.laddersandsnakesfinal.Model.Classes;

public enum PlayerEnum {
    PLAYER1("Player 1", "/p1.png"),
    PLAYER2("Player 2", "/p2.png");

    private String name;
    private String imageUrl;
    private int position;

    PlayerEnum(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.position = 1;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int newPosition) {
        this.position = newPosition;
    }

}
