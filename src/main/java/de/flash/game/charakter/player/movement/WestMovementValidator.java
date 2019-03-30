package de.flash.game.charakter.player.movement;

import de.flash.game.map.Map;

public class WestMovementValidator extends MovementValidator {
    public WestMovementValidator(String errorMsg) {
        super(errorMsg);
    }

    public boolean canMove(int xcord, int ycord, int zcord, Map map) {
        return ycord >= 0;
    }
}
