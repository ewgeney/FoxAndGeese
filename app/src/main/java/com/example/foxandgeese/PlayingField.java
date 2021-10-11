package com.example.foxandgeese;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class PlayingField extends View {

    class Point {
        float x, y;

        Point(float[] floats) {
            this.x = floats[0];
            this.y = floats[1];
        }
    }


    public PlayingField(Context context) {
        super(context);
    }
    public PlayingField(Context context, AttributeSet attrs){
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int margin = 25;
        int x0 = width/2;
        int y0 = height/2;
        float step = (width-(width/margin)*2)/6;

        float [] a3 = {x0-3*step, y0+1*step};
        float [] a4 = {x0-3*step, y0+0*step};
        float [] a5 = {x0-3*step, y0-1*step};

        float [] b3 = {x0-2*step, y0+1*step};
        float [] b4 = {x0-2*step, y0+0*step};
        float [] b5 = {x0-2*step, y0-1*step};

        float [] c1 = {x0-1*step, y0+3*step};
        float [] c2 = {x0-1*step, y0+2*step};
        float [] c3 = {x0-1*step, y0+1*step};
        float [] c4 = {x0-1*step, y0-0*step};
        float [] c5 = {x0-1*step, y0-1*step};
        float [] c6 = {x0-1*step, y0-2*step};
        float [] c7 = {x0-1*step, y0-3*step};

        float [] d1 = {x0+0*step, y0+3*step};
        float [] d2 = {x0+0*step, y0+2*step};
        float [] d3 = {x0+0*step, y0+1*step};
        float [] d4 = {x0+0*step, y0-0*step};
        float [] d5 = {x0+0*step, y0-1*step};
        float [] d6 = {x0+0*step, y0-2*step};
        float [] d7 = {x0+0*step, y0-3*step};

        float [] e1 = {x0+1*step, y0+3*step};
        float [] e2 = {x0+1*step, y0+2*step};
        float [] e3 = {x0+1*step, y0+1*step};
        float [] e4 = {x0+1*step, y0-0*step};
        float [] e5 = {x0+1*step, y0-1*step};
        float [] e6 = {x0+1*step, y0-2*step};
        float [] e7 = {x0+1*step, y0-3*step};

        float [] f3 = {x0+2*step, y0+1*step};
        float [] f4 = {x0+2*step, y0-0*step};
        float [] f5 = {x0+2*step, y0-1*step};

        float [] g3 = {x0+3*step, y0+1*step};
        float [] g4 = {x0+3*step, y0-0*step};
        float [] g5 = {x0+3*step, y0-1*step};


        Point[] drawField =  {new Point(a3), new Point(c3), new Point(c1), new Point(e1), new Point(e3)
                , new Point(g3), new Point(g5), new Point(e5), new Point(e7), new Point(c7), new Point(c5)
                , new Point(a5), new Point(a3), new Point(a4), new Point(g4), new Point(d4), new Point(d1)
                , new Point(d7), new Point(c7), new Point(c6), new Point(e6), new Point(e5), new Point(c5)
                , new Point(c3), new Point(e3), new Point(e2), new Point(c2), new Point(c3), new Point(b3)
                , new Point(b5), new Point(e5), new Point(e3), new Point(f3), new Point(f5), new Point(e5)
                , new Point(g3), new Point(g5), new Point(c1), new Point(e1), new Point(a5), new Point(a3)
                , new Point(e7), new Point(c7), new Point(e5), new Point(c3), new Point(c5), new Point(e3)};

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();

        // переходим в первую точку рисования
        path.moveTo(drawField[0].x, drawField[0].y);

        // рисуем отрезки по заданным точкам
        for (int i = 1; i < drawField.length; i++){
            path.lineTo(drawField[i].x, drawField[i].y);
        }

        // выводим результат
        canvas.drawPath(path, paint);
    }
}

