package de.tomgrill.temp.netjavaimpl.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import de.tomgrill.temp.netjavaimpl.NetJavaImplProblemExample;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new NetJavaImplProblemExample(), config);
	}
}
