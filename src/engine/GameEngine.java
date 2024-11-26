package engine;


import domain.board.Board;
import domain.board.BoardDay;
import presentation.GameWindow;

import javax.swing.*;

public class GameEngine implements Runnable {
    private final int FPS = 60;
    private final Board board;
    private final GameWindow gameWindow;
    private boolean running;

    public GameEngine(Board board, GameWindow gameWindow) {
        this.board = board;
        this.gameWindow = gameWindow;
        this.running = true;
    }

    public void start() {
        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double nsPerFrame = 1_000_000_000.0 / FPS;

        while (running) {
            long now = System.nanoTime();
            if (now - lastTime >= nsPerFrame) {
                updateGameState(); // Actualizar lógica del juego
                renderGraphics();  // Actualizar gráficos en la GUI
                lastTime = now;
            }
        }
    }

    private void updateGameState() {
        // Actualiza el estado del tablero
        board.updateZombies();
        if (board instanceof BoardDay) {
            ((BoardDay) board).generateSkySun(); // Generar soles del cielo manualmente
        }}// Si estás en modo día

    private void renderGraphics() {
        // Actualiza la GUI en el hilo de Swing
        SwingUtilities.invokeLater(() -> {
            gameWindow.updateBoard(board);
            gameWindow.updateSunCounter();
        });
    }

    public void stop() {
        running = false;
    }
}
