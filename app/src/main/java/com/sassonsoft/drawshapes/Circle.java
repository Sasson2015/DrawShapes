package com.sassonsoft.drawshapes;

import android.graphics.Color;

/**
 * Created by Sasson on 02/09/2015.
 */
public class Circle extends MyShape {
    int radius;

    public Circle() {
        setX(0);
        setY(0);
        setColor(Color.GREEN);
        radius=10;
    }

    public Circle(int x, int y, int color, int radius) {
        setX(x);
        setY(y);
        setColor(color);
        this.radius=radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
