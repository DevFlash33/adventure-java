package de.flash.game.item;

public abstract class Item {
    private String name;
    private float weight;
    private float worth;

    protected Item(String name, float weight, float worth) {
        this.name = name;
        this.weight = weight;
        this.worth = worth;
    }

    public float getWorth() {
        return worth;
    }

    public void setWorth(float worth) {
        this.worth = worth;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
