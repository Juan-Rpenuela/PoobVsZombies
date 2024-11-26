package domain.entities;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class SupportPlant extends Plant {
    private Timer timer;
    protected int actionSpeed; // Tiempo en milisegundos para realizar su acción

    public SupportPlant(String name, int cost, int life, String type, int actionSpeed) {
        super(name, cost, life, type);
        this.actionSpeed = actionSpeed;
    }

    public void startAction() {
        if (actionSpeed > 0) {
            timer = new Timer(actionSpeed, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    action();
                }
            });
            timer.start();
        }
    }

    public abstract void action(); // Definido por subclases para realizar su acción específica

    public void stopAction() {
        if (timer != null) {
            timer.stop();
        }
    }
}
