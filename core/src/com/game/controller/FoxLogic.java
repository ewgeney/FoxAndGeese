package com.game.controller;

import static com.game.Main.gameStarted;
import static com.game.view.GameScreen.field;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.game.view.GameScreen;

import java.io.InputStream;

public class FoxLogic {
    private Polygon foxBounds;
    float chipWidth;
    float chipHeight;
    int gameStFlag=0;

    public FoxLogic(Polygon foxBounds, Sprite foxObject) {
        this.foxBounds = foxBounds;
        chipWidth = foxObject.getWidth()/2;
        chipHeight = foxObject.getHeight()/2;
    }
    private void setPosition(Polygon chip, float[] position){
        chip.setPosition(position[0]-chipWidth, position[1]-chipHeight);
    }

    public void handler(){
        Gdx.input.setInputProcessor(new FoxInputListener());

        if (gameStarted & gameStFlag==0){
            setPosition(foxBounds, field.getD4());
            gameStFlag = 1;
        }
    }
    public class FoxInputListener extends InputAdapter {

        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            //определяем нажатие на фишку
            if ((screenX > foxBounds.getX() - 72) & (screenX < foxBounds.getX() + 72) &
                    ((Gdx.graphics.getHeight() - screenY) < foxBounds.getY() + 72) &
                    ((Gdx.graphics.getHeight() - screenY) > foxBounds.getY() - 72)) {
                //Если попал двигаем в новую позицию
                float[] position = new float[]{screenX, Gdx.graphics.getHeight() - screenY};

                setPosition(foxBounds, position);
                return true;
            } else return false;
        }
    }
}
