package domain.simulations;

import domain.board.BoardDay;
import domain.entities.*;
import domain.tools.Shovel;

import java.awt.*;


public class ShovelSimulation {
    public static void main(String[] args) {
        // Crear un tablero de día
        BoardDay board = new BoardDay(200);

        System.out.println("Simulación de la pala iniciada:");

        // 1. Plantar algunas plantas
        board.addPlant(new Peashooter(board), new Point(2, 0));
        board.addPlant(new Sunflower(board), new Point(3, 0));

        // Mostrar el estado inicial del tablero
        board.printBoardState();

        // 2. Usar la pala para eliminar una planta
        Shovel shovel = new Shovel();
        System.out.println("\nUsando la pala para eliminar la planta en (2, 0):");
        board.useTool(shovel, new Point(2, 0));

        // Mostrar el estado del tablero después de usar la pala
        board.printBoardState();

        // 3. Intentar usar la pala en una posición vacía
        System.out.println("\nUsando la pala en una posición vacía (4, 4):");
        board.useTool(shovel, new Point(4, 4));

        // Mostrar el estado del tablero al final
        board.printBoardState();
    }
}
