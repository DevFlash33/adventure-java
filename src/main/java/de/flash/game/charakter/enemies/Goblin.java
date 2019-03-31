package de.flash.game.charakter.enemies;

import de.flash.game.Status;
import de.flash.game.dialog.DialogManager;
import de.flash.game.item.weapon.Weapon;

public class Goblin extends Enemy {

    public Goblin(final float hp, final float mr, final float armor, final float lootChance, final Status status, final Weapon weapon, final int money, final float exp) {
        super("Goblin", hp, 0, mr, armor, lootChance, status, weapon, money, exp);
    }

    @Override
    public void die() {
        DialogManager.printMessage(getName() + " died and say: \"We are many. We do not forgive. We do not forget. Expect us!\" ");
    }
}
