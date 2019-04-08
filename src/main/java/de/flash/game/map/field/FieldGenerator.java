package de.flash.game.map.field;

import de.flash.game.Status;
import de.flash.game.charakter.enemies.Enemy;
import de.flash.game.charakter.enemies.Goblin;
import de.flash.game.charakter.enemies.Orc;
import de.flash.game.charakter.npc.NPC;
import de.flash.game.charakter.player.Player;
import de.flash.game.item.Item;
import de.flash.game.item.weapon.Axe;
import de.flash.game.item.weapon.Sword;

import java.util.ArrayList;
import java.util.Random;

public final class FieldGenerator {
    private Random random = new Random();

    public Field generateRandomField(final Player player) {
        final ArrayList<Enemy> enemies = new ArrayList<>();
        final ArrayList<Item> items = new ArrayList<>();
        final ArrayList<NPC> npcs = new ArrayList<>();
        final Status status = getStatusByPlayerLevel(player);
        for (int i = 0; i < getEnemyAmountByPlayerLevelAndStatus(player, status); i++) {
            enemies.add(getRandomEnemyBasedOnPlayerLevel(player, status));
        }
        if (random.nextInt(5) >= 3) {
            return new ForestField(enemies, items, npcs, "Dark Forest in the night");
        } else {
            return new ForestField(enemies, items, npcs, "Redwood Forest with a great sea");
        }
    }

    private int getEnemyAmountByPlayerLevelAndStatus(final Player player, final Status status) {
        int amount = Math.round(player.getLvl() * 2.75f * (getMultiplierByStatus(status) * 6.75f));
        if (amount >= 1) {
            return random.nextInt(amount);
        } else {
            return random.nextInt(1);
        }

    }

    private Enemy getRandomEnemyBasedOnPlayerLevel(final Player player, final Status statusForEnemy) {
        final int randomChoice = random.nextInt(player.getLvl());
        if (randomChoice >= 0 && randomChoice <= 10) {
            return new Goblin(getHpByStatus(100, statusForEnemy), getMrByStatus(0.01f, statusForEnemy), getArmorByStatus(0.01f, statusForEnemy),
                    getLootChanceByStatus(0.75f, statusForEnemy), statusForEnemy, getSwordByStatus("One-handed Sword", statusForEnemy), getMoneyByStatus(statusForEnemy, player), getExpByStatus(statusForEnemy));
        } else if (randomChoice >= 11 && randomChoice <= 25) {
            return new Orc(getHpByStatus(200, statusForEnemy), 0, getArmorByStatus(0.5f, statusForEnemy),
                    getLootChanceByStatus(1f, statusForEnemy), statusForEnemy, getAxeByStatus("Reaper", statusForEnemy), getMoneyByStatus(statusForEnemy, player), getExpByStatus(statusForEnemy));
        } else {
            return new Goblin(getHpByStatus(1000, statusForEnemy), getMrByStatus(0.1f, statusForEnemy), getArmorByStatus(0.1f, statusForEnemy),
                    getLootChanceByStatus(1f, statusForEnemy), statusForEnemy, getSwordByStatus("One-handed Sword", statusForEnemy), getMoneyByStatus(statusForEnemy, player), getExpByStatus(statusForEnemy));
        }

    }


    private float getHpByStatus(final float hp, final Status status) {
        return hp * getMultiplierByStatus(status);
    }

    private float getMrByStatus(final float mr, final Status status) {
        return mr * getMultiplierByStatus(status);
    }

    private float getArmorByStatus(final float armor, final Status status) {
        return armor * getMultiplierByStatus(status);
    }

    private float getLootChanceByStatus(final float lootChance, final Status status) {
        return lootChance * getMultiplierByStatus(status);
    }

    private float getAttributeByStatus(final float attribute, final Status status) {
        return attribute * getMultiplierByStatus(status);
    }


    private Sword getSwordByStatus(final String name, final Status status) {
        final boolean isMagical = getAttributeByStatus(1, status) >= 1;
        return new Sword(name, getAttributeByStatus(5, status), getAttributeByStatus(20, status), getAttributeByStatus(550, status), getAttributeByStatus(1, status), isMagical, status);
    }

    private Axe getAxeByStatus(final String name, final Status status) {
        return new Axe(name, getAttributeByStatus(16, status), getAttributeByStatus(200, status), getAttributeByStatus(1000, status), getAttributeByStatus(2, status), status);
    }



    private Status getStatusByPlayerLevel(final Player player) {
        final float rare = random.nextFloat() * (player.getLvl() * 1.75f);
        if (rare >= 0 && rare <= 9) {
            return Status.NORMAL;
        } else if (rare >= 10 && rare <= 24) {
            return Status.RARE;
        } else if (rare >= 25 && rare <= 49) {
            return Status.EPIC;
        } else if (rare >= 50) {
            return Status.LEGENDARY;
        } else {
            return Status.NORMAL;
        }
    }

    private float getMultiplierByStatus(final Status status) {
        switch (status) {
            case NORMAL:
                return random.nextFloat() * 0.15f;
            case RARE:
                return random.nextFloat() * 0.5f;
            case EPIC:
                return random.nextFloat() * 0.75f;
            case LEGENDARY:
                return random.nextFloat() * 1;
        }
        return random.nextFloat() * 0.15f;
    }

    private int getMoneyByStatus(final Status status, final Player player) {
        switch (status) {
            case NORMAL:
                return random.nextInt(5 * player.getLvl()) ;
            case RARE:
                return random.nextInt(15 * player.getLvl());
            case EPIC:
                return random.nextInt(30 * player.getLvl());
            case LEGENDARY:
                return random.nextInt(50 * player.getLvl());
        }
        return 0;
    }

    private float getExpByStatus(final Status status) {
        switch (status) {
            case NORMAL:
                return random.nextFloat() * 0.10f;
            case RARE:
                return random.nextFloat() * 0.18f;
            case EPIC:
                return random.nextFloat() * 0.25f;
            case LEGENDARY:
                return random.nextFloat() * 0.34f;
            default:
                return random.nextFloat() * 0.55f;
        }
    }
}
