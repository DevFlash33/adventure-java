package de.flash.game;

import de.flash.game.charakter.player.Player;
import de.flash.game.dialog.CommandManager;
import de.flash.game.dialog.DialogManager;
import de.flash.game.map.Map;
import de.flash.game.user.input.InputManager;

public class Game {

    private final Map map = new Map(100,100, 5);
    private final Player player;
    private final CommandManager commandManager = new CommandManager();
    private final InputManager inputManager = new InputManager();

    public Game() {
        DialogManager.PrintMessage("Welcome to the greatest Adventure! Enter your Name: ");
        player = new Player(inputManager.getInput());
        do {
            update();
        } while (!(player.getHp() <= 0));
    }

    private void update() {
        DialogManager.PrintMessage("You looking around and doing...");
        commandManager.handleCommand(inputManager.getInput(), map, player);

    }
}
