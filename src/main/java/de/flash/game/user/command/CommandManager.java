package de.flash.game.user.command;

import de.flash.game.charakter.player.Player;
import de.flash.game.dialog.DialogManager;
import de.flash.game.map.Map;

import java.util.ArrayList;

public class CommandManager {

    private final ArrayList<String> commands = new ArrayList<>();

    public CommandManager() {
        commands.add("help");
        commands.add("die");
        commands.add("move");
    }

    public void handleCommand(final String command, final Map map, final Player player) {
        startCommand(command, map, player);
    }

    private void startCommand(String command, final Map map, final Player player) {
        command = command.toLowerCase();
        final String splittedCommand = command.split(" ")[0];
        switch (splittedCommand) {
            case "help":
                help();
                break;
            case "die":
                player.die();
                break;
            case "move":
                move(command, map, player);
                break;
        }
    }

    private void move(final String command, final Map map, final Player player) {
        final String[] splittedCommand = command.split(" ");
        if (splittedCommand.length > 1) {
            switch (splittedCommand[1]) {
                case "west":
                    player.moveLeft(map);
                    break;
                case "north":
                    player.moveForward(map);
                    break;
                case "east":
                    player.moveRight(map);
                    break;
                case "south":
                    player.moveBackward(map);
                    break;
                default:
                    DialogManager.PrintMessage("You look at the compass and dont found the direction");
                    break;
            }
        }
    }


    private void help() {
        DialogManager.PrintMessage("Possible commands: ");
        for (String command : commands) {
            DialogManager.PrintMessage("-> " + command);
        }
    }

    public boolean isValidCommand(String command) {
        command = command.toLowerCase();
        final String splittedCommand = command.split(" ")[0];
        return commands.stream().anyMatch(res -> res.equals(splittedCommand));
    }
}
