package com.laz.preferences;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

//https://github.com/libgdx/libgdx/wiki/Preferences

//integer is loaded from a file called preferencesScratch
public class PreferencesScreen implements Screen {

    final PreferencesScratch preferencesScratch;
    OrthographicCamera camera;
    Stage stage;
    BitmapFont font;
    Skin skin;
    Pixmap pixmap;
    TextButtonStyle textButtonStyle;
    TextButton btnAttack;

    Preferences pref;
    int nAttack;

    public PreferencesScreen(final PreferencesScratch preferencesScratch) {
        this.preferencesScratch = preferencesScratch;

        //gets preferences file
        pref = Gdx.app.getPreferences("preferencesScratch");
        //gets the attack integer from the preferences file
        nAttack = pref.getInteger("attack");
        System.out.println("ATTACK @ LOAD: " + nAttack);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Data.WIDTH, Data.HEIGHT);

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        font = new BitmapFont();

        skin = new Skin();
        skin.add("default", font);

        pixmap = new Pixmap(Data.WIDTH / 4, Data.HEIGHT / 10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add("background", new Texture(pixmap));

        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("background", Color.GRAY);
        textButtonStyle.down = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);

        btnAttack = new TextButton("Level Up Attack", skin);
        btnAttack.setPosition(Data.WIDTH / 2 - Data.WIDTH / 8, Data.HEIGHT / 2 + 75);
        stage.addActor(btnAttack);

        btnAttack.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                levelAttack();
            }
        });
    }

    public void levelAttack() {
        nAttack++;
        System.out.println(nAttack);
        //puts the integer attack into preferences file
        pref.putInteger("attack", nAttack);
        //saves the data
        pref.flush();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        preferencesScratch.batch.setProjectionMatrix(camera.combined);

        preferencesScratch.batch.begin();
        preferencesScratch.batch.end();

        stage.act();
        stage.draw();
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

    }
}
