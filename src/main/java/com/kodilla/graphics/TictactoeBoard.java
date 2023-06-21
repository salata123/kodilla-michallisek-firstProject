package com.kodilla.graphics;

import java.util.Arrays;

public class TictactoeBoard {
    private final int sizeX = 3;
    private final int sizeY = 3;
    private String[][] board;
    private final char choiceEmpty = ' ';
    private final char choiceX = 'X';
    private final char choiceY = 'O';
    private final String field = "| |";

    public String[][] getBoard() {
        return board;
    }
    public void printBoard(){
        for (int i = 0; i < sizeX; i++){
            for (int j = 0; j < sizeY; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    //Board creating method
    public String[][] initializeBoard(){
        System.out.println("Welcome to the TicTacToe game");
        board = new String[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++){
            for (int j = 0; j < sizeY; j++){
                board[i][j] = field;
            }
        }
        return board;
    }

    //Board updating method after player input
    public String[][] updateBoard(int x, int y, char type){
        if (type == 'X'){
            board[x][y] = "|X|";
        } else {
            board[x][y] = "|O|";
        }
        return board;
    }

    @Override
    public String toString() {
        return "Board{" +
                "sizeX=" + sizeX +
                ", sizeY=" + sizeY +
                ", board=" + Arrays.toString(board) +
                ", choiceEmpty=" + choiceEmpty +
                ", choiceX=" + choiceX +
                ", choiceY=" + choiceY +
                ", field='" + field + '\'' +
                '}';
    }
}
