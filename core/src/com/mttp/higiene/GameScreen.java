package com.mttp.higiene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.TimeUtils;
import com.mttp.actors.TitleActor;

import java.util.ArrayList;

/**
 * Created by Kevin on 30/12/2015.
 */
public class GameScreen extends AbstractScreen {

    private Stage stage;
    private long beginTime;
    private int actualImgIndex;

    private ArrayList<String> titlesList;
    private TitleActor imageTitle;
    private BitmapFont font;

    public ArrayList<Texture> texturesList;
    private Image imgActor;
    //private ArrayList<ImageButton> buttonList;

    public GameScreen(Main game){
        super(game);
    }

    //Metodo para preparar los elementos de la fase de Muestreo de Imagenes
    private void SetupShowStage(){
        texturesList = new ArrayList<Texture>();

        texturesList.add(new Texture("img_1.png"));
        texturesList.add(new Texture("img_2.png"));
        texturesList.add(new Texture("img_3.png"));
        texturesList.add(new Texture("img_4.png"));
        texturesList.add(new Texture("img_5.png"));
        texturesList.add(new Texture("img_6.png"));
        texturesList.add(new Texture("img_7.png"));
        texturesList.add(new Texture("img_8.png"));

        imgActor = new Image(texturesList.get(0));
        stage.addActor(imgActor);
        CenterImgActorToScreen(imgActor);

        titlesList = new ArrayList<String>();

        titlesList.add("Cojo el cepillo");
        titlesList.add("Me cepillo los dientes");
        titlesList.add("Me enjuago la boca");
        titlesList.add("Escupo el agua");
        titlesList.add("Abro el grifo y limpio");
        titlesList.add("Me lavo las manos");
        titlesList.add("Cierro el grifo");
        titlesList.add("Me seco las manos");

        font = new BitmapFont();
        imageTitle = new TitleActor(font);
        SetFontTextCenter(imageTitle,titlesList.get(0));
        font.getData().setScale(1f, 1f);
        stage.addActor(imageTitle);


    }
    //Metodo para preparar los elemento de la fase de preguntas del juego
    public void SetupGameStage(){

    }

    @Override
    public void show() {
        beginTime = TimeUtils.millis();
        actualImgIndex = 0;
        stage = new Stage();
        SetupShowStage();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Texture newTexture = SwapTextureFromArray(texturesList, actualImgIndex, beginTime, 3);
        imgActor.setDrawable(new SpriteDrawable(new Sprite(newTexture)));


        stage.act();
        stage.draw();


    }

    //Metodo que devuelve una textura de un Arraylist cada X tiempo (intervalTime).
    private Texture SwapTextureFromArray(ArrayList<Texture> list, int startIndex, long startTime, float intervalTime){
        Texture img = null;
        if(startIndex < list.size()){
            if (TimeUtils.timeSinceMillis(startTime)<intervalTime*1000){
                img = list.get(startIndex);
                if (startIndex < titlesList.size()){
                    imageTitle.ChangeFontText(titlesList.get(startIndex));
                }
            }
            else {
                actualImgIndex++;
                beginTime=TimeUtils.millis();
                img = list.get(startIndex);
                imageTitle.ChangeFontText(titlesList.get(startIndex));
            }
        } else {
            img = list.get(texturesList.size()-1);
        }
        return img;
    }

    //Metodo que acomoda las imagenes hacia el centro de la pantalla
    private void CenterImgActorToScreen(Image act){
        int actPosX = Gdx.graphics.getWidth()/2 - (int)act.getWidth()/2;
        int actPosY = Gdx.graphics.getHeight()/2 - (int)act.getHeight()/2;
        act.setPosition(actPosX, actPosY);
    }
    //Metodo que acomoda el texto al centro y arriba de la pantalla
    private void SetFontTextCenter(TitleActor fontActor, String text){
        imageTitle.ChangeFontText(titlesList.get(0));
        GlyphLayout layout = new GlyphLayout();
        layout.setText(fontActor.GetFont(),text);
        float textX = (Gdx.graphics.getWidth()/2) - (layout.width / 2);
        float textY = layout.height + (Gdx.graphics.getHeight()-50f);
        fontActor.setPosition(textX, textY);
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }

}
