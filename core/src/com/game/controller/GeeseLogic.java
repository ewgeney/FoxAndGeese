package com.game.controller;

import static com.game.Main.gameStarted;
import static com.game.view.GameScreen.field;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;

public class GeeseLogic{
    private Polygon gooseBounds;
    private int index;
    private float chipWidth;
    private float chipHeight;
    private int gameStFlag=0;

    public GeeseLogic(Polygon gooseBounds, Sprite gooseObject, int index) {
        this.gooseBounds = gooseBounds;
        this.chipWidth = gooseObject.getWidth()/2;
        this.chipHeight = gooseObject.getHeight()/2;
        this.index = index;

    }
    private void setPosition(Polygon chip, float[] position){
        chip.setPosition(position[0]-chipWidth, position[1]-chipHeight);
    }

    public void handler() {

        if(gameStarted & gameStFlag==0){
            gameStFlag=1;

            if(index == 0){
                setPosition(gooseBounds, field.getA5());
            }
            else if(index==1){
                setPosition(gooseBounds, field.getB5());
            }
            else if(index==2){
                setPosition(gooseBounds, field.getC5());
            }
            else if(index==3){
                setPosition(gooseBounds, field.getD5());
            }
            else if(index==4){
                setPosition(gooseBounds, field.getE5());
            }
            else if(index==5){
                setPosition(gooseBounds, field.getF5());
            }
            else if(index==6){
                setPosition(gooseBounds, field.getG5());
            }
            else if(index==7){
                setPosition(gooseBounds, field.getC6());
            }
            else if(index==8){
                setPosition(gooseBounds, field.getC7());
            }
            else if(index==9){
                setPosition(gooseBounds, field.getD6());
            }
            else if(index==10){
                setPosition(gooseBounds, field.getD7());
            }
            else if(index==11){
                setPosition(gooseBounds, field.getE6());
            }
            else if(index==12){
                setPosition(gooseBounds, field.getE7());
            }
        }
    }
/*    public class GeeseInputListener extends InputAdapter {

        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            //определяем нажатие на фишку
            if((screenX>gooseBounds.getX()-72)&(screenX<gooseBounds.getX()+72)&
                    ((Gdx.graphics.getHeight() - screenY)<gooseBounds.getY()+72)&
                    ((Gdx.graphics.getHeight() - screenY)>gooseBounds.getY()-72)) {
                //Если попал двигаем в новую позицию
                float[] position = new float[]{screenX, Gdx.graphics.getHeight() - screenY};
                setPosition(gooseBounds, position);
                return true;
            }
            else return false;
        }
    }*/
}
