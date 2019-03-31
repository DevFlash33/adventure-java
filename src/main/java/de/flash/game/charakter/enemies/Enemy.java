package de.flash.game.charakter.enemies;

import de.flash.game.Status;
import de.flash.game.charakter.Character;
import de.flash.game.charakter.Fightable;
import de.flash.game.item.weapon.Weapon;
import de.flash.game.util.fight.FightHelper;

public abstract class Enemy extends Character implements Fightable {
    private final float lootChance;
    private Status status;
    private final float exp;

    protected Enemy(final String name, final float hp, final float mp, final float mr, final float armor, final float lootChance, final Status status, final Weapon weapon, final int money, final float exp) {
        super(name, hp, mp, mr, armor, weapon, money);
        this.lootChance = lootChance;
        this.status = status;
        this.exp = exp;
    }

    public float getLootChance() {
        return lootChance;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void fight(final float damage, final float penetration, final boolean isMagic) {
        setHp(getHp() - FightHelper.getDamage(damage, penetration, isMagic, getMr(), getArmor()));
        if(getHp() <= 0) {
            die();
        }
    }

    public float getExp() {
        return exp;
    }
}
