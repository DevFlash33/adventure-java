package de.flash.game.map.field;

import de.flash.game.charakter.enemies.Enemy;
import de.flash.game.charakter.npc.NPC;
import de.flash.game.item.Item;
import de.flash.game.map.biom.Forest;

import java.util.ArrayList;

public class ForestField extends Field {
    public ForestField(ArrayList<Enemy> enemies, ArrayList<Item> items, ArrayList<NPC> npcs, String titleForBiom) {
        super(enemies, items, npcs, new Forest(titleForBiom));
    }
}
