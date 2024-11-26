package domain.simulations;

import domain.board.BoardDay;
import domain.entities.*;

import java.awt.*;

public class ZombieMovementSimulation {
    public static void main(String[] args) {
        // Crear un tablero de día
        BoardDay board = new BoardDay(200);

        // Añadir un BasicZombie al tablero
        Zombie zombie = new BasicZombie();
        zombie.setPosition(4, 2); // Inicialmente en la columna 4, fila 2
        board.addZombie(zombie, zombie.getPosition());

        // Añadir una planta en su camino
        Plant plant = new Peashooter(board);
        plant.setPosition(2, 2); // Columna 2, fila 2
        board.addPlant(plant, plant.getPosition());

        // Simular movimiento del zombi
        System.out.println("Simulación de movimiento iniciada:");
        zombie.move(board);

        // Mostrar estado del tablero
        System.out.println("Zombis en el tablero:");
        for (Point pos : board.getZombies().keySet()) {
            System.out.println("- " + pos + ": " + board.getZombies().get(pos).getName());
        }
    }
}