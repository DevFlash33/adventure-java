package de.flash.game.dialog;

import de.flash.game.charakter.player.Player;
import de.flash.game.map.Map;

import java.util.ArrayList;

public class CommandManager {

    private final ArrayList<String> commands = new ArrayList<>();

    public CommandManager() {

    }

    public void handleCommand(final String command,final Map map,final Player player) {
        startCommand(command, map, player);
    }

    private void startCommand(String command, final Map map, final Player player) {
        command = command.toLowerCase();
        final String splittedCommand = command.split(" ")[0];
        switch (command) {
            case "help":
                help();
        }
    }

    private void help() {
        DialogManager.PrintMessage("Possible commands: ");
        for (String command: commands) {
            DialogManager.PrintMessage("-> " + command);
        }
    }

    public boolean isValidCommand(String command) {
        command = command.toLowerCase();
        final String splittedCommand = command.split(" ")[0];
        return commands.stream().anyMatch(res -> res.equals(splittedCommand));
    }
}
