package com.kodilla.logic;

import com.kodilla.graphics.TictactoeBoard;
import com.kodilla.input.TictactoeInput;

import java.util.Scanner;

public class TictactoeGameLoop {
    //Initializing the game and players
    TictactoeLogic logic = new TictactoeLogic();
    TictactoeInput tictactoeInput = new TictactoeInput();
    char player1Type = 'X';
    char player2Type = 'O';
    int gameType;
    int gameSize;
    Scanner scanner = new Scanner(System.in);
    int turnCount = 0;



    public void run(TictactoeBoard tictactoeBoard){
        System.out.printf("Type '1' to create 3x3 board, '2' to create 10x10 board: ");
        gameSize = tictactoeInput.gameSizeSelection(tictactoeBoard);

        //Game type input choice
        System.out.println("Type '1' to play against other player, '2' to play against AI: ");
        gameType = scanner.nextInt();

        if(gameType == 1){
            while (true) {//Game loop player1 vs. player2 with checking if any player won the game
                System.out.println("Turn " + (turnCount + 1));

                //Player 1 turn
                if (logic.player1Turn(tictactoeBoard, player1Type, gameSize)){
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
                if (logic.player1Turn(tictactoeBoard, player1Type, gameSize)){
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
