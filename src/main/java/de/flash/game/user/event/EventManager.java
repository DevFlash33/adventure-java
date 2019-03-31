package de.flash.game.user.event;

import de.flash.game.charakter.enemies.Enemy;
import de.flash.game.charakter.npc.NPC;
import de.flash.game.charakter.player.Player;
import de.flash.game.dialog.DialogManager;
import de.flash.game.item.Item;
import de.flash.game.map.field.Field;

import java.util.ArrayList;
import java.util.Random;

public class EventManager {
    private boolean isInCombat = false;
    private final ArrayList<Enemy> queuedFightEvent;
    private final Random random = new Random();

    public EventManager() {
        queuedFightEvent = new ArrayList<>();
    }

    public void queueFightEvent(final Enemy enemy) {
        queuedFightEvent.add(enemy);
    }

    public void checkForEvents(final Field field, final Player player) {
        checkForEnemies(field, player);
        checkForFightEvents(player);
        queueFightEvents(field, player);
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
                DialogManager.PrintMessage(e.getName() + " Attack you with " + e.getWeapon().getName());
                player.fight(e.getWeapon().getDamage(), e.getWeapon().getPenetration(), e.getWeapon().isMagical());
                DialogManager.PrintMessage("You have " + player.getHp() + " hp left");
            }
            queuedFightEvent.clear();
        }
    }


    private void checkForEnemies(final Field field, final Player player) {
        if (field.getEnemies().size() > 0) {
            isInCombat = true;
            player.setInCombat(true);
        } else {
            isInCombat = false;
            player.setInCombat(false);
        }
    }

    public void printStatus(final Field field) {
        if (field.getEnemies().size() > 0) {
            DialogManager.PrintMessage("Enemies are in your range: ");
            for (Enemy enemy : field.getEnemies()) {
                DialogManager.PrintMessage(enemy.getName());
            }
        } else if (field.getItems().size() > 0) {
            DialogManager.PrintMessage("In a chest you see following items: ");
            for (Item item : field.getItems()) {
                DialogManager.PrintMessage(item.getName());
            }
        } else if (field.getNpcs().size() > 0) {
            DialogManager.PrintMessage("You see following persons: ");
            for (NPC npc : field.getNpcs()) {
                DialogManager.PrintMessage(npc.getName());
            }
        } else {
            DialogManager.PrintMessage("You see a" + field.getBiom().getTitle() + " but its nothing here...");
        }
        DialogManager.PrintMessage("What will you do?");

    }

    public boolean isInCombat() {
        return isInCombat;
    }
}
