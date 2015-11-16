package com.berryjam.wildcircles;

import android.graphics.Canvas;
import android.graphics.Paint;

public class GameManager {

    private Paint paint;
    private MainCircle mainCircle;

    public GameManager() {
        initPaint();
        initMainCircle();
    }

    public void initMainCircle() {
        mainCircle = new MainCircle(200,500);
    }

    public void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);

    }

    public void onDraw(Canvas canvas) {
        canvas.drawCircle(mainCircle.getX(), mainCircle.getY(), mainCircle.getRadius(), paint);
    }

    public Paint getPaint() {
        return paint;
    }

    public MainCircle getMainCircle() {
        return mainCircle;
    }


}
