package com.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.Main;
import com.game.model.LooseMessages;
import com.game.model.StartButton;
import com.game.model.ExitButton;
import com.game.model.WinMessages;

public class MenuScreen implements Screen {
    private Main game;
    private SpriteBatch batch;
    private Texture startButtonTexture;
    public StartButton startButton;
    private Texture exitButtonTexture;
    private ExitButton exitButton;
    private Texture winMessagesTexture;
    private WinMessages winMessages;
    private Texture looseMessagesTexture;
    private LooseMessages looseMessages;

    public MenuScreen(Main game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        startButtonTexture = new Texture("play.png");
        exitButtonTexture = new Texture("exit.png");
        winMessagesTexture = new Texture("you_win.png");
        looseMessagesTexture = new Texture("game_over.png");

        startButton = new StartButton(startButtonTexture, Gdx.graphics.getWidth()/2-277, Gdx.graphics.getHeight()/2-70,
                277*2, 70*2);
        exitButton = new ExitButton(exitButtonTexture, Gdx.graphics.getWidth()/2-277, Gdx.graphics.getHeight()/2-70*4,
                277*2, 70*2);
        winMessages = new WinMessages(winMessagesTexture, Gdx.graphics.getWidth()/2-252, Gdx.graphics.getHeight()/2+147*2,
                252*2, 147*2);
        looseMessages = new LooseMessages(looseMessagesTexture, Gdx.graphics.getWidth()/2-252, Gdx.graphics.getHeight()/2+147*2,
                252*2, 147*2);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255,255,255,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        startButton.draw(batch);
        exitButton.draw(batch);
        switch (game.flag){
            case 1:
                winMessages.draw(batch);
                break;
            case 2:
                looseMessages.draw(batch);
                break;
        }
        batch.end();
        Gdx.input.setInputProcessor(new ButtonListener());
    }
    public class ButtonListener extends InputAdapter {
        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            if ((screenX > startButton.bounds.getX()) & (screenX < startButton.bounds.getX() + startButton.object.getWidth()) &
                    ((Gdx.graphics.getHeight() - screenY) < startButton.bounds.getY() + startButton.object.getHeight()) &
                    ((Gdx.graphics.getHeight() - screenY) > startButton.bounds.getY())) {

                game.setScreen(game.getGameScreen());
                return true;
            }
            if ((screenX > exitButton.bounds.getX()) & (screenX < exitButton.bounds.getX() + exitButton.object.getWidth()) &
                    ((Gdx.graphics.getHeight() - screenY) < exitButton.bounds.getY() + exitButton.object.getHeight()) &
                    ((Gdx.graphics.getHeight() - screenY) > exitButton.bounds.getY())) {

                Gdx.app.exit();
            }
            return false;
        }
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
        batch.dispose();
    }
}
