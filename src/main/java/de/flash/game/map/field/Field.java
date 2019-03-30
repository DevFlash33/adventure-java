package de.flash.game.map.field;

import de.flash.game.charakter.enemies.Enemy;
import de.flash.game.charakter.npc.NPC;
import de.flash.game.dialog.DialogManager;
import de.flash.game.item.Item;
import de.flash.game.map.biom.Biom;

import java.util.ArrayList;

public abstract class Field {
    private final ArrayList<Enemy> enemies;
    private final ArrayList<Item> items;
    private final ArrayList<NPC> npcs;
    private final Biom biom;

    protected Field(ArrayList<Enemy> enemies, ArrayList<Item> items, ArrayList<NPC> npcs, Biom biom) {
        this.enemies = enemies;
        this.items = items;
        this.npcs = npcs;
        this.biom = biom;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public Enemy getEnemyByName(final String name) {
        Enemy targetEnemy = null;
        for (Enemy enemy : enemies) {
            if(enemy.getName().equalsIgnoreCase(name)) {
                targetEnemy = enemy;
               break;
            }
        }
        return targetEnemy;
    }

    public int getIndexOfEnemy(final Enemy searchEnemy) {
        return enemies.indexOf(searchEnemy);
    }

    public void updateEnemies(final Enemy enemy, final int index) {
        enemies.remove(index);
        if(enemy.getHp() <= 0) {
            DialogManager.PrintMessage(enemy.getName() + " was slain!");
        } else {
            DialogManager.PrintMessage(enemy.getName() + " has now " + Math.round(enemy.getHp()) + " hp");
            enemies.add(enemy);
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<NPC> getNpcs() {
        return npcs;
    }

    public Biom getBiom() {
        return biom;
    }
}
