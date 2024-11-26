package domain.simulations;

import domain.board.BoardDay;
import domain.entities.*;
import domain.tools.Shovel;

import java.awt.*;


public class LawnMowerSimulate {
        public static void main(String[] args) throws InterruptedException {
            // Crear un tablero de día
            BoardDay board = new BoardDay(200);

            System.out.println("Simulación de tiempo real iniciada:");

            // 1. Plantar Sunflowers y un Peashooter
            board.addPlant(new Sunflower(board), new Point(0, 0));
            board.addPlant(new Peashooter(board), new Point(2, 0));

            // 2. Agregar zombis básicos
            Zombie zombie1 = new BasicZombie();
            zombie1.setPosition(new Point(8, 0));
            board.addZombie(zombie1, zombie1.getPosition());

            Zombie zombie2 = new BasicZombie();
            zombie2.setPosition(new Point(8, 1));
            board.addZombie(zombie2, zombie2.getPosition());

            // Iniciar temporizadores de zombis
            zombie1.startMoving(board);
            zombie2.startMoving(board);

            // Simulación en tiempo real
            long startTime = System.currentTimeMillis();
            while (true) {
                // Actualizar zombis
                board.updateZombies();

                // Imprimir estado del tablero cada 2 segundos
                if ((System.currentTimeMillis() - startTime) % 2000 == 0) {
                    board.printBoardState();
                }

                // Terminar simulación después de 20 segundos
                if (System.currentTimeMillis() - startTime > 20000) {
                    System.out.println("Simulación terminada.");
                    break;
                }

                // Pausar brevemente para simular tiempo real
                Thread.sleep(100);
            }


        }
    }

