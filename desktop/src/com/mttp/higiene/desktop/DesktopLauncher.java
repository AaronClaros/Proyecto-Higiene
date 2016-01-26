package com.mttp.higiene.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import com.mttp.higiene.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1080;
		config.height = 720;
		config.title = "Aprendamos Juntos";
		config.resizable = false;

		new LwjglApplication(new Main(), config);
	}
}
