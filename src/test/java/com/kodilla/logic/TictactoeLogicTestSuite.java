package com.kodilla.logic;

import com.kodilla.graphics.TictactoeBoard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class TictactoeLogicTestSuite {
//    @Test
//    @DisplayName("Win check for Player1 test")
//    void winCheckPlayer1Test() {
//        TictactoeBoard tictactoeBoardRows = new TictactoeBoard();
//        TictactoeBoard tictactoeBoardColumns = new TictactoeBoard();
//        TictactoeBoard tictactoeBoardDiagonals = new TictactoeBoard();
//        TictactoeLogic tictactoeLogic = new TictactoeLogic();
//        String playerType = "|X|";
//        boolean expectedResult = true;
//
//        tictactoeBoardRows.initializeBoard();
//        tictactoeBoardColumns.initializeBoard();
//        tictactoeBoardDiagonals.initializeBoard();
//
//        //Board with a row win
//        tictactoeBoardRows.updateBoard(0, 0,  playerType);
//        tictactoeBoardRows.updateBoard(0, 1,  playerType);
//        tictactoeBoardRows.updateBoard(0, 2,  playerType);
//
//        //Board with a column win
//        tictactoeBoardColumns.updateBoard(0, 0, playerType);
//        tictactoeBoardColumns.updateBoard(1, 0, playerType);
//        tictactoeBoardColumns.updateBoard(2, 0, playerType);
//
//        //Board with a diagonal win
//        tictactoeBoardDiagonals.updateBoard(0, 0, playerType);
//        tictactoeBoardDiagonals.updateBoard(1, 1, playerType);
//        tictactoeBoardDiagonals.updateBoard(2, 2, playerType);
//
//        assertEquals(expectedResult, tictactoeLogic.winCheckPlayer1(tictactoeBoardRows));
//        assertEquals(expectedResult, tictactoeLogic.winCheckPlayer1(tictactoeBoardColumns));
//        assertEquals(expectedResult, tictactoeLogic.winCheckPlayer1(tictactoeBoardDiagonals));
//    }
//
//    @Test
//    @DisplayName("Win check for Player2 test")
//    void winCheckPlayer2Test() {
//        TictactoeBoard tictactoeBoardRows = new TictactoeBoard();
//        TictactoeBoard tictactoeBoardColumns = new TictactoeBoard();
//        TictactoeBoard tictactoeBoardDiagonals = new TictactoeBoard();
//        TictactoeLogic tictactoeLogic = new TictactoeLogic();
//        String playerType = "|O|";
//        boolean expectedResult = true;
//
//        tictactoeBoardRows.initializeBoard();
//        tictactoeBoardColumns.initializeBoard();
//        tictactoeBoardDiagonals.initializeBoard();
//
//        //Board with a row win
//        tictactoeBoardRows.updateBoard(0, 0,  playerType);
//        tictactoeBoardRows.updateBoard(0, 1,  playerType);
//        tictactoeBoardRows.updateBoard(0, 2,  playerType);
//
//        //Board with a column win
//        tictactoeBoardColumns.updateBoard(0, 0, playerType);
//        tictactoeBoardColumns.updateBoard(1, 0, playerType);
//        tictactoeBoardColumns.updateBoard(2, 0, playerType);
//
//        //Board with a diagonal win
//        tictactoeBoardDiagonals.updateBoard(0, 0, playerType);
//        tictactoeBoardDiagonals.updateBoard(1, 1, playerType);
//        tictactoeBoardDiagonals.updateBoard(2, 2, playerType);
//
//        assertEquals(expectedResult, tictactoeLogic.winCheckPlayer2All(tictactoeBoardRows, ));
//        assertEquals(expectedResult, tictactoeLogic.winCheckPlayer2(tictactoeBoardColumns));
//        assertEquals(expectedResult, tictactoeLogic.winCheckPlayer2(tictactoeBoardDiagonals));
//    }

    @Test
    @DisplayName("Tests if field filled")
    void isFieldFilledTest() {
        TictactoeBoard tictactoeBoard = new TictactoeBoard();
        TictactoeLogic tictactoeLogic = new TictactoeLogic();

        tictactoeBoard.initializeBoard();
        int x = 1;
        int y = 1;
        int x2 = 2;
        int y2 = 2;
        String type = "|X|";
        String type2 = "|O|";
        tictactoeBoard.updateBoard(x, y, type);
        tictactoeBoard.updateBoard(x2, y2, type2);

        assertTrue(tictactoeLogic.isFieldEmpty(0, 0, tictactoeBoard));
        assertFalse(tictactoeLogic.isFieldEmpty(x, y, tictactoeBoard));
        assertFalse(tictactoeLogic.isFieldEmpty(x2, y2, tictactoeBoard));
    }
}
