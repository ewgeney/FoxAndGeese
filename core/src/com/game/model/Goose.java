package com.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.controller.GeeseLogic;

public class Goose extends GameObject{
    GeeseLogic geeseController;

    public Goose(int index, Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        geeseController = new GeeseLogic(bounds, object, index);
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        geeseController.handler();
    }
}
