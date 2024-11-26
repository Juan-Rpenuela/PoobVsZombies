package domain.simulations;

import domain.board.BoardDay;
import domain.entities.*;

import java.awt.*;

public class OffensivePlantSimulation {
    public static void main(String[] args) throws InterruptedException {
        // Crear tablero
        BoardDay board = new BoardDay(200);

        // Añadir un Peashooter
        Peashooter peashooter = new Peashooter(board);
        Point peashooterPosition = new Point(2, 2);
        peashooter.setPosition(peashooterPosition);
        board.addPlant(peashooter, peashooterPosition);

        // Añadir zombis
        Zombie zombie1 = new BasicZombie();
        Zombie zombie2 = new BasicZombie();

        zombie1.setPosition(new Point(4, 2)); // En la misma fila
        zombie2.setPosition(new Point(6, 2));

        board.addZombie(zombie1, zombie1.getPosition());
        board.addZombie(zombie2, zombie2.getPosition());
        board.printBoardState();

        // Iniciar ataque automático del Peashooter
        peashooter.startAttacking(board);

        // Simular 10 segundos de juego
        System.out.println("Simulación iniciada:");
        Thread.sleep(20000); // Esperar 10 segundos
        peashooter.stopAttacking();
        board.printBoardState();

        System.out.println("Simulación terminada.");
    }


}