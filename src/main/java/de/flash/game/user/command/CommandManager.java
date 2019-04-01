package de.flash.game.user.command;

import de.flash.game.charakter.player.Player;
import de.flash.game.dialog.DialogManager;
import de.flash.game.item.Item;
import de.flash.game.map.Map;
import de.flash.game.system.loot.LootHandler;
import de.flash.game.user.Manager;

import java.util.ArrayList;

public final class CommandManager extends Manager {

    private final ArrayList<String> commands = new ArrayList<>();

    public CommandManager() {
        commands.add("help");
        commands.add("die");
        commands.add("move <direction>");
        commands.add("go <direction>");
        commands.add("rest");
        commands.add("take <object to take>");
        commands.add("collect <object to collect>");
        commands.add("pick-up <object to pick up>");
    }

    public void handleCommand(final String command, final Map map, final Player player, final LootHandler lootHandler) {
        startCommand(command.toLowerCase(), map, player, lootHandler);
    }

    private void startCommand(final String command, final Map map, final Player player, final LootHandler lootHandler) {
        final String splittedCommand = command.split(" ")[0];
        switch (splittedCommand) {
            case "help":
                help();
                break;
            case "die":
                commitSuicide(player);
                break;
            case "move":
                move(command, map, player, lootHandler);
                break;
            case "go":
                move(command, map, player, lootHandler);
                break;
            case "rest":
                rest(player);
                break;
            case "take":
                take(command, player, lootHandler);
                break;
            case "collect":
                take(command, player, lootHandler);
                break;
            case "pick-up":
                take(command, player, lootHandler);
                break;
        }
    }

    private void take(final String command, final Player player, final LootHandler lootHandler) {
        final String[] splittedCommand = command.split(" ");
        if (splittedCommand.length > 1) {
            final String objectToGet = splittedCommand[1];
            if (objectToGet.equalsIgnoreCase("money")) {
                DialogManager.printMessage("You collect " + lootHandler.getMoney() + " money");
                player.addMoney(lootHandler.getMoney());
                lootHandler.setMoney(0);
            } else {
                final Item item = lootHandler.findItemByName(objectToGet);
                if (item != null) {
                    DialogManager.printMessage("You collect " + item.getName());
                    player.getInventory().addItem(item);
                    lootHandler.deleteItemByObj(item);
                }
            }
        }
    }

    private void commitSuicide(final Player player) {
        player.die();
    }

    private void rest(final Player player) {
        player.rest();
    }

    private void move(final String command, final Map map, final Player player, final LootHandler lootHandler) {
        final String[] splittedCommand = command.split(" ");
        if (splittedCommand.length > 1) {
            boolean canClear = true;
            switch (splittedCommand[1]) {
                case "west":
                    player.moveLeft(map);
                    break;
                case "north":
                    player.moveForward(map);
                    break;
                case "north-west":
                    player.moveForwardLeft(map);
                    break;
                case "north-east":
                    player.moveForwardRight(map);
                    break;
                case "east":
                    player.moveRight(map);
                    break;
                case "south":
                    player.moveBackward(map);
                    break;
                case "south-west":
                    player.moveBackwardLeft(map);
                    break;
                case "south-east":
                    player.moveBackwardRight(map);
                    break;
                default:
                    canClear = false;
                    DialogManager.printMessage("You look at the compass and dont found the direction " + splittedCommand[1]);
                    break;
            }
            if(canClear) {
                lootHandler.clear();
            }
        }
    }


    private void help() {
        DialogManager.printMessage("Possible commands: ");
        for (final String command : commands) {
            DialogManager.printMessage("-> " + command);
        }
    }

    public boolean isValidCommand(final String command) {
        final String splittedCommand = command.toLowerCase().split(" ")[0];
        return commands.stream().anyMatch(res -> res.split(" ")[0].equals(splittedCommand));
    }
}
