package com.mycompany.a3;

import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;
import com.codename1.ui.util.UITimer;

public class BGSound implements Runnable{
	private Media m;
	
	public BGSound(String fileName)
	{
		
		try {
			InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/" + fileName);
			m = MediaManager.createMedia(is, "audio/wav", this);
		
		}catch(Exception e) {e.printStackTrace();}
	}
	
	public void run()
	{
		
			m.setTime(0);
			m.play();
		
		//m.play();
		
	}
	public void stop()
	{
		m.pause();
	}
}
