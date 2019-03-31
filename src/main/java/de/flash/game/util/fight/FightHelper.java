package de.flash.game.util.fight;

public class FightHelper {
    public static float getDamage(final float damage, final float penetration, final boolean isMagic, final float mr, final float armor) {
        if (isMagic) {
            return (damage / (damage + (penetration * 100 - mr * 100)));
        } else {
            return (damage / (damage + (penetration * 100 - armor * 100)));
        }
    }
}
