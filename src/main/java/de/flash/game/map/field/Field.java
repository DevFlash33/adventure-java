package de.flash.game.map.field;

import de.flash.game.charakter.enemies.Enemie;
import de.flash.game.charakter.npc.NPC;
import de.flash.game.item.Item;
import de.flash.game.map.biom.Biom;

import java.util.ArrayList;

public abstract class Field {
    private ArrayList<Enemie> enemies;
    private ArrayList<Item> items;
    private ArrayList<NPC> npcs;
    private Biom biom;

    protected Field(ArrayList<Enemie> enemies, ArrayList<Item> items, ArrayList<NPC> npcs, Biom biom) {
        this.enemies = enemies;
        this.items = items;
        this.npcs = npcs;
        this.biom = biom;
    }
}
