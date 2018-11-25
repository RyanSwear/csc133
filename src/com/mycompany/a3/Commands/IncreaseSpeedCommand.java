package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorldProxy;

public class IncreaseSpeedCommand extends Command{
	private GameWorldProxy gw;
	public IncreaseSpeedCommand(GameWorldProxy gw)
	{
		super("IncreaseSpeed");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getKeyEvent()!= -1)
		{
			gw.increasePlayerSpeed();
			System.out.println("Increase Speed Invoked");
		}
		
	}
}
