package com.kodilla.input;

import com.kodilla.graphics.TictactoeBoard;
import com.kodilla.logic.TictactoeGameLoop;
import com.kodilla.logic.TictactoeLogic;
import com.kodilla.logic.TictactoePlayer;
import com.kodilla.logic.TictactoePlayerQueue;

import java.util.Scanner;

public class TictactoeInput {
    private TictactoeLogic logic = new TictactoeLogic();
    private Scanner scanner = new Scanner(System.in);
    private int gameSize = 0;
    private int x;
    private int y;
    private int playerIdCounter = 0;

    public int getGameSize() {
        return gameSize;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPlayerIdCounter() {
        return playerIdCounter;
    }
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    //Player input for creating player objects with names
    public void playersInitialization(TictactoeGameLoop gameLoop, TictactoePlayerQueue playerQueue) {
        System.out.println("Please, provide name for Player 1: ");
        String playerName = scanner.next();
        TictactoePlayer player1 = new TictactoePlayer(playerIdCounter, playerName, gameLoop.getPlayer1Type(), gameLoop.getPlayer1Score(), gameLoop.getPlayer1Lives());
        playerQueue.addPlayer(player1);
        playerIdCounter++;

        if(gameLoop.getGameType() == 1) {
            System.out.println("Please, provide name for Player 2: ");
            playerName = scanner.next();
            TictactoePlayer player2 = new TictactoePlayer(playerIdCounter, playerName, gameLoop.getPlayer2Type(), gameLoop.getPlayer2Score(), gameLoop.getPlayer2Lives());
            playerQueue.addPlayer(player2);
            playerIdCounter++;
        } else {
            TictactoePlayer player2 = new TictactoePlayer(playerIdCounter, "AI", gameLoop.getPlayer2Type(), gameLoop.getPlayer2Score(), gameLoop.getPlayer2Lives());
            playerQueue.addPlayer(player2);
            playerIdCounter++;
        }
    }

    //Selection of a field on the board with an input validation
    public void selection(TictactoeBoard tictactoeBoard) {
        boolean validInput = false;
        while (!validInput) {
            if (scanner.hasNextInt()){
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
                if (x >= 0 && x < tictactoeBoard.getSize() && y >= 0 && y < tictactoeBoard.getSize()) {
                    validInput = true;
                } else
                    System.out.println("Invalid input! Please enter a number between 1 and " + tictactoeBoard.getSize());
            }
        }
    }

    //Selecting game size X by Y
    public int gameSizeSelection(TictactoeBoard tictactoeBoard) {
        boolean validInput = false;
        while (!validInput){
            if (scanner.hasNextInt()) {
                gameSize = scanner.nextInt();
                if (gameSize == 1) {
                    tictactoeBoard.setSize(3);
                    tictactoeBoard.initializeBoard();
                    validInput = true;
                }else if (gameSize == 2) {
                    tictactoeBoard.setSize(10);
                    tictactoeBoard.initializeBoard();
                    validInput = true;
                } else {
                    scanner.next();
                    System.out.println("Invalid input! Please enter a number 1 or 2");
                }
            }
        }
        return gameSize;
    }

    //Updating the board with player board coordinate input
    public void playerFieldChoice(TictactoeBoard tictactoeBoard, String type) {
        while (true) {
            System.out.println("Select a column and a row: ");
            selection(tictactoeBoard);

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
