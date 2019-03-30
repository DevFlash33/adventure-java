package de.flash.game.charakter.npc;

import de.flash.game.charakter.Character;
import de.flash.game.item.weapon.Weapon;

public abstract class NPC extends Character {

    public NPC(String name, float hp, float mp, float mr, float armor, Weapon weapon) {
        super(name, hp, mp, mr, armor, weapon);
    }
}
