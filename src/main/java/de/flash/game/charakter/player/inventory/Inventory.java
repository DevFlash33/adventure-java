package de.flash.game.charakter.player.inventory;

import de.flash.game.item.Item;

import java.util.ArrayList;

public class Inventory {
    private final ArrayList<Item> items = new ArrayList<>();

    public Inventory() {

    }

    public void addItem(final Item item) {
        items.add(item);
    }
}
