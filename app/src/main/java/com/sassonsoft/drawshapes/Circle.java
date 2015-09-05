package com.sassonsoft.drawshapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Sasson on 02/09/2015.
 */
public class Circle extends MyShape {
    int radius;

    public Circle(Context context) {
        super(context);
        setX(0);
        setY(0);
        setColor(Color.GREEN);
        radius=100;
    }

    public Circle(int x, int y, int color, int radius,Context context) {
        super(context);
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

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        paint.setColor(getColor());
        canvas.drawCircle(getx(), gety(), getRadius(), paint);

    }
}
