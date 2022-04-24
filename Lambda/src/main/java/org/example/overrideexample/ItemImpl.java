package org.example.overrideexample;

public abstract class ItemImpl implements Item{
    private int x;
    private int y;
    private int color;

    public ItemImpl(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public abstract void draw();

    @Override
    public String toString() {
        return "ItemImpl{" +
                "x=" + x +
                ", y=" + y +
                ", color=" + color +
                '}';
    }
}
