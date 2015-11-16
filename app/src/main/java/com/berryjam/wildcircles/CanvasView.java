package com.berryjam.wildcircles;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class CanvasView extends View {

    GameManager gm;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        gm = new GameManager();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        gm.onDraw(canvas);
    }
}
