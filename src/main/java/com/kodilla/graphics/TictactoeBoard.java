package com.kodilla.graphics;

import java.util.Arrays;

public class TictactoeBoard {
    private int size = 3;
    private String[][] board;
    private final char choiceEmpty = ' ';
    private final char choiceX = 'X';
    private final char choiceY = 'O';
    private final String field = "| |";

    public String[][] getBoard() {
        return board;
    }
    public void printBoard() {
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void setSize(int size) {
        this.size = size;
    }


    public int getSize() {
        return size;
    }


    //Board creating method
    public String[][] initializeBoard() {
        System.out.println("Welcome to the TicTacToe game");
        board = new String[size][size];

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                board[i][j] = field;
            }
        }
        return board;
    }

    //Board updating method after player input
    public String[][] updateBoard(int x, int y, String type) {
        board[x][y] = type;
        return board;
    }

    @Override
    public String toString() {
        return "Board{" +
                "sizeX=" + size +
                ", board=" + Arrays.toString(board) +
                ", choiceEmpty=" + choiceEmpty +
                ", choiceX=" + choiceX +
                ", choiceY=" + choiceY +
                ", field='" + field + '\'' +
                '}';
    }
}
