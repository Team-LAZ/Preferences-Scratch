package com.laz.preferences.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.laz.preferences.Data;
import com.laz.preferences.PreferencesScratch;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = Data.NAME;
        config.width = Data.WIDTH;
        config.height = Data.HEIGHT;
		new LwjglApplication(new PreferencesScratch(), config);
	}
}
