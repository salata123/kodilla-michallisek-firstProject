package com.kodilla.input;

import com.kodilla.graphics.TictactoeBoard;
import com.kodilla.logic.TictactoeGameLoop;
import com.kodilla.logic.TictactoePlayerQueue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TictactoeInputTestSuite {

    @Test
    @DisplayName("Player initialization test")
    public void testPlayersInitialization() {
        TictactoeGameLoop gameLoop = new TictactoeGameLoop();
        TictactoePlayerQueue playerQueue = new TictactoePlayerQueue();
        TictactoeInput tictactoeInput = new TictactoeInput();

        //Setting input for test
        Scanner scanner = mock(Scanner.class);
        when(scanner.next()).thenReturn("Player1");

        tictactoeInput.setScanner(scanner);
        tictactoeInput.playersInitialization(gameLoop, playerQueue);

        int expectedPlayer1ID = 0;
        int expectedPlayer2ID = 1;
        String expectedPlayer1Name = "Player1";
        String expectedPlayer2Name = "AI";
        String expectedPlayer1Symbol = "|X|";
        String expectedPlayer2Symbol = "|O|";
        int expectedPlayer1Score = 0;
        int expectedPlayer2Score = 0;
        int expectedPlayer1Lives = 0;
        int expectedPlayer2Lives = 0;

        assertEquals(2, tictactoeInput.getPlayerIdCounter());

        //Player1 tests
        assertEquals(expectedPlayer1ID, playerQueue.getCurrentPlayer(0).getPlayerID());
        assertEquals(expectedPlayer1Name, playerQueue.getCurrentPlayer(0).getPlayerName());
        assertEquals(expectedPlayer1Symbol, playerQueue.getCurrentPlayer(0).getPlayerSymbol());
        assertEquals(expectedPlayer1Score, playerQueue.getCurrentPlayer(0).getPlayerScore());
        assertEquals(expectedPlayer1Lives, playerQueue.getCurrentPlayer(0).getPlayerLives());

        //Player2 tests
        assertEquals(expectedPlayer2ID, playerQueue.getCurrentPlayer(1).getPlayerID());
        assertEquals(expectedPlayer2Name, playerQueue.getCurrentPlayer(1).getPlayerName());
        assertEquals(expectedPlayer2Symbol, playerQueue.getCurrentPlayer(1).getPlayerSymbol());
        assertEquals(expectedPlayer2Score, playerQueue.getCurrentPlayer(1).getPlayerScore());
        assertEquals(expectedPlayer2Lives, playerQueue.getCurrentPlayer(1).getPlayerLives());

    }

    @Test
    @DisplayName("Player field choice selection test")
    void playerFieldChoiceTest() {
        TictactoeBoard tictactoeBoard = new TictactoeBoard();
        TictactoeInput tictactoeInput = new TictactoeInput();

        tictactoeBoard.initializeBoard();
        String playerType = "|X|";
        String player2Type = "|O|";

        Scanner scanner = mock(Scanner.class);
        when(scanner.hasNextInt()).thenReturn(true);
        when(scanner.nextInt()).thenReturn(1, 1);

        tictactoeInput.setScanner(scanner);
        tictactoeInput.playerFieldChoice(tictactoeBoard, playerType);

        when(scanner.hasNextInt()).thenReturn(true);
        when(scanner.nextInt()).thenReturn(2, 2);

        tictactoeInput.setScanner(scanner);
        tictactoeInput.playerFieldChoice(tictactoeBoard, player2Type);

        String expectedResult = "|X|";
        String expectedResult2 = "|O|";

        assertEquals(expectedResult, tictactoeBoard.getBoard()[0][0]);
        assertEquals(expectedResult2, tictactoeBoard.getBoard()[1][1]);
    }

    @Test
    @DisplayName("Small game size selection test")
    void gameSizeSelectionSmallTest() {
        TictactoeBoard tictactoeBoard = new TictactoeBoard();
        TictactoeInput tictactoeInput = new TictactoeInput();

        //Setting input for test
        Scanner scanner = mock(Scanner.class);
        when(scanner.hasNextInt()).thenReturn(true);
        when(scanner.nextInt()).thenReturn(1);

        tictactoeInput.setScanner(scanner);
        tictactoeInput.gameSizeSelection(tictactoeBoard);

        int expectedResult = 3;

        assertEquals(expectedResult, tictactoeBoard.getSize());
    }

    @Test
    @DisplayName("Big game size selection test")
    void gameSizeSelectionBigTest() {
        TictactoeBoard tictactoeBoard = new TictactoeBoard();
        TictactoeInput tictactoeInput = new TictactoeInput();

        //Setting input for test
        Scanner scanner = mock(Scanner.class);
        when(scanner.hasNextInt()).thenReturn(true);
        when(scanner.nextInt()).thenReturn(2);

        tictactoeInput.setScanner(scanner);
        tictactoeInput.gameSizeSelection(tictactoeBoard);

        int expectedResult = 10;

        assertEquals(expectedResult, tictactoeBoard.getSize());
    }
}
