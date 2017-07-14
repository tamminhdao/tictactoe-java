package com.tictactoe;

public class MockGame implements GameInterface {
    boolean hasBeenPlayed = false;
    boolean hasAddedABoard = false;
    boolean addedPlayerOne = false;
    boolean addedPlayerTwo = false;

    public void addBoard(Board board) {
        hasAddedABoard = true;
    }

    public void addPlayerOne(Player player1) {
        addedPlayerOne = true;
    }

    public void addPlayerTwo(Player player2) {
        addedPlayerTwo = true;
    }

    public void play() {
        hasBeenPlayed = true;
    }
}
