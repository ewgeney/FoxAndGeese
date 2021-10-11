package com.example.foxandgeese;
import android.widget.ImageView;

public class Geese {
    ImageView geeseImageView;
    static int geese_num;
    float[] field;

    public Geese(float[] field){
        geese_num++;
        this.field=field;
    }

}
