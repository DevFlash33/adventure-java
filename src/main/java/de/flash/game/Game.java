package de.flash.game;

import de.flash.game.charakter.player.Player;
import de.flash.game.dialog.DialogManager;
import de.flash.game.map.Map;
import de.flash.game.map.field.Field;
import de.flash.game.system.loot.LootHandler;
import de.flash.game.user.Manager;
import de.flash.game.user.combat.CombatManager;
import de.flash.game.user.command.CommandManager;
import de.flash.game.user.event.EventHandler;
import de.flash.game.user.input.InputHandler;

public class Game {

    private final Map map = new Map(100,100, 5);
    private final Player player;
    private final CommandManager commandManager = new CommandManager();
    private final InputHandler inputHandler = new InputHandler();
    private final EventHandler eventHandler = new EventHandler();
    private final CombatManager combatManager = new CombatManager();
    private boolean isDoingSomething = true;

    public Game() {
        DialogManager.printMessage("Welcome to the greatest Adventure! Enter your Name: ");
        player = new Player(inputHandler.getInput(), 0, 0, 0);
        do {
            update();
        } while (!(player.getHp() <= 0));
    }

    private void update() {
        final Field currentField = map.getField(player);
        if (isDoingSomething) {
            eventHandler.checkForEvents(currentField, player);
        }
        if (!(player.getHp() <= 0)) {
            eventHandler.printStatus(currentField);
            final String input = inputHandler.getInput();
            if (player.isInCombat()) {
                handleInteraction(input, combatManager, eventHandler.getLootHandler());
            } else {
                handleInteraction(input, commandManager, eventHandler.getLootHandler());
            }
        }
    }

    private void handleInteraction(final String input, final Manager manager, final LootHandler lootHandler) {
        if (manager.isValidCommand(input)) {
            manager.handleCommand(input, map, player, lootHandler);
            if (!input.split(" ")[0].equalsIgnoreCase("help")) {
                isDoingSomething = true;
            }
        } else {
            DialogManager.printMessage("You think you do " + input + " but nothing happen");
            isDoingSomething = false;
        }
    }

    /**
     * Not needed
     */
    private void render() {

    }
}
