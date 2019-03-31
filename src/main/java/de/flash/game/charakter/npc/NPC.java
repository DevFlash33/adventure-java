package de.flash.game.charakter.npc;

import de.flash.game.charakter.Character;
import de.flash.game.item.weapon.Weapon;

public abstract class NPC extends Character {

    public NPC(final String name, final float hp, final float mp, final float mr, final float armor, final Weapon weapon, final int money) {
        super(name, hp, mp, mr, armor, weapon, money);
    }
}
