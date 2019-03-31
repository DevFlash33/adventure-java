package de.flash.game.charakter.enemies;

import de.flash.game.Status;
import de.flash.game.dialog.DialogManager;
import de.flash.game.item.weapon.Axe;
import de.flash.game.item.weapon.Weapon;

public class Orc extends Enemy {

    public Orc(final Status status, final int money, final float exp) {
        super("Orc", 100, 0, 0.2f, 0.5f, 0.5f, status, generateWeapon(status), money, exp);
    }

    private static Weapon generateWeapon(Status status){
        return new Axe("The total madness Axe", 20, 150, 10, 1, status);
    }

    public void die() {
        DialogManager.PrintMessage(getName() + " died with a loud grrrrrrraaaaaaaaa!");
    }
}
