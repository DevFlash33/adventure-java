package de.flash.game.charakter.player.movement;

import de.flash.game.map.Map;

public class SouthMovementValidator extends MovementValidator {
    public SouthMovementValidator(String errorMsg) {
        super(errorMsg);
    }

    public boolean canMove(int xcord, int ycord, int zcord, Map map) {
        return xcord >= 0;
    }
}
