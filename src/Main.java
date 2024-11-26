import controllers.BoardController;
import domain.board.Board;
import engine.GameEngine;
import presentation.*;
import domain.board.BoardDay;
import domain.entities.*;

import java.awt.*;


public class Main {
    public static void main(String[] args) {
        BoardDay board = new BoardDay( 150);
        GameWindow gameWindow = new GameWindow(5, 9);
        BoardController controller = new BoardController(board, gameWindow);

        GameEngine gameEngine = new GameEngine(board, gameWindow);
        gameEngine.start();

        // Agregar plantas y zombis de prueba
        board.addPlant(new Sunflower(board), new Point(0, 0));
        board.addPlant(new Peashooter(board), new Point(2, 0));
        board.addZombie(new BasicZombie(), new Point(8, 0));
        board.addZombie(new BasicZombie(), new Point(6, 0));

        // Iniciar simulación
        controller.startSimulation();
    }

}

