package domain.entities;

import domain.board.Board;

import java.awt.*;

public class ECIPlant extends SupportPlant{
    private Board board;
    public ECIPlant(Board board) {
        super("ECIPlant",75,150,"SupportPlant",20000);
        this.board = board;
    }
    @Override
    public void action() {
        if (board != null) {
            board.addSun(50);
        System.out.println(this.getName() + " generó un sol.");
        // Aquí puedes agregar lógica para aumentar recursos o actualizar el tablero
        }
    }
}
