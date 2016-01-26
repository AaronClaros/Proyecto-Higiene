package com.mttp.higiene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.mttp.actors.TitleActor;


/**
 * Created by Kevin on 30/12/2015.
 */
public class MainMenu extends AbstractScreen {

    private Stage stage;
    private SpriteDrawable imageButton1;
    private SpriteDrawable imageButton2;

    private ImageButton buttonScene1;
    private ImageButton buttonScene2;

    private BitmapFont font;
    private TitleActor fontActor;

    public MainMenu(Main game){
        super(game);

    }

    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        imageButton1 = new SpriteDrawable(new Sprite(new Texture("img_1.png")));
        buttonScene1 = new ImageButton(imageButton1);
        buttonScene1.setPosition(45, 135);
        stage.addActor(buttonScene1);

        imageButton2 = new SpriteDrawable(new Sprite(new Texture("img_11.png")));
        buttonScene2 = new ImageButton(imageButton2);
        buttonScene2.setPosition(565, 135);
        stage.addActor(buttonScene2);

        buttonScene1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Button 1 was pressed");
                game.setScreen(game.scene1);
            }
        });
        buttonScene2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.print("Button 2 was pressed");
                game.setScreen(game.scene2);
            }
        });

        font = new BitmapFont();
        fontActor = new TitleActor(font, "ESCOJE UNA ACTIVIDAD");
        GlyphLayout layout = new GlyphLayout();
        layout.setText(fontActor.GetFont(),"ESCOJE UNA ACTIVIDAD");
        float textX = (Gdx.graphics.getWidth()/2) - (layout.width / 2);
        float textY = layout.height + (Gdx.graphics.getHeight()-50f);
        fontActor.setPosition(textX, textY);
        stage.addActor(fontActor);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }

}
