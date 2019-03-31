package de.flash.game.map.field;

import de.flash.game.Status;
import de.flash.game.charakter.enemies.Enemy;
import de.flash.game.charakter.enemies.Orc;
import de.flash.game.charakter.npc.NPC;
import de.flash.game.charakter.player.Player;
import de.flash.game.item.Item;

import java.util.ArrayList;
import java.util.Random;

public final class FieldGenerator {
    private Random random = new Random();

    public Field generateRandomField(final Player player) {
        final ArrayList<Enemy> enemies = new ArrayList<>();
        final ArrayList<Item> items = new ArrayList<>();
        final ArrayList<NPC> npcs = new ArrayList<>();
        if (random.nextInt(5) >= 2) {
            final Status status = getStatusByPlayerLevel(player);
            enemies.add(new Orc(status, getMoneyByStatus(status), getExpByStatus(status)));
            return new ForestField(enemies, items, npcs, "Dark Forest in the night");
        } else {
            return new ForestField(enemies, items, npcs, "Redwood Forest with a great sea");
        }
    }

    private Status getStatusByPlayerLevel(final Player player) {
        final int rare = random.nextInt(player.getLvl() * 5);
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

    private int getMoneyByStatus(final Status status) {
        switch (status) {
            case NORMAL:
                return random.nextInt(20);
            case RARE:
                return random.nextInt(50);
            case EPIC:
                return random.nextInt(100);
            case LEGENDARY:
                return random.nextInt(200);
        }
        return 0;
    }

    private float getExpByStatus(final Status status) {
        switch (status) {
            case NORMAL:
                return random.nextFloat() * 0.015f;
            case RARE:
                return random.nextFloat() * 0.028f;
            case EPIC:
                return random.nextFloat() * 0.059f;
            case LEGENDARY:
                return random.nextFloat() * 0.25f;
            default:
                return random.nextFloat() * 0.01f;
        }
    }
}
