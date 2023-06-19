package com.kodilla;

import com.kodilla.Graphics.Board;
import com.kodilla.Input.TictactoeInput;
import com.kodilla.Logic.TictactoeLogic;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KodillaTictactoeGameApplication {

    public static void main(String[] args) {
//        SpringApplication.run(KodillaTictactoeGameApplication.class, args);
        //Initializing the game and players
        Board board = new Board();
        TictactoeLogic logic = new TictactoeLogic();
        char player1Type = 'X';
        char player2Type = 'O';
        TictactoeInput tictactoeInput = new TictactoeInput();
        board.initializeBoard();
        //Game loop with checking if any player won the game

        while (true) {
            System.out.println("Player 1 turn");
            tictactoeInput.playerFieldChoice(board, player1Type);
            if (logic.winCheckPlayer1(board.getBoard())) {
                break;
            }

            System.out.println("Player 2 turn");
            tictactoeInput.playerFieldChoice(board, player2Type);
            if (logic.winCheckPlayer2(board.getBoard())) {
                break;
            }
        }
    }

}
