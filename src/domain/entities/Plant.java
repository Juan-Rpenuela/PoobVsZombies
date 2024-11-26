package domain.entities;

import java.awt.*;

public abstract class Plant extends Entity{
    int life;
    String type;

    public Plant(String name,int cost, int life, String type) {
        super(name, cost);
        this.life = life;
        this.type = type;
    }

    public int getLife(){return this.life;};
    public String getType(){return this.type;};
    public void receiveDamage(int damage) {
        this.life -= damage;
        if (this.life < 0) {
            this.life = 0; // Evitar valores negativos
        }
        System.out.println(this.getName() + " recibió " + damage + " de daño. Vida restante: " + this.life);
    }

    public boolean isAlive() {
        return this.life > 0;
    }

}