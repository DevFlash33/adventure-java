package de.flash.game.item.weapon;

import de.flash.game.Status;
import de.flash.game.item.Item;

public abstract class Weapon extends Item {
    private float damage;
    private float penetration;
    private Status status;

    protected Weapon(String name, float weight, float worth, float damage, float penetration, Status status) {
        super(name, weight, worth);
        this.damage = damage;
        this.penetration = penetration;
        this.status = status;
    }

    public float getPenetration() {
        return penetration;
    }

    public void setPenetration(float penetration) {
        this.penetration = penetration;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }
}
