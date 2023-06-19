package com.kodilla.Logic;

import com.kodilla.Graphics.Board;

public class TictactoeLogic {
    private int player1Score;
    private int player2Score;

    //Checking the board to see if player 1 won
    public boolean winCheckPlayer1(String[][] board){
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals("|X|") && board[i][1].equals("|X|") && board[i][2].equals("|X|")) {
                System.out.println("Player 1 wins!");
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j].equals("|X|") && board[1][j].equals("|X|") && board[2][j].equals("|X|")) {
                System.out.println("Player 1 wins!");
                return true;
            }
        }

        // Check diagonals
        if (board[0][0].equals("|X|") && board[1][1].equals("|X|") && board[2][2].equals("|X|")) {
            System.out.println("Player 1 wins!");
            return true;
        }
        if (board[0][2].equals("|O|") && board[1][1].equals("|O|") && board[2][0].equals("|O|")) {
            System.out.println("Player 1 wins!");
            return true;
        }
        return false;
    }

    //Checking the board to see if player 2 won
    public boolean winCheckPlayer2(String[][] board){
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals("|O|") && board[i][1].equals("|O|") && board[i][2].equals("|O|")) {
                System.out.println("Player 2 wins!");
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j].equals("|O|") && board[1][j].equals("|O|") && board[2][j].equals("|O|")) {
                System.out.println("Player 2 wins!");
                return true;
            }
        }

        // Check diagonals
        if (board[0][0].equals("|O|") && board[1][1].equals("|O|") && board[2][2].equals("|O|")) {
            System.out.println("Player 2 wins!");
            return true;
        }
        if (board[0][2].equals("|O|") && board[1][1].equals("|O|") && board[2][0].equals("|O|")) {
            System.out.println("Player 2 wins!");
            return true;
        }
        return false;
    }

    //Checking if a field wanted by a player is empty
    public boolean isFieldEmpty(int x, int y, Board board){
        if (board.getBoard()[x][y].equals("|X|") || board.getBoard()[x][y].equals("|O|")){
            System.out.println("Field is already taken. Please choose an empty field.");
            return false;
        } else {
            return true;
        }
    }


}
