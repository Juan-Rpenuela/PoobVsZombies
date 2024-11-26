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

                    // Sincronizar la GUI con el tablero
                    SwingUtilities.invokeLater(() -> {
                        gameWindow.updateBoard(board); // Actualiza el tablero gráfico
                        gameWindow.updateSunCounter(); // Actualiza el contador de soles
                    });

                    Thread.sleep(1000); // Intervalo para tiempo real
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}

