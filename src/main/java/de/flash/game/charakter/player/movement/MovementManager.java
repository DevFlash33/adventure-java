package de.flash.game.charakter.player.movement;

import de.flash.game.dialog.DialogManager;
import de.flash.game.map.Map;

public final class MovementManager {
    private final NorthMovementValidator northMovementValidator = new NorthMovementValidator("Great hill landscape look at you, but at the moment you can't climb over that");
    private final SouthMovementValidator southMovementValidator = new SouthMovementValidator("A sea with dangerous legendary monster blocks the way");
    private final EastMovmentValidator eastMovmentValidator = new EastMovmentValidator("You see a lava landscape, you would die if you pass that");
    private final WestMovementValidator westMovementValidator = new WestMovementValidator("Its a dark cave, with dangerous sounds and a magic barrier. You try to pass it, but it throws you back");

    public boolean canMoveNorthEast(final int x, final int y, final int z, final Map map) {
        return canMoveNorth(x + 1, y, z, map) && canMoveEast(x, y + 1, z, map);
     }

    public boolean canMoveSouthEast(final int x, final int y, final int z, final Map map) {
        return canMoveSouth(x - 1, y, z, map) && canMoveEast(x, y + 1, z, map);
    }

    public boolean canMoveNorthWest(final int x, final int y, final int z, final Map map) {
        return canMoveNorth(x + 1, y, z, map) && canMoveWest(x, y - 1, z, map);
    }

    public boolean canMoveSouthWest(final int x, final int y, final int z, final Map map) {
        return canMoveSouth(x - 1, y, z, map) && canMoveWest(x, y - 1, z, map);
    }


    public boolean canMoveWest(final int x, final int y, final int z, final Map map) {
        if(westMovementValidator.canMove(x, y, z, map)) {
            return true;
        } else {
            DialogManager.printMessage(westMovementValidator.getErrorMsg());
            return false;
        }
    }

    public boolean canMoveNorth(final int x, final int y, final int z, final Map map) {
        if(northMovementValidator.canMove(x, y, z, map)) {
            return true;
        } else {
            DialogManager.printMessage(northMovementValidator.getErrorMsg());
            return false;
        }
    }

    public boolean canMoveEast(final int x, final int y, final int z, final Map map) {
        if(eastMovmentValidator.canMove(x, y, z, map)) {
            return true;
        } else {
            DialogManager.printMessage(eastMovmentValidator.getErrorMsg());
            return false;
        }
    }

    public boolean canMoveSouth(final int x, final int y, final int z, final Map map) {
        if(southMovementValidator.canMove(x, y, z, map)) {
            return true;
        } else {
            DialogManager.printMessage(southMovementValidator.getErrorMsg());
            return false;
        }
    }
}
