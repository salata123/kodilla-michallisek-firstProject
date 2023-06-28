package com.kodilla.logic;

import com.kodilla.graphics.TictactoeBoard;
import com.kodilla.input.TictactoeAI;
import com.kodilla.input.TictactoeInput;

public class TictactoeLogic {
    //Checking the board to see if player 1 won
    public boolean winCheckPlayer1(TictactoeBoard board){
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board.getBoard()[i][0].equals("|X|") && board.getBoard()[i][1].equals("|X|") && board.getBoard()[i][2].equals("|X|")) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board.getBoard()[0][j].equals("|X|") && board.getBoard()[1][j].equals("|X|") && board.getBoard()[2][j].equals("|X|")) {
                return true;
            }
        }

        // Check diagonals
        if (board.getBoard()[0][0].equals("|X|") && board.getBoard()[1][1].equals("|X|") && board.getBoard()[2][2].equals("|X|")) {
            return true;
        }
        if (board.getBoard()[0][2].equals("|X|") && board.getBoard()[1][1].equals("|X|") && board.getBoard()[2][0].equals("|X|")) {
            return true;
        }
        return false;
    }

    //Checking the board to see if player 2 won
    public boolean winCheckPlayer2(TictactoeBoard board){
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board.getBoard()[i][0].equals("|O|") && board.getBoard()[i][1].equals("|O|") && board.getBoard()[i][2].equals("|O|")) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board.getBoard()[0][j].equals("|O|") && board.getBoard()[1][j].equals("|O|") && board.getBoard()[2][j].equals("|O|")) {
                return true;
            }
        }

        // Check diagonals
        if (board.getBoard()[0][0].equals("|O|") && board.getBoard()[1][1].equals("|O|") && board.getBoard()[2][2].equals("|O|")) {
            return true;
        }
        if (board.getBoard()[0][2].equals("|O|") && board.getBoard()[1][1].equals("|O|") && board.getBoard()[2][0].equals("|O|")) {
            return true;
        }
        return false;
    }

    public boolean winCheckPlayer1Columns(TictactoeBoard board, int gameSize){
        int count = 0;
        int requiredScore = 0;
        if (gameSize == 1){
            requiredScore = 3;
        } else if (gameSize == 2){
            requiredScore = 5;
        }
        //Check columns
        for(int i = 0; i < board.getSizeX(); i++){
            count = 0;
            for(int j = 0; j < board.getSizeY(); j++){
                if(board.getBoard()[i][j] == "|X|"){
                    count++;
                } else {
                    count = 0;
                }
            }
        }
        return count == requiredScore;
    }

    public boolean winCheckPlayer1Rows(TictactoeBoard board, int gameSize){
        int count = 0;
        int requiredScore = 0;
        if (gameSize == 1){
            requiredScore = 3;
        } else if (gameSize == 2){
            requiredScore = 5;
        }
        //Check columns
        for(int i = 0; i < board.getSizeY(); i++){
            count = 0;
            for(int j = 0; j < board.getSizeX(); j++){
                if(board.getBoard()[i][j] == "|X|"){
                    count++;
                } else {
                    count = 0;
                }
            }
        }
        return count == requiredScore;
    }

    public boolean winCheckPlayer1Diagonals(TictactoeBoard board, int gameSize){
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
                    if (board.getBoard()[i + k][j + k].equals("|X|")) {
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

    public boolean player1Turn (TictactoeBoard tictactoeBoard, char player1Type, int gameSize){
        TictactoeInput tictactoeInput = new TictactoeInput();
        System.out.println("Player 1 turn");
        tictactoeBoard.printBoard();
        tictactoeInput.playerFieldChoice(tictactoeBoard, player1Type);
        if (winCheckPlayer1Diagonals(tictactoeBoard, gameSize)) {
            tictactoeBoard.printBoard();
            System.out.println("Player 1 wins!");
            return false;
        } else {
            return true;
        }
    }

    public boolean player2Turn (TictactoeBoard tictactoeBoard, char player2Type){
        TictactoeInput tictactoeInput = new TictactoeInput();
        System.out.println("Player 2 turn");
        tictactoeBoard.printBoard();
        tictactoeInput.playerFieldChoice(tictactoeBoard, player2Type);
        if (winCheckPlayer2(tictactoeBoard)) {
            tictactoeBoard.printBoard();
            System.out.println("Player 2 wins!");
            return false;
        } else {
            return true;
        }
    }

    public boolean aiTurn (TictactoeBoard tictactoeBoard, char player2Type){
        TictactoeAI tictactoeAI = new TictactoeAI();
        System.out.println("AI turn");
        tictactoeBoard.printBoard();
        tictactoeAI.aiFieldSelection(tictactoeBoard, player2Type);
        if (winCheckPlayer2(tictactoeBoard)) {
            tictactoeBoard.printBoard();
            System.out.println("AI wins!");
            return false;
        } else {
            return true;
        }
    }
}
