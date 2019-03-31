package de.flash.game.charakter.enemies;

import de.flash.game.Status;
import de.flash.game.charakter.Character;
import de.flash.game.charakter.Fightable;
import de.flash.game.item.weapon.Weapon;

public abstract class Enemy extends Character implements Fightable {
    private float lootChance;
    private Status status;
    private float exp;

    protected Enemy(final String name, final float hp, final float mp, final float mr, final float armor, final float lootChance, final Status status, final Weapon weapon, final int money, final float exp) {
        super(name, hp, mp, mr, armor, weapon, money);
        this.lootChance = lootChance;
        this.status = status;
        this.exp = exp;
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

    public void fight(final float damage, final float penetration, final boolean isMagic) {
        if(isMagic) {
            setHp(getHp() - (damage * (getMr() - penetration) ) );
        } else {
            setHp(getHp() - (damage * (getArmor() - penetration) ) );
        }
        if(getHp() <= 0) {
            die();
        }
    }
}
