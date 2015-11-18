package com.berryjam.wildcircles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class CanvasView extends View implements ICanvasView {
    private static int width;
    private static int height;
    private GameManager gm;
    private Paint paint;
    private Canvas canvas;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initDisplayMetrics(context);
        initPaint();
        gm = new GameManager(this, width, height);
    }

    public void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);

    }

    private void initDisplayMetrics(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        DisplayMetrics dm = new DisplayMetrics();
        display.getMetrics(dm);

        width = dm.widthPixels;
        height = dm.heightPixels;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        gm.onDraw();
    }

    @Override
    public void drawCircle(SimpleCircle circle) {
        paint.setColor(circle.getColor());
        canvas.drawCircle(circle.getX(), circle.getY(), circle.getRadius(), paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            gm.onTouchEvent(x, y);
        }
        invalidate();
        return true;
    }
}
