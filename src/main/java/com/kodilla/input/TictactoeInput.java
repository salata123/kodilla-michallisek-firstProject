package com.kodilla.input;

import com.kodilla.graphics.TictactoeBoard;
import com.kodilla.logic.TictactoeLogic;

import java.util.Scanner;

public class TictactoeInput {
    TictactoeLogic logic = new TictactoeLogic();
    Scanner scanner = new Scanner(System.in);
    int x;
    int y;

    //Input column selection with input validation
    public void columnSelection(TictactoeBoard tictactoeBoard){
        boolean validInput = false;
        while (!validInput) {
            if (scanner.hasNextInt()) {
                x = scanner.nextInt() - 1;
                if (x >= 0 && x < tictactoeBoard.getSizeX()) {
                    validInput = true;
                } else {
                    scanner.next();
                    System.out.println("Invalid input! Please enter a number between 1 and " + tictactoeBoard.getSizeX());
                }
            }
        }
    }
    //Input row selection with input validation
    public void rowSelection(TictactoeBoard tictactoeBoard){
        boolean validInput2 = false;
        while (!validInput2) {
            if (scanner.hasNextInt()) {
                y = scanner.nextInt() - 1;
                if (y >= 0 && y < tictactoeBoard.getSizeX()) {
                    validInput2 = true;
                } else {
                    scanner.next();
                    System.out.println("Invalid input! Please enter a number between 1 and " + tictactoeBoard.getSizeX());
                }
            }
        }
    }

    //Updating the board
    public void playerFieldChoice (TictactoeBoard tictactoeBoard, char type) {
        while (true) {
            System.out.println("Select a column: ");
            columnSelection(tictactoeBoard);

            System.out.println("Select a row: ");
            rowSelection(tictactoeBoard);

            //Checking if a field wanted by a player is empty
            if (logic.isFieldEmpty(x, y, tictactoeBoard)) {
                break;
            } else {
                System.out.println("Please choose an empty field.");
            }
        }
        tictactoeBoard.updateBoard(x, y, type);
    }

}
