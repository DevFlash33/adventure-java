package de.flash.game.charakter.player;

import de.flash.game.Status;
import de.flash.game.charakter.Character;
import de.flash.game.charakter.Fightable;
import de.flash.game.charakter.player.movement.MovementManager;
import de.flash.game.dialog.DialogManager;
import de.flash.game.item.weapon.Fist;
import de.flash.game.item.weapon.Weapon;
import de.flash.game.map.Map;
import de.flash.game.util.fight.FightHelper;

public final class Player extends Character implements Fightable {

    private float maxHP;
    private int x;
    private int y;
    private int z;
    private final MovementManager movement = new MovementManager();
    private boolean isInCombat = false;
    private int lvl;
    private float lvlProgress;

    public Player(final String name, final int x, final int y, final int z) {
        super(name, 100, 0, 0, 0, generateStartWeapon(), 100);
        this.x = x;
        this.y = y;
        this.z = z;
        maxHP = 100;
        lvl = 1;
        lvlProgress = 0;
    }

    private static Weapon generateStartWeapon() {
        return new Fist(5, 0.1f, Status.NORMAL);
    }

    public void die() {
        setHp(0);
        DialogManager.printMessage("You shall not Pass and die...");
    }

    public void rest() {
        setHp(maxHP);
    }


    public void fight(final float damage, final float penetration, final boolean isMagic) {
        setHp(getHp() - FightHelper.getDamage(damage, penetration, isMagic, getMr(), getArmor()));
        if (getHp() <= 0) {
            die();
        }
    }

    public void moveForward(final Map map) {
        if (movement.canMoveNorth(x + 1, y, z, map)) {
            this.x += 1;
        }
    }


    public void moveBackward(final Map map) {
        if (movement.canMoveSouth(x - 1, y, z, map)) {
            this.x -= 1;
        }
    }


    public void moveRight(final Map map) {
        if (movement.canMoveEast(x, y + 1, z, map)) {
            this.y += 1;
        }
    }


    public void moveLeft(final Map map) {
        if (movement.canMoveWest(x + 1, y - 1, z, map)) {
            this.y -= 1;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public boolean isInCombat() {
        return isInCombat;
    }

    public void setInCombat(boolean inCombat) {
        isInCombat = inCombat;
    }

    public int getLvl() {
        return lvl;
    }

    public float getLvlProgress() {
        return lvlProgress;
    }

    public void setLvlProgress(float lvlProgress) {
        this.lvlProgress = lvlProgress;

    }

    public void addLvlProgress(float exp) {
        this.lvlProgress += exp;
        handleLvlUp();
    }

    private void handleLvlUp() {
        while (lvlProgress >= 1) {
            this.lvlProgress -= 1;
            this.lvl++;
            DialogManager.printMessage(getName() + " reached lvl " + lvl);
        }
    }
}
