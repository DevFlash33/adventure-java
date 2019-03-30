package de.flash.game.charakter.player.movement;

import de.flash.game.map.Map;

public class EastMovmentValidator extends MovementValidator {
    public EastMovmentValidator(String errorMsg) {
        super(errorMsg);
    }

    public boolean canMove(int xcord, int ycord, int zcord, Map map) {
        return ycord <= map.getMaxY();
    }
}
