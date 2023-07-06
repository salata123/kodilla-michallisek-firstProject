package com.kodilla.logic;

import com.kodilla.graphics.TictactoeBoard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class TictactoeLogicTestSuite {
    @Test
    @DisplayName("Win check for Player1 test with small board")
    void winCheckTestSmallBoardPlayer1() {
        TictactoeBoard tictactoeBoardRows = new TictactoeBoard();
        TictactoeBoard tictactoeBoardColumns = new TictactoeBoard();
        TictactoeBoard tictactoeBoardDiagonals = new TictactoeBoard();
        TictactoeLogic tictactoeLogic = new TictactoeLogic();
        TictactoePlayerQueue playerQueue = new TictactoePlayerQueue();

        String player1Type = "|X|";
        int gameSizeSmall = 1;

        TictactoePlayer player1 = new TictactoePlayer(0, "Player1", player1Type, 0, 1);
        playerQueue.addPlayer(player1);

        boolean expectedResult = true;

        tictactoeBoardRows.initializeBoard();
        tictactoeBoardColumns.initializeBoard();
        tictactoeBoardDiagonals.initializeBoard();

        //Board with a row win
        tictactoeBoardRows.updateBoard(0, 0,  player1.getPlayerSymbol());
        tictactoeBoardRows.updateBoard(0, 1,  player1.getPlayerSymbol());
        tictactoeBoardRows.updateBoard(0, 2,  player1.getPlayerSymbol());

        //Board with a column win
        tictactoeBoardColumns.updateBoard(0, 0, player1.getPlayerSymbol());
        tictactoeBoardColumns.updateBoard(1, 0, player1.getPlayerSymbol());
        tictactoeBoardColumns.updateBoard(2, 0, player1.getPlayerSymbol());

        //Board with a diagonal win
        tictactoeBoardDiagonals.updateBoard(0, 0, player1.getPlayerSymbol());
        tictactoeBoardDiagonals.updateBoard(1, 1, player1.getPlayerSymbol());
        tictactoeBoardDiagonals.updateBoard(2, 2, player1.getPlayerSymbol());

        assertEquals(expectedResult, tictactoeLogic.winCheckRows(tictactoeBoardRows, gameSizeSmall, playerQueue, player1.getPlayerID()));
        assertEquals(expectedResult, tictactoeLogic.winCheckColumns(tictactoeBoardColumns, gameSizeSmall, playerQueue, player1.getPlayerID()));
        assertEquals(expectedResult, tictactoeLogic.winCheckDiagonals(tictactoeBoardDiagonals, gameSizeSmall, playerQueue, player1.getPlayerID()));
    }

    @Test
    @DisplayName("Win check for Player1 test with big board")
    void winCheckTestBigBoardPlayer1() {
        TictactoeBoard tictactoeBoardRows = new TictactoeBoard();
        TictactoeBoard tictactoeBoardColumns = new TictactoeBoard();
        TictactoeBoard tictactoeBoardDiagonals = new TictactoeBoard();
        TictactoeLogic tictactoeLogic = new TictactoeLogic();
        TictactoePlayerQueue playerQueue = new TictactoePlayerQueue();

        String player1Type = "|X|";
        int gameSizeBig = 2;

        TictactoePlayer player1 = new TictactoePlayer(0, "Player1", player1Type, 0, 1);
        playerQueue.addPlayer(player1);

        boolean expectedResult = true;

        //Setting bigger board
        tictactoeBoardRows.setSize(10);
        tictactoeBoardColumns.setSize(10);
        tictactoeBoardDiagonals.setSize(10);

        tictactoeBoardRows.initializeBoard();
        tictactoeBoardColumns.initializeBoard();
        tictactoeBoardDiagonals.initializeBoard();

        //Board with a row win
        tictactoeBoardRows.updateBoard(0, 0,  player1.getPlayerSymbol());
        tictactoeBoardRows.updateBoard(0, 1,  player1.getPlayerSymbol());
        tictactoeBoardRows.updateBoard(0, 2,  player1.getPlayerSymbol());
        tictactoeBoardRows.updateBoard(0, 3,  player1.getPlayerSymbol());
        tictactoeBoardRows.updateBoard(0, 4,  player1.getPlayerSymbol());

        //Board with a column win
        tictactoeBoardColumns.updateBoard(0, 0, player1.getPlayerSymbol());
        tictactoeBoardColumns.updateBoard(1, 0, player1.getPlayerSymbol());
        tictactoeBoardColumns.updateBoard(2, 0, player1.getPlayerSymbol());
        tictactoeBoardColumns.updateBoard(3, 0, player1.getPlayerSymbol());
        tictactoeBoardColumns.updateBoard(4, 0, player1.getPlayerSymbol());


        //Board with a diagonal win
        tictactoeBoardDiagonals.updateBoard(0, 0, player1.getPlayerSymbol());
        tictactoeBoardDiagonals.updateBoard(1, 1, player1.getPlayerSymbol());
        tictactoeBoardDiagonals.updateBoard(2, 2, player1.getPlayerSymbol());
        tictactoeBoardDiagonals.updateBoard(3, 3, player1.getPlayerSymbol());
        tictactoeBoardDiagonals.updateBoard(4, 4, player1.getPlayerSymbol());


        assertEquals(expectedResult, tictactoeLogic.winCheckRows(tictactoeBoardRows, gameSizeBig, playerQueue, player1.getPlayerID()));
        assertEquals(expectedResult, tictactoeLogic.winCheckColumns(tictactoeBoardColumns, gameSizeBig, playerQueue, player1.getPlayerID()));
        assertEquals(expectedResult, tictactoeLogic.winCheckDiagonals(tictactoeBoardDiagonals, gameSizeBig, playerQueue, player1.getPlayerID()));
    }

    @Test
    @DisplayName("Win check for Player2 test")
    void winCheckTestSmallBoardPlayer2() {
        TictactoeBoard tictactoeBoardRows = new TictactoeBoard();
        TictactoeBoard tictactoeBoardColumns = new TictactoeBoard();
        TictactoeBoard tictactoeBoardDiagonals = new TictactoeBoard();
        TictactoeLogic tictactoeLogic = new TictactoeLogic();
        TictactoePlayerQueue playerQueue = new TictactoePlayerQueue();

        String player2Type = "|O|";
        int gameSizeSmall = 1;

        TictactoePlayer player2 = new TictactoePlayer(1, "Player2", player2Type, 0, 1);
        playerQueue.addPlayer(player2);

        boolean expectedResult = true;

        tictactoeBoardRows.initializeBoard();
        tictactoeBoardColumns.initializeBoard();
        tictactoeBoardDiagonals.initializeBoard();

        //Board with a row win
        tictactoeBoardRows.updateBoard(0, 0,  player2.getPlayerSymbol());
        tictactoeBoardRows.updateBoard(0, 1,  player2.getPlayerSymbol());
        tictactoeBoardRows.updateBoard(0, 2,  player2.getPlayerSymbol());

        //Board with a column win
        tictactoeBoardColumns.updateBoard(0, 0, player2.getPlayerSymbol());
        tictactoeBoardColumns.updateBoard(1, 0, player2.getPlayerSymbol());
        tictactoeBoardColumns.updateBoard(2, 0, player2.getPlayerSymbol());

        //Board with a diagonal win
        tictactoeBoardDiagonals.updateBoard(0, 0, player2.getPlayerSymbol());
        tictactoeBoardDiagonals.updateBoard(1, 1, player2.getPlayerSymbol());
        tictactoeBoardDiagonals.updateBoard(2, 2, player2.getPlayerSymbol());

        assertEquals(expectedResult, tictactoeLogic.winCheckRows(tictactoeBoardRows, gameSizeSmall, playerQueue, player2.getPlayerID()));
        assertEquals(expectedResult, tictactoeLogic.winCheckColumns(tictactoeBoardColumns, gameSizeSmall, playerQueue, player2.getPlayerID()));
        assertEquals(expectedResult, tictactoeLogic.winCheckDiagonals(tictactoeBoardDiagonals, gameSizeSmall, playerQueue, player2.getPlayerID()));
    }

    @Test
    @DisplayName("Win check for Player1 test with big board")
    void winCheckTestBigBoardPlayer2() {
        TictactoeBoard tictactoeBoardRows = new TictactoeBoard();
        TictactoeBoard tictactoeBoardColumns = new TictactoeBoard();
        TictactoeBoard tictactoeBoardDiagonals = new TictactoeBoard();
        TictactoeLogic tictactoeLogic = new TictactoeLogic();
        TictactoePlayerQueue playerQueue = new TictactoePlayerQueue();

        String player2Type = "|O|";
        int gameSizeBig = 2;

        TictactoePlayer player1 = new TictactoePlayer(1, "Player2", player2Type, 0, 1);
        playerQueue.addPlayer(player1);

        boolean expectedResult = true;

        //Setting bigger board
        tictactoeBoardRows.setSize(10);
        tictactoeBoardColumns.setSize(10);
        tictactoeBoardDiagonals.setSize(10);

        tictactoeBoardRows.initializeBoard();
        tictactoeBoardColumns.initializeBoard();
        tictactoeBoardDiagonals.initializeBoard();

        //Board with a row win
        tictactoeBoardRows.updateBoard(0, 0,  player1.getPlayerSymbol());
        tictactoeBoardRows.updateBoard(0, 1,  player1.getPlayerSymbol());
        tictactoeBoardRows.updateBoard(0, 2,  player1.getPlayerSymbol());
        tictactoeBoardRows.updateBoard(0, 3,  player1.getPlayerSymbol());
        tictactoeBoardRows.updateBoard(0, 4,  player1.getPlayerSymbol());

        //Board with a column win
        tictactoeBoardColumns.updateBoard(0, 0, player1.getPlayerSymbol());
        tictactoeBoardColumns.updateBoard(1, 0, player1.getPlayerSymbol());
        tictactoeBoardColumns.updateBoard(2, 0, player1.getPlayerSymbol());
        tictactoeBoardColumns.updateBoard(3, 0, player1.getPlayerSymbol());
        tictactoeBoardColumns.updateBoard(4, 0, player1.getPlayerSymbol());


        //Board with a diagonal win
        tictactoeBoardDiagonals.updateBoard(0, 0, player1.getPlayerSymbol());
        tictactoeBoardDiagonals.updateBoard(1, 1, player1.getPlayerSymbol());
        tictactoeBoardDiagonals.updateBoard(2, 2, player1.getPlayerSymbol());
        tictactoeBoardDiagonals.updateBoard(3, 3, player1.getPlayerSymbol());
        tictactoeBoardDiagonals.updateBoard(4, 4, player1.getPlayerSymbol());


        assertEquals(expectedResult, tictactoeLogic.winCheckRows(tictactoeBoardRows, gameSizeBig, playerQueue, player1.getPlayerID()));
        assertEquals(expectedResult, tictactoeLogic.winCheckColumns(tictactoeBoardColumns, gameSizeBig, playerQueue, player1.getPlayerID()));
        assertEquals(expectedResult, tictactoeLogic.winCheckDiagonals(tictactoeBoardDiagonals, gameSizeBig, playerQueue, player1.getPlayerID()));
    }

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
