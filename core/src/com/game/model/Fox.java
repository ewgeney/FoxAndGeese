package com.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.game.Main;
import com.game.controller.FoxLogic;

public class Fox extends GameObject {
    FoxLogic foxController;

    public Fox(int index, Texture texture, float x, float y, float width, float height, Main game) {
        super(texture, x, y, width, height);
        foxController = new FoxLogic(bounds, object, index, game);
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        foxController.handler();
    }
}
