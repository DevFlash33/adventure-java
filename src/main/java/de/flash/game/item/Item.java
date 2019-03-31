package de.flash.game.item;

public abstract class Item {
    private String name;
    private float weight;
    private float worth;

    protected Item(final String name, final float weight, final float worth) {
        this.name = name;
        this.weight = weight;
        this.worth = worth;
    }

    public float getWorth() {
        return worth;
    }

    public void setWorth(final float worth) {
        this.worth = worth;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(final float weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
