package com.kodilla.logic;

import java.util.LinkedList;
import java.util.Queue;

public class TictactoePlayerQueue {
    private Queue<TictactoePlayer> playerQueue = new LinkedList<>();
    private Queue<TictactoePlayer> waitingList = new LinkedList<>();

    public void addPlayer (TictactoePlayer player){
        playerQueue.add(player);
    }
    public TictactoePlayer getCurrentPlayer (){
        return playerQueue.peek();
    }
    public String getCurrentPlayerName (){
        return playerQueue.peek().getPlayerName();
    }
    public void removeCurrentPlayer(){
        playerQueue.remove();
    }

    public String getCurrentPlayerSymbol(){
        return playerQueue.peek().getPlayerSymbol();
    }

    public Queue<TictactoePlayer> getPlayerQueue() {
        return playerQueue;
    }

    public void addPlayerToWaitingList(TictactoePlayer player){
        waitingList.add(player);
    }
    public void getPlayersFromWaitingList(){
        while (!waitingList.isEmpty()) {
            playerQueue.add(waitingList.poll());
        }
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

    public int getCurrentPlayerLives(){
        return playerQueue.peek().getPlayerLives();
    }
}
