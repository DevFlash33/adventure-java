package de.flash.game.item.weapon;

import de.flash.game.Status;

public class Fist extends Weapon {
    public Fist(float damage, float penetration, Status status) {
        super("Fist", 0f, 0f, damage, penetration , false, status);
    }
}
