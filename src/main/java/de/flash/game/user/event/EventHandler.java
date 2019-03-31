package de.flash.game.user.event;

import de.flash.game.charakter.enemies.Enemy;
import de.flash.game.charakter.npc.NPC;
import de.flash.game.charakter.player.Player;
import de.flash.game.dialog.DialogManager;
import de.flash.game.item.Item;
import de.flash.game.map.field.Field;
import de.flash.game.system.loot.LootHandler;

import java.util.ArrayList;
import java.util.Random;

public final class EventHandler {
    private final ArrayList<Enemy> queuedFightEvent;
    private final Random random = new Random();
    private final LootHandler lootHandler = new LootHandler();

    public EventHandler() {
        queuedFightEvent = new ArrayList<>();
    }

    public void queueFightEvent(final Enemy enemy) {
        queuedFightEvent.add(enemy);
    }

    public void checkForEvents(final Field field, final Player player) {
        checkForEnemies(field, player);
        checkForFightEvents(player);
        queueFightEvents(field, player);
        checkForDroppedLoot(field, player);
    }

    private void checkForDroppedLoot(final Field field, final Player player) {
        if (lootHandler.getMoney() > 0) {
            DialogManager.printMessage("You can pickup " + lootHandler.getMoney() + " money");
        }
        if (lootHandler.getItems().size() > 0) {
            DialogManager.printMessage("On the ground laying following Items: ");
            lootHandler.getItems().forEach(res -> DialogManager.printMessage("-> " + res.getName()));
        }
    }

    private void queueFightEvents(final Field field, final Player player) {
        if (player.isInCombat()) {
            final int attacker = random.nextInt(field.getEnemies().size() + 1);
            for (int i = 0; i < attacker; i++) {
                queueFightEvent(field.getEnemies().get(i));
            }
        }
    }

    private void checkForFightEvents(final Player player) {
        if (player.isInCombat() && queuedFightEvent.size() > 0) {
            for (Enemy e : queuedFightEvent) {
                DialogManager.printMessage(e.getName() + " Attack you with " + e.getWeapon().getName());
                player.fight(e.getWeapon().getDamage(), e.getWeapon().getPenetration(), e.getWeapon().isMagical());
                final int hp = Math.round(player.getHp()) == 0 ? 1 : Math.round(player.getHp());
                DialogManager.printMessage("You have " + hp + " hp left");
            }
            queuedFightEvent.clear();
        }
    }


    private void checkForEnemies(final Field field, final Player player) {
        if (field.getEnemies().size() > 0) {
            player.setInCombat(true);
        } else {
            player.setInCombat(false);
        }
    }

    public void printStatus(final Field field) {
        if (field.getEnemies().size() > 0) {
            DialogManager.printMessage("Enemies are in your range: ");
            for (Enemy enemy : field.getEnemies()) {
                DialogManager.printMessage(enemy.getName());
            }
        } else if (field.getItems().size() > 0) {
            DialogManager.printMessage("In a chest you see following items: ");
            for (Item item : field.getItems()) {
                DialogManager.printMessage(item.getName());
            }
        } else if (field.getNpcs().size() > 0) {
            DialogManager.printMessage("You see following persons: ");
            for (NPC npc : field.getNpcs()) {
                DialogManager.printMessage(npc.getName());
            }
        } else {
            DialogManager.printMessage("You see a " + field.getBiom().getTitle() + " but its nothing here...");
        }
        DialogManager.printMessage("What will you do?");

    }

    public LootHandler getLootHandler() {
        return lootHandler;
    }
}
