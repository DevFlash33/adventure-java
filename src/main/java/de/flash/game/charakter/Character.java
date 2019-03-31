package de.flash.game.charakter;

import de.flash.game.item.weapon.Weapon;

public abstract class Character {
    private String name;
    private float hp;
    private float mp;
    private float mr;
    private float armor;
    private Weapon weapon;
    private float money;

    protected Character(final String name, final float hp, final float mp, final float mr, final float armor, final Weapon weapon, final float money) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.mr = mr;
        this.armor = armor;
        this.weapon = weapon;
        this.money = money;
    }

    public abstract void die();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getMp() {
        return mp;
    }

    public void setMp(float mp) {
        this.mp = mp;
    }

    public float getMr() {
        return mr;
    }

    public void setMr(float mr) {
        this.mr = mr;
    }

    public float getArmor() {
        return armor;
    }

    public void setArmor(float armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }
}
