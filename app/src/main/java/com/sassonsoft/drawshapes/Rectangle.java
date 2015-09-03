package com.sassonsoft.drawshapes;

import android.graphics.Color;

/**
 * Created by Sasson on 02/09/2015.
 */
public class Rectangle extends MyShape {
    private int width;
    private int height;

    public Rectangle() {
        setX(0);
        setY(0);
        width=200;
        height=100;
        setColor(Color.GREEN);
    }

    public Rectangle(int x, int y, int color, int width, int height) {
        setX(x);
        setY(y);
        setColor(color);
        this.width=width;
        this.height=height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
