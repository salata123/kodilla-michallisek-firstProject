package com.kodilla.logic;

import com.kodilla.graphics.TictactoeBoard;

import java.util.Scanner;

public class TictactoeGameLoop {
    //Initializing the game and players
    TictactoeBoard tictactoeBoard = new TictactoeBoard();
    TictactoeLogic logic = new TictactoeLogic();
    char player1Type = 'X';
    char player2Type = 'O';
    int gameType;
    Scanner scanner = new Scanner(System.in);
    int turnCount = 0;
    
    public void run(){
        tictactoeBoard.initializeBoard();
        //Game type input choice
        System.out.println("Type '1' to play against other player, '2' to play against AI: ");
        gameType = scanner.nextInt();

        if(gameType == 1){
            while (true) {//Game loop player1 vs. player2 with checking if any player won the game
                System.out.println("Turn " + (turnCount + 1));

                //Player 1 turn
                if (logic.player1Turn(tictactoeBoard, player1Type)){
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

                //Player 2 turn
                if (logic.player2Turn(tictactoeBoard, player2Type)){
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
        } else {         //Game loop player vs. AI with checking if any player won the game
            while (true) {
                System.out.println("Turn " + (turnCount + 1));

                //Player 1 turn
                if (logic.player1Turn(tictactoeBoard, player1Type)){
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
                if (logic.aiTurn(tictactoeBoard, player2Type)){
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
    }
}
