package com.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.game.view.GameScreen;
import com.game.view.MenuScreen;

public class Main extends Game {
	private Screen gameScreen;
	private Screen menuScreen;
	public static boolean gameStarted = false;
	public int flag = 0;

	public Screen getGameScreen() {
		return gameScreen;
	}

	public Screen getMenuScreen() {
		return menuScreen;
	}
	
	@Override
	public void create () {
		gameScreen = new GameScreen(this);
		menuScreen = new MenuScreen(this);
		setScreen(menuScreen);
	}
}
