package com.example.foxandgeese;

import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foxandgeese.Fields.Coordinates;
import com.example.foxandgeese.Fields.PlayingField;

public class GameActivity extends AppCompatActivity {
    private TextView serviceInfoView;
    Coordinates currentCoordinates;
    //private ImageView fieldImageView;

    private ImageView fox;
    private ImageView goose1;
    private ImageView goose2;
    private ImageView goose3;
    private ImageView goose4;
    private ImageView goose5;
    private ImageView goose6;
    private ImageView goose7;
    private ImageView goose8;
    private ImageView goose9;
    private ImageView goose10;
    private ImageView goose11;
    private ImageView goose12;
    private ImageView goose13;

    private ImageView a3_free;
    private ImageView a4_free;
    private ImageView a5_free;
    private ImageView b3_free;
    private ImageView b4_free;
    private ImageView b5_free;
    private ImageView c1_free;
    private ImageView c2_free;
    private ImageView c3_free;
    private ImageView c4_free;
    private ImageView c5_free;
    private ImageView c6_free;
    private ImageView c7_free;
    private ImageView d1_free;
    private ImageView d2_free;
    private ImageView d3_free;
    private ImageView d4_free;
    private ImageView d5_free;
    private ImageView d6_free;
    private ImageView d7_free;
    private ImageView e1_free;
    private ImageView e2_free;
    private ImageView e3_free;
    private ImageView e4_free;
    private ImageView e5_free;
    private ImageView e6_free;
    private ImageView e7_free;
    private ImageView f3_free;
    private ImageView f4_free;
    private ImageView f5_free;
    private ImageView g3_free;
    private ImageView g4_free;
    private ImageView g5_free;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        currentCoordinates = new Coordinates();

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        float x0 = metrics.widthPixels/2;
        float y0 = metrics.heightPixels/2;

        Initialization();

        serviceInfoView.setText(
                "fox_X = " + fox.getX()+
                        "\n" +"fox_Y = "+fox.getY());




        fox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fox.setX(x0);
                fox.setY(y0);


                serviceInfoView.setText(
                        "fox_X = " + fox.getX()+
                                "\n" +"fox_Y = "+fox.getY());
            }
        });

    }

    public void Move(ImageView view, float[] field){
        view.setX(field[0]);
        view.setY(field[1]);
    }

    public void Initialization(){
        serviceInfoView = findViewById(R.id.serviceInfo);
        //fieldImageView = findViewById(R.id.fieldImageView);

        fox = findViewById(R.id.foxImageView);
        goose1 = findViewById(R.id.gooseImageView1);
        goose2 = findViewById(R.id.gooseImageView2);
        goose3 = findViewById(R.id.gooseImageView3);
        goose4 = findViewById(R.id.gooseImageView4);
        goose5 = findViewById(R.id.gooseImageView5);
        goose6 = findViewById(R.id.gooseImageView6);
        goose7 = findViewById(R.id.gooseImageView7);
        goose8 = findViewById(R.id.gooseImageView8);
        goose9 = findViewById(R.id.gooseImageView9);
        goose10 = findViewById(R.id.gooseImageView10);
        goose11 = findViewById(R.id.gooseImageView11);
        goose12 = findViewById(R.id.gooseImageView12);
        goose13 = findViewById(R.id.gooseImageView13);

        a3_free = findViewById(R.id.a3_free);
        a4_free = findViewById(R.id.a4_free);
        a5_free = findViewById(R.id.a5_free);

        b3_free = findViewById(R.id.b3_free);
        b4_free = findViewById(R.id.b4_free);
        b5_free = findViewById(R.id.b5_free);

        c1_free = findViewById(R.id.c1_free);
        c2_free = findViewById(R.id.c2_free);
        c3_free = findViewById(R.id.c3_free);
        c4_free = findViewById(R.id.c4_free);
        c5_free = findViewById(R.id.c5_free);
        c6_free = findViewById(R.id.c6_free);
        c7_free = findViewById(R.id.c7_free);

        d1_free = findViewById(R.id.d1_free);
        d2_free = findViewById(R.id.d2_free);
        d3_free = findViewById(R.id.d3_free);
        d4_free = findViewById(R.id.d4_free);
        d5_free = findViewById(R.id.d5_free);
        d6_free = findViewById(R.id.d6_free);
        d7_free = findViewById(R.id.d7_free);

        e1_free = findViewById(R.id.e1_free);
        e2_free = findViewById(R.id.e2_free);
        e3_free = findViewById(R.id.e3_free);
        e4_free = findViewById(R.id.e4_free);
        e5_free = findViewById(R.id.e5_free);
        e6_free = findViewById(R.id.e6_free);
        e7_free = findViewById(R.id.e7_free);

        f3_free = findViewById(R.id.f3_free);
        f4_free = findViewById(R.id.f4_free);
        f5_free = findViewById(R.id.f5_free);

        g3_free = findViewById(R.id.g3_free);
        g4_free = findViewById(R.id.g4_free);
        g5_free = findViewById(R.id.g5_free);




        Move(fox, currentCoordinates.d5);
        Move(goose1, currentCoordinates.a3);
        Move(goose2, currentCoordinates.b3);
        Move(goose3, currentCoordinates.c3);
        Move(goose4, currentCoordinates.d3);
        Move(goose5, currentCoordinates.e3);
        Move(goose6, currentCoordinates.f3);
        Move(goose7, currentCoordinates.g3);
        Move(goose8, currentCoordinates.c2);
        Move(goose9, currentCoordinates.d2);
        Move(goose10, currentCoordinates.e2);
        Move(goose11, currentCoordinates.c1);
        Move(goose12, currentCoordinates.d1);
        Move(goose13, currentCoordinates.e1);

        Move(a3_free, currentCoordinates.a3);
        Move(a4_free, currentCoordinates.a4);
        Move(a5_free, currentCoordinates.a5);

        Move(b3_free, currentCoordinates.b3);
        Move(b4_free, currentCoordinates.b4);
        Move(b5_free, currentCoordinates.b5);

        Move(c1_free, currentCoordinates.c1);
        Move(c2_free, currentCoordinates.c2);
        Move(c3_free, currentCoordinates.c3);
        Move(c4_free, currentCoordinates.c4);
        Move(c5_free, currentCoordinates.c5);
        Move(c6_free, currentCoordinates.c6);
        Move(c7_free, currentCoordinates.c7);

        Move(d1_free, currentCoordinates.d1);
        Move(d2_free, currentCoordinates.d2);
        Move(d3_free, currentCoordinates.d3);
        Move(d4_free, currentCoordinates.d4);
        Move(d5_free, currentCoordinates.d5);
        Move(d6_free, currentCoordinates.d6);
        Move(d7_free, currentCoordinates.d7);

        Move(e1_free, currentCoordinates.e1);
        Move(e2_free, currentCoordinates.e2);
        Move(e3_free, currentCoordinates.e3);
        Move(e4_free, currentCoordinates.e4);
        Move(e5_free, currentCoordinates.e5);
        Move(e6_free, currentCoordinates.e6);
        Move(e7_free, currentCoordinates.e7);

        Move(f3_free, currentCoordinates.f3);
        Move(f4_free, currentCoordinates.f4);
        Move(f5_free, currentCoordinates.f5);

        Move(g3_free, currentCoordinates.g3);
        Move(g4_free, currentCoordinates.g4);
        Move(g5_free, currentCoordinates.g5);
        }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}