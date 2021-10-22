package com.game.view;

import com.badlogic.gdx.Gdx;

public class Field {
    private int x0 = Gdx.graphics.getWidth()/2;
    private int y0 = Gdx.graphics.getHeight()/2;
    private float step = (Gdx.graphics.getWidth()-(Gdx.graphics.getWidth()/25)*2)/6;

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
