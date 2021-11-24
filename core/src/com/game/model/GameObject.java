package com.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Polygon;

import java.util.ArrayList;

abstract class GameObject{
    public Polygon bounds;
    public Sprite object;
    public ArrayList<Integer> arrayMoves;

    GameObject(Texture texture, float x, float y, float width, float height) {
        object = new Sprite(texture);
        object.setSize(width, height);
        object.setPosition(x, y);
        bounds = new Polygon(new float[]{0f, 0f, width, 0f, width, height, 0f, height});
        bounds.setPosition(x, y);
        arrayMoves = new ArrayList<>();
    }

    public void draw (Batch batch){
        object.setPosition(bounds.getX(), bounds.getY());
        object.draw(batch);
    }
}
