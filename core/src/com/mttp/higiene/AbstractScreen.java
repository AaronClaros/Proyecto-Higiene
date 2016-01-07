package com.mttp.higiene;

import com.badlogic.gdx.Screen;

/**
 * Created by Kevin on 30/12/2015.
 */
public abstract class AbstractScreen implements Screen {
    protected Main game;

    public AbstractScreen(Main game){
        this.game=game;
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
}
