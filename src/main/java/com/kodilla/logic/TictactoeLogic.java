package com.kodilla.logic;

import com.kodilla.graphics.TictactoeBoard;
import com.kodilla.input.TictactoeAI;
import com.kodilla.input.TictactoeInput;

public class TictactoeLogic {

    //Checking a win for columns
    public boolean winCheckColumns(TictactoeBoard board, int gameSize, TictactoePlayerQueue playerQueue, int playerID) {
        int count = 0;
        int requiredScore = 0;
        if (gameSize == 1){
            requiredScore = 3;
        } else if (gameSize == 2){
            requiredScore = 5;
        }
        //Check columns
        for (int j = 0; j < board.getSize(); j++) {
            count = 0;
            for (int i = 0; i < board.getSize(); i++) {
                if (board.getBoard()[i][j].equals(playerQueue.getCurrentPlayerSymbol(playerID))) {
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

    //Checking a win for rows
    public boolean winCheckRows(TictactoeBoard board, int gameSize, TictactoePlayerQueue playerQueue, int playerID) {
        int count = 0;
        int requiredScore = 0;
        if (gameSize == 1){
            requiredScore = 3;
        } else if (gameSize == 2){
            requiredScore = 5;
        }
        //Check columns
        for (int i = 0; i < board.getSize(); i++) {
            count = 0;
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getBoard()[i][j].equals(playerQueue.getCurrentPlayerSymbol(playerID))) {
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

    //Checking a win for diagonals
    public boolean winCheckDiagonals(TictactoeBoard board, int gameSize, TictactoePlayerQueue playerQueue, int playerID) {
        int count = 0;
        int requiredScore = 0;
        if (gameSize == 1){
            requiredScore = 3;
        } else if (gameSize == 2){
            requiredScore = 5;
        }
        for (int i = 0; i <= board.getSize() - requiredScore; i++) {
            count = 0;
            for (int j = 0; j < board.getSize() - requiredScore + 1; j++) {
                for (int k = 0; k < requiredScore; k++) {
                    if (board.getBoard()[i + k][j + k].equals(playerQueue.getCurrentPlayerSymbol(playerID))) {
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

    //Merged win checks
    public boolean winCheckAll(TictactoeBoard board, int gameSize, TictactoePlayerQueue playerQueue, int playerID) {
        System.out.println("Checking win for " + playerQueue.getCurrentPlayerName(playerID) + " " + playerQueue.getCurrentPlayerSymbol(playerID));
        return winCheckColumns(board, gameSize, playerQueue, playerID) || winCheckRows(board, gameSize, playerQueue, playerID) || winCheckDiagonals(board, gameSize, playerQueue, playerID);
    }

    //Checking if a field wanted by a player is empty
    public boolean isFieldEmpty(int x, int y, TictactoeBoard tictactoeBoard) {
        if (tictactoeBoard.getBoard()[x][y].equals("|X|") || tictactoeBoard.getBoard()[x][y].equals("|O|")) {
            System.out.println("Field is already taken. Please choose an empty field.");
            return false;
        } else {
            return true;
        }
    }

    //Checking if a field wanted by a AI is empty
    public boolean isFieldEmptyAI(int x, int y, TictactoeBoard tictactoeBoard) {
        if (tictactoeBoard.getBoard()[x][y].equals("|X|") || tictactoeBoard.getBoard()[x][y].equals("|O|")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean playerTurn(TictactoeBoard tictactoeBoard, int gameSize, TictactoeInput tictactoeInput, TictactoePlayerQueue playerQueue, int playerID, int gameType) {
        System.out.println(playerQueue.getCurrentPlayerName(playerID) + "'s with symbol " + playerQueue.getCurrentPlayerSymbol(playerID) + " turn");
        tictactoeBoard.printBoard();

        if(gameType == 2 && playerID == 1) {
            TictactoeAI tictactoeAI = new TictactoeAI();
            tictactoeAI.aiFieldSelection(tictactoeBoard, playerQueue.getCurrentPlayerSymbol(playerID), this);
        } else {
            tictactoeInput.playerFieldChoice(tictactoeBoard, playerQueue.getCurrentPlayerSymbol(playerID));
        }

        //Checking if player won
        if (winCheckAll(tictactoeBoard, gameSize, playerQueue, playerID)) {
            tictactoeBoard.printBoard();
            System.out.println(playerQueue.getCurrentPlayerName(playerID) + " wins!");
            playerQueue.getCurrentPlayer(playerID).add1Score();
            for(int i = 0; i < playerQueue.getPlayerQueue().size(); i++){
                if (!(playerQueue.getCurrentPlayer(i).equals(playerQueue.getCurrentPlayer(playerID)))){
                    playerQueue.getCurrentPlayer(i).remove1Live();
                }
            }
            System.out.println("Player List: " + playerQueue.getPlayerQueue());
            playerQueue.getAllPlayersLives();
            return false;
        } else {
            return true;
        }
    }
}
