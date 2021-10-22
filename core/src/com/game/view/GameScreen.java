package com.game.view;

import static com.game.Main.gameStarted;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.game.controller.FoxLogic;
import com.game.model.Fox;
import com.game.model.Goose;

public class GameScreen implements Screen {
    ShapeRenderer shapeRenderer;
    SpriteBatch batch;
    Texture foxTexture;
    Texture geeseTexture;
    Fox fox;
    Goose[] geese;
    public static Field field;


    @Override
    public void show() {
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        foxTexture = new Texture("fox.png");
        geeseTexture = new Texture("goose.png");
        field = new Field();

        fox = new Fox(foxTexture, 0, 0, 72, 72);

        geese = new Goose[13];
        for(int i=0; i < geese.length; i++){
            geese[i] = new Goose(i, geeseTexture, 0, 0, 72, 72);
        }
    }

    @Override
    public void render(float delta) {

        /*int firstX = Gdx.input.getX();
        int firstY = Gdx.input.getY();*/

        if(Gdx.input.isTouched()){
            gameStarted = true;}

        Gdx.gl.glClearColor(255,255,255,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(0, 0, 0, 1);
        shapeRenderer.polyline(field.getVerticesField());
        shapeRenderer.end();

        batch.begin();
        fox.draw(batch);
        for(int i=0; i<geese.length; i++){
            geese[i].draw(batch);
        }
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
