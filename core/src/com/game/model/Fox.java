package com.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.controller.FoxLogic;

public class Fox extends GameObject {
    FoxLogic foxController;

    public Fox(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        foxController = new FoxLogic(bounds, object);
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        foxController.handler();
    }
}
