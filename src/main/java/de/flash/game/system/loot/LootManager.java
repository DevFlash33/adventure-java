package de.flash.game.system.loot;

import de.flash.game.item.Item;

import java.util.ArrayList;

public class LootManager {
    private ArrayList<Item> items;

    public LootManager() {
        items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
