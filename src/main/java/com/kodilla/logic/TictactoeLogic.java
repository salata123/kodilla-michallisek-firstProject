package com.kodilla.logic;

import com.kodilla.graphics.TictactoeBoard;
import com.kodilla.input.TictactoeAI;
import com.kodilla.input.TictactoeInput;

public class TictactoeLogic {

    public boolean winCheckColumns(TictactoeBoard board, int gameSize, TictactoePlayerQueue playerQueue){
        int count = 0;
        int requiredScore = 0;
        if (gameSize == 1){
            requiredScore = 3;
        } else if (gameSize == 2){
            requiredScore = 5;
        }
        //Check columns
        for (int j = 0; j < board.getSizeY(); j++) {
            count = 0;
            for (int i = 0; i < board.getSizeX(); i++) {
                if (board.getBoard()[i][j].equals(playerQueue.getCurrentPlayerSymbol())) {
                    count++;
                    if (count == requiredScore) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    public boolean winCheckRows(TictactoeBoard board, int gameSize, TictactoePlayerQueue playerQueue){
        int count = 0;
        int requiredScore = 0;
        if (gameSize == 1){
            requiredScore = 3;
        } else if (gameSize == 2){
            requiredScore = 5;
        }
        //Check columns
        for (int i = 0; i < board.getSizeX(); i++) {
            count = 0;
            for (int j = 0; j < board.getSizeY(); j++) {
                if (board.getBoard()[i][j].equals(playerQueue.getCurrentPlayerSymbol())) {
                    count++;
                    if (count == requiredScore) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    public boolean winCheckDiagonals(TictactoeBoard board, int gameSize, TictactoePlayerQueue playerQueue){
        int count = 0;
        int requiredScore = 0;
        if (gameSize == 1){
            requiredScore = 3;
        } else if (gameSize == 2){
            requiredScore = 5;
        }
        for (int i = 0; i <= board.getSizeX() - requiredScore; i++) {
            count = 0;
            for (int j = 0; j < board.getSizeY() - requiredScore + 1; j++) {
                for (int k = 0; k < requiredScore; k++) {
                    if (board.getBoard()[i + k][j + k].equals(playerQueue.getCurrentPlayerSymbol())) {
                        count++;
                    } else {
                        count = 0;
                        break;
                    }
                }
                if (count == requiredScore) {
                    return true;
                }
            }
        }
        return count == requiredScore;
    }

    public boolean winCheckAll(TictactoeBoard board, int gameSize, TictactoePlayerQueue playerQueue){
        System.out.println("Checking win for " + playerQueue.getCurrentPlayerName() + " " + playerQueue.getCurrentPlayerSymbol());
        return winCheckColumns(board, gameSize, playerQueue) || winCheckRows(board, gameSize, playerQueue) || winCheckDiagonals(board, gameSize, playerQueue);
    }

    //Checking if a field wanted by a player is empty
    public boolean isFieldEmpty(int x, int y, TictactoeBoard tictactoeBoard){
        if (tictactoeBoard.getBoard()[x][y].equals("|X|") || tictactoeBoard.getBoard()[x][y].equals("|O|")){
            System.out.println("Field is already taken. Please choose an empty field.");
            return false;
        } else {
            return true;
        }
    }

    public boolean isFieldEmptyAI(int x, int y, TictactoeBoard tictactoeBoard){
        if (tictactoeBoard.getBoard()[x][y].equals("|X|") || tictactoeBoard.getBoard()[x][y].equals("|O|")){
            return false;
        } else {
            return true;
        }
    }

    public boolean playerTurn(TictactoeBoard tictactoeBoard, int gameSize, TictactoeInput tictactoeInput, TictactoePlayerQueue playerQueue){
        System.out.println(playerQueue.getCurrentPlayerName() + "'s with symbol " + playerQueue.getCurrentPlayerSymbol() + " turn");
        tictactoeBoard.printBoard();

        tictactoeInput.playerFieldChoice(tictactoeBoard, playerQueue.getCurrentPlayerSymbol());

        if (winCheckAll(tictactoeBoard, gameSize, playerQueue)) {
            tictactoeBoard.printBoard();
            System.out.println(playerQueue.getCurrentPlayerName() + " wins!");

            playerQueue.getCurrentPlayer().add1Score();
            playerQueue.addPlayerToWaitingList(playerQueue.getCurrentPlayer());
            playerQueue.removeCurrentPlayer();
            playerQueue.getCurrentPlayer().remove1Live();
            System.out.println("Player List: " + playerQueue.getPlayerQueue());
            playerQueue.getPlayersFromWaitingList();
            System.out.println("Player List: " + playerQueue.getPlayerQueue());
            playerQueue.getAllPlayersLives();
            return false;
        } else {
            playerQueue.addPlayerToWaitingList(playerQueue.getCurrentPlayer());
            playerQueue.removeCurrentPlayer();
            if (playerQueue.getPlayerQueue().isEmpty()){
                playerQueue.getPlayersFromWaitingList();
            }
            return true;
        }

    }

    public boolean aiTurn(TictactoeBoard tictactoeBoard, int gameSize, TictactoePlayerQueue playerQueue){
        TictactoeAI tictactoeAI = new TictactoeAI();
        System.out.println(playerQueue.getCurrentPlayerName() + "'s with symbol " + playerQueue.getCurrentPlayerSymbol() + " turn");
        tictactoeBoard.printBoard();

        tictactoeAI.aiFieldSelection(tictactoeBoard, playerQueue.getCurrentPlayerSymbol(), this);

        if (winCheckAll(tictactoeBoard, gameSize, playerQueue)) {
            tictactoeBoard.printBoard();
            System.out.println(playerQueue.getCurrentPlayerName() + " wins!");

            return false;
        } else {
            playerQueue.addPlayerToWaitingList(playerQueue.getCurrentPlayer());
            playerQueue.removeCurrentPlayer();
            if(playerQueue.getPlayerQueue().isEmpty()){
                playerQueue.getPlayersFromWaitingList();
            }
            return true;
        }
    }
}
