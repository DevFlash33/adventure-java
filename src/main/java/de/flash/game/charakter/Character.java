package de.flash.game.charakter;

import de.flash.game.item.weapon.Weapon;

public abstract class Character {
        private String name;
        private float hp;
        private float mp;
        private float mr;
        private float armor;
        private Weapon weapon;

        protected Character(String name, float hp, float mp, float mr, float armor, Weapon weapon) {
            this.name = name;
            this.hp = hp;
            this.mp = mp;
            this.mr = mr;
            this.armor = armor;
            this.weapon = weapon;
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
}
