package com.laz.preferences.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.laz.preferences.Data;
import com.laz.preferences.PreferencesScratch;

public class HtmlLauncher extends GwtApplication {

    @Override
    public GwtApplicationConfiguration getConfig() {
        return new GwtApplicationConfiguration(Data.WIDTH, Data.HEIGHT);
    }

    @Override
    public ApplicationListener getApplicationListener() {
        return new PreferencesScratch();
    }
}