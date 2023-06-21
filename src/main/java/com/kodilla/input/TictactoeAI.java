package com.kodilla.input;

import com.kodilla.graphics.TictactoeBoard;
import com.kodilla.logic.TictactoeLogic;

import java.util.Random;

public class TictactoeAI {
    private int x;
    private int y;
    Random random = new Random();
    TictactoeLogic logic = new TictactoeLogic();

    public void aiFieldSelection(TictactoeBoard tictactoeBoard, char type){
        while (true) {
            x = random.nextInt(tictactoeBoard.getSizeX());
            System.out.println("AI column choice: " + (x + 1));

            y = random.nextInt(tictactoeBoard.getSizeY());
            System.out.println("AI row choice: " + (y + 1));

            //Checking if a field wanted by a AI is empty
            if (logic.isFieldEmptyAI(x, y, tictactoeBoard)) {
                break;
            }
        }
        tictactoeBoard.updateBoard(x, y, type);
    }
}