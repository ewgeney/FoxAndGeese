package com.game.view;

import com.badlogic.gdx.Gdx;

public class Field {
    private int x0 = Gdx.graphics.getWidth()/2;
    private int y0 = Gdx.graphics.getHeight()/2;
    private float step = (Gdx.graphics.getWidth()-(Gdx.graphics.getWidth()/25)*2)/6;

    public int [] board = new int[]       {0,0,0,
                                           0,0,0,
                                     0,0,0,0,0,0,0,0,0,
                                     0,0,0,0,0,0,0,0,0,
                                     0,0,0,0,0,0,0,0,0,
                                           0,0,0,
                                           0,0,0};
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

    private float [] a3 = {x0-3*step, y0+1*step};
    private float [] a4 = {x0-3*step, y0+0*step};
    private float [] a5 = {x0-3*step, y0-1*step};

    private float [] b3 = {x0-2*step, y0+1*step};
    private float [] b4 = {x0-2*step, y0+0*step};
    private float [] b5 = {x0-2*step, y0-1*step};

    private float [] c1 = {x0-1*step, y0+3*step};
    private float [] c2 = {x0-1*step, y0+2*step};
    private float [] c3 = {x0-1*step, y0+1*step};
    private float [] c4 = {x0-1*step, y0-0*step};
    private float [] c5 = {x0-1*step, y0-1*step};
    private float [] c6 = {x0-1*step, y0-2*step};
    private float [] c7 = {x0-1*step, y0-3*step};

    private float [] d1 = {x0+0*step, y0+3*step};
    private float [] d2 = {x0+0*step, y0+2*step};
    private float [] d3 = {x0+0*step, y0+1*step};
    private float [] d4 = {x0+0*step, y0-0*step};
    private float [] d5 = {x0+0*step, y0-1*step};
    private float [] d6 = {x0+0*step, y0-2*step};
    private float [] d7 = {x0+0*step, y0-3*step};

    private float [] e1 = {x0+1*step, y0+3*step};
    private float [] e2 = {x0+1*step, y0+2*step};
    private float [] e3 = {x0+1*step, y0+1*step};
    private float [] e4 = {x0+1*step, y0-0*step};
    private float [] e5 = {x0+1*step, y0-1*step};
    private float [] e6 = {x0+1*step, y0-2*step};
    private float [] e7 = {x0+1*step, y0-3*step};

    private float [] f3 = {x0+2*step, y0+1*step};
    private float [] f4 = {x0+2*step, y0-0*step};
    private float [] f5 = {x0+2*step, y0-1*step};

    private float [] g3 = {x0+3*step, y0+1*step};
    private float [] g4 = {x0+3*step, y0-0*step};
    private float [] g5 = {x0+3*step, y0-1*step};

    private float[][] AllVertices = {a3, a4, a5, b3, b4, b5, c1, c2, c3, c4, c5, c6, c7,
    d1, d2, d3, d4, d5, d6, d7, e1, e2, e3, e4, e5, e6, e7, f3, f4, f5, g3, g4, g5};

    public float[][] getAllVertices() {
        return AllVertices;
    }

    public float[] getVerticesField(){
        float[][] drawField = {a3, c3, c1, e1, e3, g3, g5, e5, e7, c7, c5, a5, a3, a4, g4, d4,
                d1, d7, c7, c6, e6, e5, c5, c3, e3, e2, c2, c3, b3, b5, e5, e3, f3, f5, e5,
                g3, g5, c1, e1, a5, a3, e7, c7, e5, c3, c5, e3};
        float[] vertices = new float[drawField.length*drawField[0].length];
        int count=0;
        for(int i = 0; i<drawField.length; i++){
            vertices[count] = drawField[i][0];
            vertices[count+1] = drawField[i][1];
            count +=2;
        }

        return vertices;
    }

    public float getStep() {
        return step;
    }

    public float[] getA3() {
        return a3;
    }

    public float[] getA4() {
        return a4;
    }

    public float[] getA5() {
        return a5;
    }

    public float[] getB3() {
        return b3;
    }

    public float[] getB4() {
        return b4;
    }

    public float[] getB5() {
        return b5;
    }

    public float[] getC1() {
        return c1;
    }

    public float[] getC2() {
        return c2;
    }

    public float[] getC3() {
        return c3;
    }

    public float[] getC4() {
        return c4;
    }

    public float[] getC5() {
        return c5;
    }

    public float[] getC6() {
        return c6;
    }

    public float[] getC7() {
        return c7;
    }

    public float[] getD1() {
        return d1;
    }

    public float[] getD2() {
        return d2;
    }

    public float[] getD3() {
        return d3;
    }

    public float[] getD4() {
        return d4;
    }

    public float[] getD5() {
        return d5;
    }

    public float[] getD6() {
        return d6;
    }

    public float[] getD7() {
        return d7;
    }

    public float[] getE1() {
        return e1;
    }

    public float[] getE2() {
        return e2;
    }

    public float[] getE3() {
        return e3;
    }

    public float[] getE4() {
        return e4;
    }

    public float[] getE5() {
        return e5;
    }

    public float[] getE6() {
        return e6;
    }

    public float[] getE7() {
        return e7;
    }

    public float[] getF3() {
        return f3;
    }

    public float[] getF4() {
        return f4;
    }

    public float[] getF5() {
        return f5;
    }

    public float[] getG3() {
        return g3;
    }

    public float[] getG4() {
        return g4;
    }

    public float[] getG5() {
        return g5;
    }
}
