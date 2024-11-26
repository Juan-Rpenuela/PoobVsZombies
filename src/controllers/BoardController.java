package controllers;

import domain.board.Board;
import presentation.GameWindow;

import javax.swing.*;

public class BoardController {
    private Board board;
    private GameWindow gameWindow;

    public BoardController(Board board, GameWindow gameWindow) {
        this.board = board;
        this.gameWindow = gameWindow;
    }

    public void startSimulation() {
        new Thread(() -> {
            while (true) {
                try {
                    // Actualizar el tablero del dominio
                    board.updateZombies();

                    // Actualizar la GUI
                    SwingUtilities.invokeLater(() -> gameWindow.updateBoard(board));

                    Thread.sleep(1000); // Simulación en tiempo real
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

