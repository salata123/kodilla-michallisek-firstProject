package com.kodilla.logic;

import com.kodilla.graphics.TictactoeBoard;
import com.kodilla.input.TictactoeInput;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TictactoeGameLoop {
    //Initializing the game and players
    private TictactoeLogic logic = new TictactoeLogic();
    private TictactoeInput tictactoeInput = new TictactoeInput();
    private String player1Type = "|X|";
    private String player2Type = "|O|";
    private int gameType;
    private int gameSize;
    private Scanner scanner = new Scanner(System.in);
    private int turnCount = 0;
    private int player1Score = 0;
    private int player2Score = 0;
    private int player1Lives = 0;
    private int player2Lives = 0;

    public int getPlayer1Lives() {
        return player1Lives;
    }

    public int getPlayer2Lives() {
        return player2Lives;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }
    public String getPlayer1Type() {
        return player1Type;
    }

    public String getPlayer2Type() {
        return player2Type;
    }

    public int getGameType() {
        return gameType;
    }

    public int getGameSize() {
        return gameSize;
    }

    public void startNewRound(TictactoeBoard tictactoeBoard){
        System.out.println("Type '1' to create 3x3 board, '2' to create 10x10 board: ");
        gameSize = tictactoeInput.gameSizeSelection(tictactoeBoard);
    }

    public void gameMenu(TictactoeBoard tictactoeBoard, TictactoePlayerQueue playerQueue){
        System.out.println("Type '1' to create 3x3 board, '2' to create 10x10 board: ");
        gameSize = tictactoeInput.gameSizeSelection(tictactoeBoard);

        //Game type input choice
        System.out.println("Type '1' to play against other player, '2' to play against AI: ");
        gameType = scanner.nextInt();

        System.out.println("Choose how many lives each player gets");
        player1Lives = scanner.nextInt();
        player2Lives = player1Lives;

        tictactoeInput.playersInitialization(this, playerQueue);
    }

    public void playerVsPlayerLoop(TictactoeBoard tictactoeBoard, TictactoePlayerQueue playerQueue){
        while (true) {//Game loop player1 vs. player2 with checking if any player won the game
            System.out.println("Turn " + (turnCount + 1));

            //Player 1 turn
            if (logic.playerTurn(tictactoeBoard, gameSize, tictactoeInput, playerQueue)){
                turnCount++;
                if (turnCount >= (tictactoeBoard.getSizeX() * tictactoeBoard.getSizeY())) {
                    tictactoeBoard.printBoard();
                    System.out.println("Draw");
                    break;
                }
            } else {
                break;
            }
        }
    }

    public void playerVsAiLoop(TictactoeBoard tictactoeBoard, TictactoePlayerQueue playerQueue){
        while (true) {
            System.out.println("Turn " + (turnCount + 1));

            //Player 1 turn
            if (logic.playerTurn(tictactoeBoard, gameSize, tictactoeInput, playerQueue)){
                turnCount++;
                if (turnCount >= (tictactoeBoard.getSizeX() * tictactoeBoard.getSizeY())) {
                    tictactoeBoard.printBoard();
                    System.out.println("Draw");
                    break;
                }
            } else {
                break;
            }
            System.out.println("Turn " + (turnCount + 1));

            //AI turn
            if (logic.aiTurn(tictactoeBoard, gameSize, playerQueue)){
                turnCount++;
                if (turnCount >= (tictactoeBoard.getSizeX() * tictactoeBoard.getSizeY())) {
                    tictactoeBoard.printBoard();
                    System.out.println("Draw");
                    break;
                }
            } else {
                break;
            }
        }
    }

    public void run(TictactoeBoard tictactoeBoard, TictactoePlayerQueue playerQueue){
        gameMenu(tictactoeBoard, playerQueue);

        while (playerQueue.checkPlayerLives()){
            if(gameType == 1){
                playerVsPlayerLoop(tictactoeBoard, playerQueue);
            } else {
                playerVsAiLoop(tictactoeBoard, playerQueue);
            }
            turnCount = 0;
            startNewRound(tictactoeBoard);
        }
    }
}
