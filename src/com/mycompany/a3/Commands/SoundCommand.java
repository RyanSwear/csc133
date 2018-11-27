package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.BGSound;
import com.mycompany.a3.GameWorldProxy;

public class SoundCommand extends Command{
	private GameWorldProxy gw;
	public SoundCommand(GameWorldProxy gw)
	{
		super("Change Sound");
		this.gw = gw;
		//BGSound sound = new BGSound("rg_hum.wav");
		
		
		//sound.run();
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
			gw.changeSound();
			System.out.println("Change Sound invoked");
		
		
	}
}
