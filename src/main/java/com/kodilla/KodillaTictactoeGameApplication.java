package com.kodilla;

import com.kodilla.graphics.TictactoeBoard;
import com.kodilla.logic.TictactoeGameLoop;
import com.kodilla.logic.TictactoePlayerQueue;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KodillaTictactoeGameApplication {

    public static void main(String[] args) {
//        SpringApplication.run(KodillaTictactoeGameApplication.class, args);
        TictactoeGameLoop tictactoeGameLoop = new TictactoeGameLoop();
        TictactoeBoard tictactoeBoard = new TictactoeBoard();
        TictactoePlayerQueue playerQueue = new TictactoePlayerQueue();
        tictactoeGameLoop.run(tictactoeBoard, playerQueue);
    }
}
