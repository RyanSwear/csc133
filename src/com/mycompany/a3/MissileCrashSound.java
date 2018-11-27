package com.mycompany.a3;

import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class MissileCrashSound {
	private Media m;
	public MissileCrashSound()
	{
		try {
			InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/mCrash.wav");
			m = MediaManager.createMedia(is, "audio/wav");
		}catch(Exception e) {e.printStackTrace();}
	}
	
	public void play()
	{
		m.setTime(0);
		m.play();
	}
}
