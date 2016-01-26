package com.mttp.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Kevin on 06/01/2016.
 */
public class TitleActor extends Actor {
    private BitmapFont font;
    private String text;

    public TitleActor(BitmapFont font, String text){
        this.font = font;
        this.text = text;
        font.setColor(0,0,0,1);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        font.draw(batch, text, getX(), getY());
    }

    public void ChangeFontText(String text){
        this.text = text;
    }

    public BitmapFont GetFont(){
        return font;
    }
}
