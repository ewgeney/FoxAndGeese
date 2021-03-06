package com.game.model;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.HashMap;

public class Field {
    //рассчет центра экрана и шага для отрисовки поля
    private int x0 = Gdx.graphics.getWidth() / 2;
    private int y0 = Gdx.graphics.getHeight() / 2;
    private float step = (Gdx.graphics.getWidth() - (Gdx.graphics.getWidth() / 25) * 2) / 6;

    //массив состояния поля -1 свободно, 0-12 гуси, 13-лиса
    public ArrayList<Integer> board = new ArrayList<>();
    public HashMap<Integer, Integer> boardCost = new HashMap<>();

    public Field() {
        while (board.size()!=33){
            board.add(-1);
        }
    }

    //индексы соответствующих вершин в массиве состояния
    public final int A3 = 0;
    public final int A4 = 1;
    public final int A5 = 2;
    public final int B3 = 3;
    public final int B4 = 4;
    public final int B5 = 5;
    public final int C1 = 6;
    public final int C2 = 7;
    public final int C3 = 8;
    public final int C4 = 9;
    public final int C5 = 10;
    public final int C6 = 11;
    public final int C7 = 12;
    public final int D1 = 13;
    public final int D2 = 14;
    public final int D3 = 15;
    public final int D4 = 16;
    public final int D5 = 17;
    public final int D6 = 18;
    public final int D7 = 19;
    public final int E1 = 20;
    public final int E2 = 21;
    public final int E3 = 22;
    public final int E4 = 23;
    public final int E5 = 24;
    public final int E6 = 25;
    public final int E7 = 26;
    public final int F3 = 27;
    public final int F4 = 28;
    public final int F5 = 29;
    public final int G3 = 30;
    public final int G4 = 31;
    public final int G5 = 32;

    //вычисление координат вершин на экране, от центра с шагом step
    private float[] a3 = {x0 - 3 * step, y0 + 1 * step};
    private float[] a4 = {x0 - 3 * step, y0 + 0 * step};
    private float[] a5 = {x0 - 3 * step, y0 - 1 * step};

    private float[] b3 = {x0 - 2 * step, y0 + 1 * step};
    private float[] b4 = {x0 - 2 * step, y0 + 0 * step};
    private float[] b5 = {x0 - 2 * step, y0 - 1 * step};

    private float[] c1 = {x0 - 1 * step, y0 + 3 * step};
    private float[] c2 = {x0 - 1 * step, y0 + 2 * step};
    private float[] c3 = {x0 - 1 * step, y0 + 1 * step};
    private float[] c4 = {x0 - 1 * step, y0 - 0 * step};
    private float[] c5 = {x0 - 1 * step, y0 - 1 * step};
    private float[] c6 = {x0 - 1 * step, y0 - 2 * step};
    private float[] c7 = {x0 - 1 * step, y0 - 3 * step};

    private float[] d1 = {x0 + 0 * step, y0 + 3 * step};
    private float[] d2 = {x0 + 0 * step, y0 + 2 * step};
    private float[] d3 = {x0 + 0 * step, y0 + 1 * step};
    private float[] d4 = {x0 + 0 * step, y0 - 0 * step};
    private float[] d5 = {x0 + 0 * step, y0 - 1 * step};
    private float[] d6 = {x0 + 0 * step, y0 - 2 * step};
    private float[] d7 = {x0 + 0 * step, y0 - 3 * step};

    private float[] e1 = {x0 + 1 * step, y0 + 3 * step};
    private float[] e2 = {x0 + 1 * step, y0 + 2 * step};
    private float[] e3 = {x0 + 1 * step, y0 + 1 * step};
    private float[] e4 = {x0 + 1 * step, y0 - 0 * step};
    private float[] e5 = {x0 + 1 * step, y0 - 1 * step};
    private float[] e6 = {x0 + 1 * step, y0 - 2 * step};
    private float[] e7 = {x0 + 1 * step, y0 - 3 * step};

    private float[] f3 = {x0 + 2 * step, y0 + 1 * step};
    private float[] f4 = {x0 + 2 * step, y0 - 0 * step};
    private float[] f5 = {x0 + 2 * step, y0 - 1 * step};

    private float[] g3 = {x0 + 3 * step, y0 + 1 * step};
    private float[] g4 = {x0 + 3 * step, y0 - 0 * step};
    private float[] g5 = {x0 + 3 * step, y0 - 1 * step};

    //координаты всех вершин
    private float[][] AllVertices = {a3, a4, a5, b3, b4, b5, c1, c2, c3, c4, c5, c6, c7,
            d1, d2, d3, d4, d5, d6, d7, e1, e2, e3, e4, e5, e6, e7, f3, f4, f5, g3, g4, g5};

    public float[][] getAllVertices() {
        return AllVertices;
    }

    //возвращает вершины для отрисовки игрового поля
    public float[] getVerticesField() {
        float[][] drawField = {a3, c3, c1, e1, e3, g3, g5, e5, e7, c7, c5, a5, a3, a4, g4, d4,
                d1, d7, c7, c6, e6, e5, c5, c3, e3, e2, c2, c3, b3, b5, e5, e3, f3, f5, e5,
                g3, g5, c1, e1, a5, a3, e7, c7, e5, c3, c5, e3};
        float[] vertices = new float[drawField.length * drawField[0].length];
        int count = 0;
        for (int i = 0; i < drawField.length; i++) {
            vertices[count] = drawField[i][0];
            vertices[count + 1] = drawField[i][1];
            count += 2;
        }
        return vertices;
    }

    public float getStep() {
        return step;
    }

}
