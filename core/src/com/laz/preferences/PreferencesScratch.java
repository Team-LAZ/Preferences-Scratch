package com.laz.preferences;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

//everything happens in the PreferencesScreen class
public class PreferencesScratch extends Game {

    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        this.setScreen(new PreferencesScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    public void dispose() {
        batch.dispose();
    }
}
