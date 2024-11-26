package domain.simulations;

import domain.board.BoardDay;
import domain.entities.*;

import java.awt.*;
public class SunflowerActionSimulation {
    public static void main(String[] args) throws InterruptedException {
        // Crear el tablero
        BoardDay board = new BoardDay(200);

        // Añadir un girasol al tablero
        Sunflower sunflower = new Sunflower(board);
        Point sunflowerPosition = new Point(2, 3);
        sunflower.setPosition(sunflowerPosition);
        board.addPlant(sunflower, sunflowerPosition);

        // Simular 1 minuto
        System.out.println("Inicia la simulación del girasol y los recursos:");
        Thread.sleep(60000); // Esperar 60 segundos
        sunflower.stopAction(); // Detener el temporizador
        System.out.println("Soles totales al final: " + board.getSunPoints());
    }
}
