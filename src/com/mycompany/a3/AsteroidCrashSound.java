package com.mycompany.a3;

import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class AsteroidCrashSound {
	private Media m;
	public AsteroidCrashSound()
	{
		try {
			InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/asteroidExplosion.wav");
			m = MediaManager.createMedia(is, "audio/wav");
		}catch(Exception e) {e.printStackTrace();}
	}
	
	public void play()
	{
		m.setTime(0);
		m.play();
	}
}
