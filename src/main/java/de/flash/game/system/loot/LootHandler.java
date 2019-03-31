package de.flash.game.system.loot;

import de.flash.game.Status;
import de.flash.game.charakter.enemies.Enemy;
import de.flash.game.dialog.DialogManager;
import de.flash.game.item.Item;
import de.flash.game.item.weapon.Axe;

import java.util.ArrayList;
import java.util.Random;

public class LootHandler {
    private ArrayList<Item> items;
    private float money;
    private final Random random = new Random();

    public LootHandler() {
        items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void handleLoot(final Enemy enemy) {
        if (enemy.getHp() <= 0) {
            money += enemy.getMoney();
            DialogManager.printMessage(enemy.getName() + " dropped " + enemy.getMoney() + " money");
            lookForDroppedItems(enemy);
        }
    }

    private void lookForDroppedItems(final Enemy enemy) {
        final float lootChance = enemy.getLootChance() * (random.nextFloat() * 0.01f) * (enemy.getStatus() == Status.LEGENDARY ? 0.5f : 0.001f);
        if (lootChance >= 0.55) {
            addItem(new Axe("random", 5, 20, 20, 0, Status.NORMAL));
        }
    }

    public void setItems(final ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(final Item item) {
        this.items.add(item);
    }

    public void clearItems() {
        this.items.clear();
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(final float money) {
        this.money = money;
    }
}
