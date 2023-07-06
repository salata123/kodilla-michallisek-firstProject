package com.kodilla.logic;

import com.kodilla.graphics.TictactoeBoard;
import com.kodilla.input.TictactoeInput;

import java.util.Scanner;

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

    //Creating a new round
    public void startNewRound(TictactoeBoard tictactoeBoard) {
        System.out.println("Type '1' to create 3x3 board, '2' to create 10x10 board: ");
        gameSize = tictactoeInput.gameSizeSelection(tictactoeBoard);
    }

    //Game menu with game rules selection
    public void gameMenu(TictactoeBoard tictactoeBoard, TictactoePlayerQueue playerQueue) {
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

    //Game loop for PvP match
    public void playLoop(TictactoeBoard tictactoeBoard, TictactoePlayerQueue playerQueue) {//Game loop player1 vs. player2 with checking if any player won the game
        boolean continueGame = true;
        while(continueGame){
            System.out.println("Turn " + (turnCount + 1));
            for (int playerID = 0; playerID < playerQueue.getPlayerQueue().size(); playerID++) {
                if(logic.playerTurn(tictactoeBoard, gameSize, tictactoeInput, playerQueue, playerID, gameType)) {
                    turnCount++;
                } else {
                    continueGame = false;
                    break;
                }
                if (turnCount >= (tictactoeBoard.getSize() * tictactoeBoard.getSize())) {
                    tictactoeBoard.printBoard();
                    System.out.println("Draw");
                    continueGame = false;
                    break;
                }
            }
        }
    }

    public void run(TictactoeBoard tictactoeBoard, TictactoePlayerQueue playerQueue) {
        gameMenu(tictactoeBoard, playerQueue);

        while (playerQueue.checkPlayerLives()){
            playLoop(tictactoeBoard, playerQueue);
            if(playerQueue.checkPlayerLives()){
                turnCount = 0;
                startNewRound(tictactoeBoard);
            }
        }

        System.out.println("Game over");
        playerQueue.getAllPlayersScore();
    }
}
