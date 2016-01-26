package com.mttp.higiene;

import com.badlogic.gdx.Game;


public class Main extends Game {

	public GameScreen scene1;
	public GameScreen2 scene2;
    public MainMenu mainScene;

	@Override
	public void create () {
		scene1 = new GameScreen(this);
		scene2 = new GameScreen2(this);
        mainScene = new MainMenu(this);
        setScreen( mainScene );
	}

	@Override
	public void render () {
		super.render();

	}

	@Override
	public void dispose() {
	}
}
