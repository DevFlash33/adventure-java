package de.flash.game.map.biom;

public abstract class Biom {
    private String title;

    protected Biom(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
