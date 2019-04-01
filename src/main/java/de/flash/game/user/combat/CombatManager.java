package de.flash.game.user.combat;

import de.flash.game.charakter.enemies.Enemy;
import de.flash.game.charakter.player.Player;
import de.flash.game.dialog.DialogManager;
import de.flash.game.map.Map;
import de.flash.game.map.field.Field;
import de.flash.game.system.loot.LootHandler;
import de.flash.game.user.Manager;

import java.util.ArrayList;

public final class CombatManager extends Manager {
    private final ArrayList<String> commands = new ArrayList<>();
    private boolean autoFight = false;

    public CombatManager() {
        commands.add("fight <name>");
        commands.add("auto-fight");
        commands.add("help");
    }

    public void handleCommand(String command, final Map map, final Player player, final LootHandler lootHandler) {
        startCommand(command, map, player, lootHandler);
    }

    private void startCommand(String command, Map map, Player player, LootHandler lootHandler) {
        command = command.toLowerCase();
        final String splittedCommand = command.split(" ")[0];
        switch (splittedCommand) {
            case "fight":
                fight(command, map, player, lootHandler);
                break;
            case "help":
                printHelp();
                break;
            case "auto-fight":
                autoFight = true;
        }
    }

    private void printHelp() {
        DialogManager.printMessage("Available commands:");
        commands.forEach(DialogManager::printMessage);
    }

    public String getRandomEnemyName(final Map map, final Player player) {
        return map.getField(player).getRandomEnemyName();
    }

    private void fight(final String command, final Map map, final Player player, final LootHandler lootHandler) {
        final String[] splittedCommand = command.split(" ");
        if(splittedCommand.length > 1) {
            final Field currentField = map.getField(player);
            final Enemy enemy = currentField.getEnemyByName(splittedCommand[1]);
            if(enemy != null) {
                final int index = currentField.getIndexOfEnemy(enemy);
                DialogManager.printFightMessage("You attack " + enemy.getName() + " with your " + player.getWeapon().getName());
                enemy.fight(player.getWeapon().getDamage(), player.getWeapon().getPenetration() , player.getWeapon().isMagical());
                currentField.updateEnemies(enemy, index);
                if (enemy.getHp() <= 0) {
                    player.addLvlProgress(enemy.getExp());
                    lootHandler.handleLoot(enemy);
                }
            } else {
                DialogManager.printFightMessage("You try to attack " + splittedCommand[1] + " but there is no one with this name. Maybe you hallucinate?");
            }
        } else {
            DialogManager.printFightMessage("You hit the air and nothing happen");
        }
    }

    public boolean isValidCommand(final String command) {
        final String splittedCommand = command.toLowerCase().split(" ")[0];
        return commands.stream().anyMatch(res -> res.split(" ")[0].equals(splittedCommand));
    }

    public boolean isAutoFight() {
        return autoFight;
    }

    public void setAutoFight(boolean autoFight) {
        this.autoFight = autoFight;
    }
}
