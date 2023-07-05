package com.kodilla.logic;

import java.util.ArrayList;

public class TictactoePlayerQueue {
    private ArrayList<TictactoePlayer> playerQueue = new ArrayList<>();
    private ArrayList<TictactoePlayer> waitingList = new ArrayList<>();

    public void addPlayer (TictactoePlayer player){
        playerQueue.add(player);
    }

    public TictactoePlayer getCurrentPlayer (int index){
        for (TictactoePlayer player : playerQueue) {
            if (player.getPlayerID() == index) {
                return player;
            }
        }
        System.out.println("Cannot find player with this ID.");
        return null;
    }

    public String getCurrentPlayerName (int index){
        for (TictactoePlayer player : playerQueue) {
            if (player.getPlayerID() == index) {
                return player.getPlayerName();
            }
        }
        System.out.println("Cannot find player with this ID.");
        return null;
    }

    public void removeCurrentPlayer(int index){
        playerQueue.remove(index);
    }

    public String getCurrentPlayerSymbol(int index){
        for (TictactoePlayer player : playerQueue) {
            if (player.getPlayerID() == index) {
                return player.getPlayerSymbol();
            }
        }
        System.out.println("Cannot find player with this ID.");
        return null;
    }

    public ArrayList<TictactoePlayer> getPlayerQueue() {
        return playerQueue;
    }

    public void addCurrentPlayerToWaitingList(int index){
        for (TictactoePlayer player : playerQueue) {
            if (player.getPlayerID() == index) {
                waitingList.add(player);
            }
        }
        System.out.println("Cannot find player with this ID.");
    }
    public void getPlayersFromWaitingList(){
        playerQueue.addAll(waitingList);
    }

    public void getAllPlayersLives(){
        for(TictactoePlayer player : getPlayerQueue()){
            System.out.println(player.getPlayerName() + " has " + player.getPlayerLives() + " lives");
        }
    }

    public boolean checkPlayerLives(){
        for(TictactoePlayer player : getPlayerQueue()){
            if (player.getPlayerLives() == 0){
                return false;
            }
        }
        return true;
    }

    public void getAllPlayersScore(){
        for(TictactoePlayer player : getPlayerQueue()){
            System.out.println(player.getPlayerName() + " has " + player.getPlayerScore() + " points");
        }
    }

    public int getCurrentPlayerLives(int index){
        for (TictactoePlayer player : playerQueue) {
            if (player.getPlayerID() == index) {
                return player.getPlayerLives();
            }
        }
        System.out.println("Cannot find player with this ID.");
        return 0;
    }
}
