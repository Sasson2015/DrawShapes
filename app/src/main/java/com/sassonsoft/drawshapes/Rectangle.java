package com.sassonsoft.drawshapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Sasson on 02/09/2015.
 */
public class Rectangle extends MyShape {
    private int width;
    private int height;

    public Rectangle(Context context) {
        super(context);
        setX(0);
        setY(0);
        width=200;
        height=100;
        setColor(Color.GREEN);
    }

    public Rectangle(int x, int y, int color, int width, int height,Context context) {
        super(context);
        setX(x);
        setY(y);
        setColor(color);
        this.width=width;
        this.height=height;
    }

    public int getwidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getheight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setColor(getColor());
        canvas.drawRect(getx(),gety(),getwidth(),getheight(),paint);
    }
}
