package de.flash.game;

import de.flash.game.charakter.player.Player;
import de.flash.game.dialog.DialogManager;
import de.flash.game.map.Map;
import de.flash.game.map.field.Field;
import de.flash.game.user.combat.CombatManager;
import de.flash.game.user.command.CommandManager;
import de.flash.game.user.event.EventManager;
import de.flash.game.user.input.InputManager;

public class Game {

    private final Map map = new Map(100,100, 5);
    private final Player player;
    private final CommandManager commandManager = new CommandManager();
    private final InputManager inputManager = new InputManager();
    private final EventManager eventManager = new EventManager();
    private final CombatManager combatManager = new CombatManager();

    public Game() {
        DialogManager.PrintMessage("Welcome to the greatest Adventure! Enter your Name: ");
        player = new Player(inputManager.getInput(), 0, 0, 0);
        do {
            update();
        } while (!(player.getHp() <= 0));
    }

    private void update() {
        final Field currentField = map.getField(player);
        eventManager.checkForEvents(currentField, player);
        if (!(player.getHp() <= 0)) {
            eventManager.printStatus(currentField);
            final String input = inputManager.getInput();
            if (eventManager.isInCombat()) {
                combatManager.handleCommand(input, map, player);
            } else {
                handleNormalInteraction(input);
            }
        }
    }

    private void handleNormalInteraction(final String input) {
        if (commandManager.isValidCommand(input)) {
            commandManager.handleCommand(input, map, player);
        } else {
            DialogManager.PrintMessage("You think you do " + input + " but nothing happen");
        }
    }

    /**
     * Not needed
     */
    private void render() {

    }
}
