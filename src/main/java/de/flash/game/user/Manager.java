package de.flash.game.user;

import de.flash.game.charakter.player.Player;
import de.flash.game.map.Map;
import de.flash.game.system.loot.LootHandler;

public abstract class Manager {

    public abstract boolean isValidCommand(final String command);

    public abstract void handleCommand(final String command, final Map map, final Player player, final LootHandler lootHandler);
}
