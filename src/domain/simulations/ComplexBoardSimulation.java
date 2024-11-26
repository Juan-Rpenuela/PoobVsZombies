package domain.simulations;

import domain.board.BoardDay;
import domain.entities.*;

import java.awt.*;


public class ComplexBoardSimulation {
    public static void main(String[] args) throws InterruptedException {
        // Crear un tablero con dimensiones específicas y soles iniciales
        BoardDay board = new BoardDay(200);

        System.out.println("Simulación iniciada:");

        // Iniciar generación de soles del cielo
        board.startSkySunGeneration();

        // 1. Plantar Sunflowers para generar soles
        board.addPlant(new Sunflower(board), new Point(0, 0)); // Sunflower 1
        System.out.println("Sunflower 1 planted");
        board.addPlant(new Sunflower(board), new Point(0, 1)); // Sunflower 2
        System.out.println("Sunflower 2 planted");

        // 2. Plantar WallNut para bloquear zombis
        board.addPlant(new WallNut(), new Point(4, 0));
        board.addPlant(new WallNut(), new Point(4, 1));
        System.out.println("Wallnut planted");

        // 3. Agregar zombis básicos al tablero
        Zombie zombie1 = new BasicZombie(); // Zombi básico 1
        zombie1.setPosition(new Point(8, 0));
        board.addZombie(zombie1,zombie1.getPosition());

        Zombie zombie2 = new BasicZombie(); // Zombi básico 2
        zombie2.setPosition(new Point(8, 1));
        board.addZombie(zombie2,zombie2.getPosition());

        // 4. Iniciar temporizadores de zombis
        zombie1.startMoving(board);
        zombie2.startMoving(board);

        // 5. Simulación de turnos
        for (int turn = 1; turn <= 10; turn++) {
            System.out.println("\nTurno " + turn + ":");

            // Decidir plantar un Peashooter si hay suficientes soles
            if (board.getSunPoints() >= 100 && !board.getPlants().containsKey(new Point(2, 0))) {
                board.addPlant(new Peashooter(board), new Point(2, 0));
            }

            // Procesar acciones de las plantas ofensivas
            for (Plant plant : board.getPlants().values()) {
                if (plant instanceof OffensivePlant) {
                    ((OffensivePlant) plant).attack(board);
                }
            }

            // Imprimir estado del tablero
            board.printBoardState();

            // Esperar 2 segundos entre turnos (simulación en tiempo real)
            Thread.sleep(2000);
        }

        // Detener temporizadores
        zombie1.stopMoving();
        zombie2.stopMoving();
        board.stopSkySunGeneration();
        System.out.println("Simulación terminada.");
    }

}
