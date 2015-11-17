package com.berryjam.wildcircles;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class CanvasView extends View {
    public static int width;
    public static int height;
    GameManager gm;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initDisplayMetrics(context);
        gm = new GameManager(this, width, height);
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
        gm.onDraw(canvas);
    }
}
