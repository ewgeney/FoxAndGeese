package com.game.controller;

import static com.game.Main.gameStarted;
import static com.game.view.GameScreen.field;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;

public class FoxLogic {
    private Polygon foxBounds;
    float halfChipWidth;
    float halfChipHeight;
    int gameStFlag=0;
    private final int fox=2;

    public FoxLogic(Polygon foxBounds, Sprite foxObject) {
        this.foxBounds = foxBounds;
        halfChipWidth = foxObject.getWidth()/2;
        halfChipHeight = foxObject.getHeight()/2;
    }
    private void setPosition(Polygon chip, float[] position){
        chip.setPosition(position[0]- halfChipWidth, position[1]- halfChipHeight);
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
        int xTouch;
        int yTouch;

        int xFox = (int) foxBounds.getX()+ (int) halfChipWidth;
        int yFox = (int) foxBounds.getY()+ (int) halfChipHeight; //центр фишки

        int area = 72; //область пикселей вокруг центра фишки

        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            //определяем нажатие на фишку
            xTouch = screenX;
            yTouch = Gdx.graphics.getHeight()-screenY; //инверсия по оси У


            if (xTouch > xFox - area & xTouch < xFox + area &
                yTouch > yFox - area & yTouch < yFox + area) {
                //Если попал двигаем в новую позицию


                float[][] allVertices = field.getAllVertices();
                float [] curPos = {xFox, yFox}; //текущая позиция фишки

                // проверка в какую позицию нужно переместить

                for(int i = 0; i < allVertices.length; i++){
                    xTouch = screenX;
                    yTouch = Gdx.graphics.getHeight()-screenY;
                    if(xTouch < allVertices[i][0]+150 & xTouch > allVertices[i][0]-150
                     & yTouch < allVertices[i][1]+150 & yTouch > allVertices[i][1]-150)
                    {

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
