package com.kodilla;

import com.kodilla.graphics.TictactoeBoard;
import com.kodilla.logic.TictactoeGameLoop;
import com.kodilla.logic.TictactoeLogic;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class KodillaTictactoeGameApplication {

    public static void main(String[] args) {
//        SpringApplication.run(KodillaTictactoeGameApplication.class, args);
        TictactoeGameLoop tictactoeGameLoop = new TictactoeGameLoop();
        TictactoeBoard tictactoeBoard = new TictactoeBoard();
        tictactoeGameLoop.run(tictactoeBoard);
    }
}
