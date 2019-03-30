package de.flash.game.user.event;

import de.flash.game.charakter.enemies.Enemy;
import de.flash.game.charakter.npc.NPC;
import de.flash.game.dialog.DialogManager;
import de.flash.game.item.Item;
import de.flash.game.map.field.Field;

public class EventManager {
    private boolean isInCombat = false;

    public EventManager() {

    }

    public void checkForEvents(final Field field) {
        if(field.getEnemies().size() > 0) {
            isInCombat = true;
        } else {
            isInCombat = false;
        }
    }

    public void printStatus(final Field field) {
        if(field.getEnemies().size() > 0) {
            DialogManager.PrintMessage("Enemies are in your range: ");
            for (Enemy enemy: field.getEnemies()) {
                DialogManager.PrintMessage(enemy.getName());
            }
            DialogManager.PrintMessage("What will you do?");
        } else if(field.getItems().size() > 0) {
            DialogManager.PrintMessage("In a chest you see following items: ");
            for (Item item: field.getItems()) {
                DialogManager.PrintMessage(item.getName());
            }
            DialogManager.PrintMessage("What will you do?");
        } else if(field.getNpcs().size() > 0) {
            DialogManager.PrintMessage("You see following persons: ");
            for (NPC npc: field.getNpcs()) {
                DialogManager.PrintMessage(npc.getName());
            }
            DialogManager.PrintMessage("What will you do?");
        } else {
            DialogManager.PrintMessage("You see " + field.getBiom().getTitle() + " but its nothing here...");
        }

    }

    public boolean isInCombat() {
        return isInCombat;
    }
}
