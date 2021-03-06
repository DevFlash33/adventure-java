package de.flash.game.map;

import de.flash.game.charakter.player.Player;
import de.flash.game.map.field.Field;
import de.flash.game.map.field.FieldGenerator;

public class Map {
    private final int maxX;
    private final int maxY;
    private int maxZ;
    private final FieldGenerator fieldGenerator;

    private Field[][][] field;

    public Map(final int maxX, final int maxY, final int maxZ) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.maxZ = maxZ;
        this.field = new Field[maxX][maxY][maxZ];
        fieldGenerator = new FieldGenerator();
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getMaxZ() {
        return maxZ;
    }

    public void setMaxZ(final int maxZ) {
        this.maxZ = maxZ;
    }

    public Field getField(final int x, final int y, final int z) {
        if(x < this.field.length && y < this.field[x].length && z < this.field[x][y].length) {
            if(this.field[x][y][z] == null) {
                return null;
            }
            return this.field[x][y][z];
        }
        return null;
    }

    /**
     *
     * @param player obj
     * @return Field based on Player Cords
     */
    public Field getField(final Player player) {
        if(player.getX() < this.field.length && player.getY() < this.field[player.getX()].length && player.getZ() < this.field[player.getX()][player.getY()].length) {
            if(this.field[player.getX()][player.getY()][player.getZ()] == null) {
                this.field[player.getX()][player.getY()][player.getZ()] = fieldGenerator.generateRandomField(player);
            }
            return this.field[player.getX()][player.getY()][player.getZ()];
        }
        return null;
    }


    public Field[][][] getField() {
        return field;
    }
}
