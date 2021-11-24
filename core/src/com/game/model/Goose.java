package com.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.game.Main;
import com.game.controller.GeeseLogic;

import java.util.ArrayList;

public class Goose extends GameObject{
    GeeseLogic geeseController;


    public Goose(int index, Texture texture, float x, float y, float width, float height, Main game) {
        super(texture, x, y, width, height);
        geeseController = new GeeseLogic(bounds, object, index, game);
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        geeseController.handler();
    }
}
