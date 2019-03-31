package de.flash.game.charakter.enemies;

import de.flash.game.Status;
import de.flash.game.dialog.DialogManager;
import de.flash.game.item.weapon.Weapon;

public class Orc extends Enemy {

    public Orc(final float hp, final float mr, final float armor, final float lootChance, final Status status, final Weapon weapon, final int money, final float exp) {
        super("Orc", hp, 0, mr, armor, lootChance, status, weapon, money, exp);
    }

    public void die() {
        DialogManager.printMessage(getName() + " died with a loud grrrrrrraaaaaaaaa!");
    }
}
