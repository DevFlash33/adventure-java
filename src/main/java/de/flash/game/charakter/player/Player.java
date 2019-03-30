package de.flash.game.charakter.player;

import de.flash.game.Status;
import de.flash.game.charakter.Character;
import de.flash.game.charakter.Fightable;
import de.flash.game.dialog.DialogManager;
import de.flash.game.item.weapon.Fist;
import de.flash.game.item.weapon.Weapon;

public final class Player extends Character implements Fightable {

    private float maxHP;

    public Player(String name) {
        super(name, 100, 0, 0, 0, generateStartWeapon());
        maxHP = 100;
    }

    private static Weapon generateStartWeapon() {
        return new Fist(10, 0.1f, Status.NORMAL);
    }

    public void die() {
        DialogManager.PrintMessage("You shall not Pass and die...");
    }

    public void rest() {
        setHp(maxHP);
    }


    public void fight(float damage, float penetration, boolean isMagic) {
        if(isMagic) {
            setHp(getHp() - (damage * (getMr() - penetration) ) );
        } else {
            setHp(getHp() - (damage * (getArmor() - penetration) ) );
        }
        if(getHp() >= 0) {
            die();
        }
    }
}
