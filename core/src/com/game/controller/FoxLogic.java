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

public class FoxLogic {
    private Polygon foxBounds;
    float chipWidth;
    float chipHeight;
    int gameStFlag=0;
    private final int fox=2;

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
            setPosition(foxBounds, field.getD3());
            field.board[field.D3]=fox;
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


                float[][] allVertices = field.getAllVertices();
                float [] curPos = {foxBounds.getX()+chipWidth, foxBounds.getY()+chipHeight}; //текущая позиция фишки

                // проверка в какую позицию нужно переместить
                int x = screenX;
                int y = Gdx.graphics.getHeight() - screenY;

                for(int i = 0; i < allVertices.length; i++){
                    if(x < allVertices[i][0]+100 & x > allVertices[i][0]-100
                     & y < allVertices[i][1]+100 & y > allVertices[i][1]-100){

                        setPosition(foxBounds, new float[]{allVertices[i][0], allVertices[i][1]});
                        break;
                    }
                    else {
                        setPosition(foxBounds, curPos);
                    }
                }
                return true;


                //проверка не занята ли позиция


                //проверка что позиция на 1 шаге от текущей
                


            }
            else return false;

        }
    }
}
