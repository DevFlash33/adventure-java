package de.flash.game.system.loot;

import de.flash.game.item.Item;

import java.util.ArrayList;

public class LootManager {
    private ArrayList<Item> items;
    private int money;

    public LootManager() {
        items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void clearItems() {
        this.items.clear();
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
