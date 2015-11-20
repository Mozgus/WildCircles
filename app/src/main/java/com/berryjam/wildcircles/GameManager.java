package com.berryjam.wildcircles;

import java.util.ArrayList;

public class GameManager {

    public static final int MAX_CIRCLES = 10;
    private MainCircle mainCircle;
    private ArrayList<EnemyCircle> circles;
    private ICanvasView canvasView;
    private static int width;
    private static int height;


    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        width = w;
        height = h;
        initMainCircle();
        initEnemyCircles();
    }

    private void initEnemyCircles() {
        circles = new ArrayList<>();
        for (int i = 0; i < MAX_CIRCLES; i++) {
            EnemyCircle circle;
            SimpleCircle mainCircleArea = mainCircle.getCircleArea();
            do {
                circle = EnemyCircle.getRandomCircle();
            } while (circle.isIntersect(mainCircleArea));
            circles.add(circle);
        }
        calculateAndSetCirclesColor();
    }

    private void calculateAndSetCirclesColor() {
        for (EnemyCircle circle : circles) {
            circle.setEnemyOrFoodColorDependsOn(mainCircle);
        }
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public void initMainCircle() {
        mainCircle = new MainCircle(width / 2, height / 2);
    }

    public void onDraw() {
        canvasView.drawCircle(mainCircle);
        for (EnemyCircle circle : circles) {
            canvasView.drawCircle(circle);
        }
    }

    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleWhenTouchAt(x, y);
        checkCollisions();
        moveCircles();
    }

    private void checkCollisions() {
        for (EnemyCircle circle : circles) {
            if (mainCircle.isIntersect(circle)) {
                gameOver();
            }
        }
    }

    private void moveCircles() {
        for (EnemyCircle circle : circles) {
            circle.moveOneStep();
        }
    }

    private void gameOver() {
        mainCircle.initRadius();
        initEnemyCircles();
        canvasView.reDraw();
    }
}
