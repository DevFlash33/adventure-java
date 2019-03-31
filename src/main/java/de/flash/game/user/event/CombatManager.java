package de.flash.game.user.event;

import de.flash.game.charakter.enemies.Enemy;
import de.flash.game.charakter.player.Player;
import de.flash.game.dialog.DialogManager;
import de.flash.game.map.Map;
import de.flash.game.map.field.Field;

import java.util.ArrayList;

public class CombatManager {
    private final ArrayList<String> commands = new ArrayList<>();

    public CombatManager() {
        commands.add("fight");
        commands.add("help");
    }

    public void handleCommand(String command, final Map map, final Player player) {
        command = command.toLowerCase();
        final String splittedCommand = command.split(" ")[0];
        switch (splittedCommand) {
            case "fight":
                fight(command, map, player);
                break;
        }
    }

    private void fight(final String command, final Map map, final Player player) {
        final String[] splittedCommand = command.split(" ");
        if(splittedCommand.length > 1) {
            final Field currentField = map.getField(player);
            final Enemy enemy = currentField.getEnemyByName(splittedCommand[1]);
            if(enemy != null) {
                final int index = currentField.getIndexOfEnemy(enemy);
                DialogManager.PrintMessage("You attack " + enemy.getName() + " with your " + player.getWeapon().getName());
                enemy.fight(player.getWeapon().getDamage(), player.getWeapon().getPenetration() , player.getWeapon().isMagical());
                currentField.updateEnemies(enemy, index);
            } else {
                DialogManager.PrintMessage("You try to attack " + splittedCommand[1] + " but there is no one with this name. Maybe you hallucinate?");
            }
        } else {
            DialogManager.PrintMessage("You hit the air and nothing happen");
        }


    }
}
