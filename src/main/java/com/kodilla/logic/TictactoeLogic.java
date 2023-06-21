package com.kodilla.logic;

import com.kodilla.graphics.TictactoeBoard;
import com.kodilla.input.TictactoeAI;
import com.kodilla.input.TictactoeInput;

public class TictactoeLogic {
    //Checking the board to see if player 1 won
    public boolean winCheckPlayer1(String[][] board){
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals("|X|") && board[i][1].equals("|X|") && board[i][2].equals("|X|")) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j].equals("|X|") && board[1][j].equals("|X|") && board[2][j].equals("|X|")) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0].equals("|X|") && board[1][1].equals("|X|") && board[2][2].equals("|X|")) {
            return true;
        }
        if (board[0][2].equals("|X|") && board[1][1].equals("|X|") && board[2][0].equals("|X|")) {
            return true;
        }
        return false;
    }

    //Checking the board to see if player 2 won
    public boolean winCheckPlayer2(String[][] board){
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals("|O|") && board[i][1].equals("|O|") && board[i][2].equals("|O|")) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j].equals("|O|") && board[1][j].equals("|O|") && board[2][j].equals("|O|")) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0].equals("|O|") && board[1][1].equals("|O|") && board[2][2].equals("|O|")) {
            return true;
        }
        if (board[0][2].equals("|O|") && board[1][1].equals("|O|") && board[2][0].equals("|O|")) {
            return true;
        }
        return false;
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

    public boolean player1Turn (TictactoeBoard tictactoeBoard, char player1Type){
        TictactoeInput tictactoeInput = new TictactoeInput();
        System.out.println("Player 1 turn");
        tictactoeBoard.printBoard();
        tictactoeInput.playerFieldChoice(tictactoeBoard, player1Type);
        if (winCheckPlayer1(tictactoeBoard.getBoard())) {
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
        if (winCheckPlayer2(tictactoeBoard.getBoard())) {
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
        if (winCheckPlayer2(tictactoeBoard.getBoard())) {
            tictactoeBoard.printBoard();
            System.out.println("AI wins!");
            return false;
        } else {
            return true;
        }
    }
}
