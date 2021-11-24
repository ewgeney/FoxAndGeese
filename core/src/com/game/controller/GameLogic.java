package com.game.controller;

import static com.game.view.GameScreen.field;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;

public abstract class GameLogic {
    protected Polygon bounds;
    protected float chipWidth;
    protected float chipHeight;
    protected int indexOnField;
    protected int index;
    protected boolean newGame = true;
    protected final int empPos = -1;

    public GameLogic(Polygon bounds, Sprite object, int index) {
        this.bounds = bounds;
        this.chipWidth = object.getWidth();
        this.chipHeight = object.getHeight();
        this.index = index;
    }
    protected void setPosition(Polygon chip, int position){
        chip.setPosition(field.getAllVertices()[position][0]-chipWidth/2,
                field.getAllVertices()[position][1]-chipHeight/2);
    }

    //вычисляем текущий индекс положения на поле
    protected void getIndexOnField(int index) {
        for (int i = 0; i < field.board.size(); i++) {
            if (field.board.get(i) == index) {
                indexOnField = i;
                break;
            }
        }
    }
}
