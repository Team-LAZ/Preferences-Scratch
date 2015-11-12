package com.laz.preferences;

import com.badlogic.gdx.Game;

//everything happens in the PreferencesScreen class
public class PreferencesScratch extends Game {

    @Override
    public void create() {
        setScreen(new PreferencesScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }
}
