package domain.entities;

import javax.swing.*;
import java.awt.*;

public class Entity {
    private  String name;
    private final int cost;
    private Point position;

    public Entity(String name, int cost) {
        this.name = name;
        this.position = new Point(0,0)  ;//Poner por defecto este se cambiara cuando se de click en la planta para ubicarla en la celda correspondiente
        this.cost = cost;
    }


    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position.setLocation(x, y);
    }

    public void setPosition(Point position) {
        this.position = position;

    }
    public void setName(String name) {
        this.name = name;
    }
}