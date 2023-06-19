package com.kodilla.Graphics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TictactoeGraphicsTestSuite {
    @Test
    @DisplayName("Empty board test")
    void emptyBoardTest() {
        Board board = new Board();
        board.initializeBoard();

        String expectedField = "| |";
        for (int i = 0; i < board.getSizeX(); i++){
            for (int j = 0; j < board.getSizeY(); j++){
                assertEquals(expectedField, board.getBoard()[i][j]);
            }
        }
    }
}
