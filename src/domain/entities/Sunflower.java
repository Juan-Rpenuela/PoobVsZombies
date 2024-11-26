package domain.entities;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import domain.board.Board;

public class Sunflower extends SupportPlant {
    private Board board;
    public Sunflower(Board board) {
        super("Sunflower", 50, 300, "SupportPlant", 20000); // 20 segundos = 20000 ms
        this.board = board;
        this.startAction();
    }

    @Override
    public void action() {
        if (board != null) {
            board.addSun(25);
        System.out.println(this.getName() + " ha generado 25 soles.");
        }
    }
}
