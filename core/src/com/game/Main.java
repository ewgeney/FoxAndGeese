package com.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.game.view.GameScreen;

public class Main extends Game {
	private Screen gameScreen;
	public static boolean gameStarted = false;
	
	@Override
	public void create () {
		gameScreen = new GameScreen();
		setScreen(gameScreen);
	}
}
