package org.example.overrideexample;

public class Circle extends ItemImpl {

    private final int radius;

    public Circle(int x, int y, int color, int radius) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle::draw" + this);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                "} " + super.toString();
    }
}
