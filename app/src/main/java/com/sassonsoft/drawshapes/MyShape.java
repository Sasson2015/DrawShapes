package com.sassonsoft.drawshapes;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

/**
 * Created by Sasson on 02/09/2015.
 */
public class MyShape extends View {
    private int x;
    private int y;
    private int color;

    public MyShape(Context context) {
        super(context);
        x=0;
        y=0;
        color= Color.GREEN;
    }

    public MyShape(int x,int y, int color,Context context) {
        super(context);
        this.x=x;
        this.y=y;
        this.color=color;
    }

    public int gety() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getx() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
