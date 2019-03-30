package de.flash.game.charakter.player;

import de.flash.game.Status;
import de.flash.game.charakter.Character;
import de.flash.game.charakter.Fightable;
import de.flash.game.charakter.player.movement.MovementManager;
import de.flash.game.dialog.DialogManager;
import de.flash.game.item.weapon.Fist;
import de.flash.game.item.weapon.Weapon;
import de.flash.game.map.Map;

public final class Player extends Character implements Fightable {

    private float maxHP;
    private int x;
    private int y;
    private int z;
    private MovementManager movement = new MovementManager();

    public Player(String name, int x, int y, int z) {
        super(name, 100, 0, 0, 0, generateStartWeapon());
        this.x = x;
        this.y = y;
        this.z = z;
        maxHP = 100;
    }

    private static Weapon generateStartWeapon() {
        return new Fist(10, 0.1f, Status.NORMAL);
    }

    public void die() {
        setHp(0);
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
        if(getHp() <= 0) {
            die();
        }
    }

    public void moveForward(Map map) {
        if(movement.canMoveNorth(x + 1, y, z, map)) {
          this.x += 1;
        }
    }


    public void moveBackward(Map map) {
        if(movement.canMoveSouth(x - 1, y, z, map)) {
            this.x -= 1;
        }
    }


    public void moveRight(Map map) {
        if(movement.canMoveEast(x, y + 1, z, map)) {
            this.y += 1;
        }
    }


    public void moveLeft(Map map) {
        if(movement.canMoveWest(x + 1, y - 1, z, map)) {
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
}
