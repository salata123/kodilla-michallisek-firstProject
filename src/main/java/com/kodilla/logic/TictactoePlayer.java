package com.kodilla.logic;

import java.util.Objects;

public class TictactoePlayer {
    private int playerID;
    private String playerName;
    private String playerSymbol;
    private int playerScore;
    private int playerLives;

    public TictactoePlayer(int playerID, String playerName, String playerSymbol, int playerScore, int playerLives) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;
        this.playerScore = playerScore;
        this.playerLives = playerLives;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerSymbol() {
        return playerSymbol;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getPlayerLives() {
        return playerLives;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void remove1Live(){
        playerLives --;
    }

    public void add1Score(){
        playerScore ++;
    }


    @Override
    public String toString() {
        return "TictactoePlayer{" +
                "playerID=" + playerID +
                ", playerName='" + playerName + '\'' +
                ", playerSymbol='" + playerSymbol + '\'' +
                ", playerScore=" + playerScore +
                ", playerLives=" + playerLives +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TictactoePlayer player = (TictactoePlayer) o;
        return playerID == player.playerID && playerScore == player.playerScore && playerLives == player.playerLives && Objects.equals(playerName, player.playerName) && Objects.equals(playerSymbol, player.playerSymbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerID, playerName, playerSymbol, playerScore, playerLives);
    }
}
