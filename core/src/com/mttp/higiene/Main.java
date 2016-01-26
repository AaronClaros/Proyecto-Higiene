package com.mttp.higiene;

import com.badlogic.gdx.Game;


public class Main extends Game {

	public ToothScreen scene1;
	public HandScreen scene2;
    public MainMenu mainScene;

	@Override
	public void create () {
		scene1 = new ToothScreen(this);
		scene2 = new HandScreen(this);
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
