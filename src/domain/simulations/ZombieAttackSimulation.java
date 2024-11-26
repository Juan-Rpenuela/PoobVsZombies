package domain.simulations;

import domain.board.BoardDay;
import domain.entities.*;

import java.awt.*;


public class ZombieAttackSimulation {
    public static void main(String[] args) throws InterruptedException {
        // Crear tablero
        BoardDay board = new BoardDay(200);

        // Añadir una planta
        Peashooter peashooter = new Peashooter(board);
        Point peashooterPosition = new Point(2, 0);
        peashooter.setPosition(peashooterPosition);
        board.addPlant(peashooter, peashooterPosition);

        // Añadir un zombi
        Zombie zombie = new BasicZombie(); // Usar clase concreta
        zombie.setPosition(new Point(5, 0)); // Misma fila
        board.addZombie(zombie, zombie.getPosition());

        // Iniciar movimiento del zombi
        zombie.startMoving(board);

        // Simular 30 segundos
        System.out.println("Simulación de movimiento y ataque de zombis iniciada:");
        for (int i = 0; i < 6; i++) { // Simular 6 turnos
            Thread.sleep(5000); // Esperar 5 segundos por turno
            board.printBoardState();
        }

        // Detener el movimiento al final
        zombie.stopMoving();

        System.out.println("Simulación de movimiento y ataque de zombis terminada.");
    }

}
