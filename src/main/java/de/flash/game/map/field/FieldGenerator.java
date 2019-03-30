package de.flash.game.map.field;

import de.flash.game.charakter.enemies.Enemie;
import de.flash.game.charakter.enemies.Orc;
import de.flash.game.Status;
import de.flash.game.charakter.npc.NPC;
import de.flash.game.item.Item;

import java.util.ArrayList;
import java.util.Random;

public final class FieldGenerator {
    private Random random = new Random();
    public Field generateRandomField() {
        final ArrayList<Enemie> enemies = new ArrayList<>();
        final ArrayList<Item> items = new ArrayList<>();
        final ArrayList<NPC> npcs = new ArrayList<>();
        if(random.nextInt(5) >= 2 ) {
            enemies.add(new Orc(Status.NORMAL));
            return new ForestField(enemies, items, npcs, "Dark Forest in the night");
        } else {
            enemies.add(new Orc(Status.NORMAL));
            return new ForestField(enemies, items, npcs, "Dark Forest in the night");
        }
    }
}
