package com.kodilla.graphics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TictactoeGraphicsTestSuite {
    @Test
    @DisplayName("Empty board test")
    void emptyBoardTest() {
        TictactoeBoard tictactoeBoard = new TictactoeBoard();
        tictactoeBoard.initializeBoard();

        String expectedField = "| |";
        for (int i = 0; i < tictactoeBoard.getSizeX(); i++){
            for (int j = 0; j < tictactoeBoard.getSizeY(); j++){
                assertEquals(expectedField, tictactoeBoard.getBoard()[i][j]);
            }
        }
    }

    @Test
    @DisplayName("Updating board with 'X' test")
    void emptyBoardUpdateWithX() {
        TictactoeBoard tictactoeBoard = new TictactoeBoard();
        tictactoeBoard.initializeBoard();

        int x = 0;
        int y = 0;
        String type = "|X|";

        String expectedField = "|X|";
        tictactoeBoard.updateBoard(x, y, type);

        assertEquals(expectedField, tictactoeBoard.getBoard()[0][0]);
    }

    @Test
    @DisplayName("Updating board with 'O' test")
    void emptyBoardUpdateWithO() {
        TictactoeBoard tictactoeBoard = new TictactoeBoard();
        tictactoeBoard.initializeBoard();

        int x = 0;
        int y = 0;
        String type = "|O|";

        String expectedField = "|O|";
        tictactoeBoard.updateBoard(x, y, type);

        assertEquals(expectedField, tictactoeBoard.getBoard()[0][0]);
    }
}
