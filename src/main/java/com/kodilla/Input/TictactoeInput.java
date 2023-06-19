package com.kodilla.Input;

import com.kodilla.Graphics.Board;
import com.kodilla.Logic.TictactoeLogic;

import java.util.Scanner;

public class TictactoeInput {
    TictactoeLogic logic = new TictactoeLogic();
    Scanner scanner = new Scanner(System.in);
    int x;
    int y;

    //Input column selection with input validation
    public void columnSelection(Board board){
        boolean validInput = false;
        while (!validInput) {
            if (scanner.hasNextInt()) {
                x = scanner.nextInt() - 1;
                if (x >= 0 && x < board.getSizeX()) {
                    validInput = true;
                } else {
                    scanner.next();
                    System.out.println("Invalid input! Please enter a number between 1 and " + board.getSizeX());
                }
            }
        }
    }
    //Input row selection with input validation
    public void rowSelection(Board board){
        boolean validInput2 = false;
        while (!validInput2) {
            if (scanner.hasNextInt()) {
                y = scanner.nextInt() - 1;
                if (y >= 0 && y < board.getSizeX()) {
                    validInput2 = true;
                } else {
                    scanner.next();
                    System.out.println("Invalid input! Please enter a number between 1 and " + board.getSizeX());
                }
            }
        }
    }

    //Updating the board
    public void playerFieldChoice (Board board, char type) {
        while (true) {
            System.out.println("Select a column: ");
            columnSelection(board);

            System.out.println("Select a row: ");
            rowSelection(board);

            //Checking if a field wanted by a player is empty
            if (logic.isFieldEmpty(x, y, board)) {
                break;
            } else {
                System.out.println("Please choose an empty field.");
            }
        }
        board.updateBoard(x, y, type);
    }

}
