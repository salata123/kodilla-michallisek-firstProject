package com.kodilla.input;

import com.kodilla.graphics.TictactoeBoard;
import com.kodilla.logic.TictactoeLogic;

import java.util.Random;

public class TictactoeAI {
    private Random random = new Random();

    //Random AI field selection
    public void aiFieldSelection(TictactoeBoard tictactoeBoard, String type, TictactoeLogic logic) {
        int x = 0;
        int y = 0;
        while (true) {
            x = random.nextInt(tictactoeBoard.getSize());
            System.out.println("AI column choice: " + (x + 1));

            y = random.nextInt(tictactoeBoard.getSize());
            System.out.println("AI row choice: " + (y + 1));

            //Checking if a field wanted by AI is empty
            if (logic.isFieldEmptyAI(x, y, tictactoeBoard)) {
                break;
            }
        }
        tictactoeBoard.updateBoard(x, y, type);
    }
}
