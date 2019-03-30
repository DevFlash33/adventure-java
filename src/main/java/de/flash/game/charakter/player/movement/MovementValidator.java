package de.flash.game.charakter.player.movement;

import de.flash.game.map.Map;

public abstract class MovementValidator {
    private String errorMsg;

    public MovementValidator(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public abstract boolean canMove(int xcord, int ycord, int zcord, Map map);

    public String getErrorMsg() {
        return errorMsg;
    }
}
