package com.mttp.higiene;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;

public class Main extends Game {

	@Override
	public void create () {
        setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	/*
		Gdx.gl.glClearColor(1f, 1f, 1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		int imgPosX = Gdx.graphics.getWidth()/2 - mainImg.getWidth()/2;
		int imgPosY = Gdx.graphics.getHeight()/2 - mainImg.getHeight()/2;
		batch.draw(mainImg, imgPosX, imgPosY);
		batch.end();

		if (TimeUtils.timeSinceMillis(startTime)>showTime*1000){
			if (i < texturesList.size()) {
				mainImg = texturesList.get(i);
				i++;
			} else {
				i=0;
				mainImg = texturesList.get(i);
				i=1;
			}
			startTime = TimeUtils.millis();
		}
	*/
	}

	@Override
	public void dispose() {

	}
}
