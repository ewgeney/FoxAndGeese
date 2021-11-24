package com.game.view;

import static com.game.Main.gameStarted;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.game.Main;
import com.game.model.Field;
import com.game.model.Fox;
import com.game.model.Goose;

import java.util.HashMap;

public class GameScreen implements Screen {
    Main game;
    ShapeRenderer shapeRenderer;
    SpriteBatch batch;
    Texture foxTexture;
    Texture geeseTexture;
    public static Fox fox;
    public static HashMap<Integer, Goose> geese;
    public static Field field;
    public static boolean UserStep = true;
    public static Sound geeseMove;
    public static Sound foxMove;
    public static Sound win;
    public static Sound loose;

    public GameScreen(Main game) {
        this.game = game;
    }

    @Override
    public void show() {
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        foxTexture = new Texture("fox.png");
        geeseTexture = new Texture("goose.png");
        field = new Field();

        geese = new HashMap<>();
        for(int i=0; i < 13; i++){
            geese.put(i, new Goose(i, geeseTexture, 0, 0, 72, 72, game));
        }
        fox = new Fox(13, foxTexture, 0, 0, 72, 72, game);

        foxMove = Gdx.audio.newSound(Gdx.files.internal("fox_move.mp3"));
        geeseMove = Gdx.audio.newSound(Gdx.files.internal("geese_move.mp3"));
        win = Gdx.audio.newSound(Gdx.files.internal("win.mp3"));
        loose = Gdx.audio.newSound(Gdx.files.internal("loose.mp3"));
    }

    @Override
    public void render(float delta) {

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
        for(int i=0; i<13; i++){
            if(geese.get(i)!=null){
                geese.get(i).draw(batch);
            }
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
        shapeRenderer.dispose();
        batch.dispose();
        geeseMove.dispose();
        foxMove.dispose();
        win.dispose();
        loose.dispose();
    }
}
