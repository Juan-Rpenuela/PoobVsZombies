package domain.simulations;

import domain.board.BoardDay;
import domain.entities.*;

import java.awt.*;

public class PotatoMineSimulation {
    public static void main(String[] args) throws InterruptedException {
        BoardDay board = new BoardDay(200);

        // Colocar PotatoMine
        PotatoMine potatoMine = new PotatoMine();
        Point minePosition = new Point(4, 2);
        potatoMine.setPosition(minePosition);
        board.addPlant(potatoMine, minePosition);

        // Colocar Zombie
        Zombie zombie = new BasicZombie();
        zombie.setPosition(new Point(4, 2)); // Misma posición
        board.addZombie(zombie, zombie.getPosition());

        // Iniciar la acción de PotatoMine
        potatoMine.startAction();

        // Simular 10 segundos
        System.out.println("Simulación iniciada. Esperando 10 segundos...");
        Thread.sleep(10000); // 10 segundos para que la mina se arme y explote
        if (zombie.getPosition().equals(minePosition)) {
            potatoMine.detonate(zombie, board);
        }

        System.out.println("Simulación terminada.");
    }

}
