package de.flash.game.charakter.enemies;

import de.flash.game.Status;
import de.flash.game.charakter.Character;
import de.flash.game.charakter.Fightable;
import de.flash.game.item.weapon.Weapon;

public abstract class Enemie extends Character implements Fightable {
    private float lootChance;
    private Status status;

    protected Enemie(String name, float hp, float mp, float mr, float armor, float lootChance, Status status, Weapon weapon) {
        super(name, hp, mp, mr, armor, weapon);
        this.lootChance = lootChance;
        this.status = status;
    }

    public float getLootChance() {
        return lootChance;
    }

    public void setLootChance(float lootChance) {
        this.lootChance = lootChance;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void fight(float damage, float penetration, boolean isMagic) {

    }
}
