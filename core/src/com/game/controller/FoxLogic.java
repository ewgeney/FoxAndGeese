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
import com.game.view.Field;
import com.game.view.GameScreen;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class FoxLogic {
    private Polygon foxBounds;
    float chipWidth;
    float chipHeight;
    int gameStFlag=0;
    private final int fox=2;

    public FoxLogic(Polygon foxBounds, Sprite foxObject) {
        this.foxBounds = foxBounds;
        chipWidth = foxObject.getWidth();
        chipHeight = foxObject.getHeight();
    }
    private void setPosition(Polygon chip, float[] position){
        chip.setPosition(position[0]-chipWidth/2, position[1]-chipHeight/2);
    }

    public void handler(){
        Gdx.input.setInputProcessor(new FoxInputListener());

        if (gameStarted & gameStFlag==0){
            setPosition(foxBounds, field.getD3());
            field.board[field.D3]=fox;
            gameStFlag = 1;
        }
    }
    public class FoxInputListener extends InputAdapter {

        float[][] allVertices = field.getAllVertices();

        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            //определяем нажатие на фишку, если попал двигаем в новую позицию
            if ((screenX > foxBounds.getX() - chipWidth) & (screenX < foxBounds.getX() + chipWidth) &
                    ((Gdx.graphics.getHeight() - screenY) < foxBounds.getY() + chipHeight) &
                    ((Gdx.graphics.getHeight() - screenY) > foxBounds.getY() - chipHeight)) {

                setPosition(foxBounds, new float[]{screenX, Gdx.graphics.getHeight() - screenY});

            }
            return false;

        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            float [] curPos = {foxBounds.getX()+chipWidth, foxBounds.getY()+chipHeight};
            //текущая позиция центра фишки

            for(int i = 0; i < allVertices.length; i++){
                if(curPos[0] < allVertices[i][0]+field.getStep()/2 & curPos[0] > allVertices[i][0]-field.getStep()/2
                 & curPos[1] < allVertices[i][1]+field.getStep()/2 & curPos[1] > allVertices[i][1]-field.getStep()/2){

                    setPosition(foxBounds, new float[]{allVertices[i][0], allVertices[i][1]});
                    return true;
                }
                /*else {
                    setPosition(foxBounds, curPos);
                    return true;
                }*/
            }
            return false;

            //проверка не занята ли позиция

            //проверка что позиция на 1 шаге от текущей
        }
    }
}
