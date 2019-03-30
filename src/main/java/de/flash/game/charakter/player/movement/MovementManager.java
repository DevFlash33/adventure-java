package de.flash.game.charakter.player.movement;

import de.flash.game.dialog.DialogManager;
import de.flash.game.map.Map;

public final class MovementManager {
    private final NorthMovementValidator northMovementValidator = new NorthMovementValidator("You see a great Hill place, but at the moment you can't climb over that");
    private final SouthMovementValidator southMovementValidator = new SouthMovementValidator("A sea with dangerous legendary monster blocks the way");
    private final EastMovmentValidator eastMovmentValidator = new EastMovmentValidator("You see a lava landscape, you would die if you pass that");
    private final WestMovementValidator westMovementValidator = new WestMovementValidator("Its a dark cave, with dangerous sounds and a magic barrier. You try to pass it, but it throws you back");

    public boolean canMoveWest(int x, int y, int z, Map map) {
        if(westMovementValidator.canMove(x, y, z, map)) {
            return true;
        } else {
            DialogManager.PrintMessage(westMovementValidator.getErrorMsg());
            return false;
        }
    }

    public boolean canMoveNorth(int x, int y, int z, Map map) {
        if(northMovementValidator.canMove(x, y, z, map)) {
            return true;
        } else {
            DialogManager.PrintMessage(northMovementValidator.getErrorMsg());
            return false;
        }
    }

    public boolean canMoveEast(int x, int y, int z, Map map) {
        if(eastMovmentValidator.canMove(x, y, z, map)) {
            return true;
        } else {
            DialogManager.PrintMessage(eastMovmentValidator.getErrorMsg());
            return false;
        }
    }

    public boolean canMoveSouth(int x, int y, int z, Map map) {
        if(southMovementValidator.canMove(x, y, z, map)) {
            return true;
        } else {
            DialogManager.PrintMessage(southMovementValidator.getErrorMsg());
            return false;
        }
    }
}
