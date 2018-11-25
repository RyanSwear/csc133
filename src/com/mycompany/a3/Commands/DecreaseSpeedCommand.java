package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorldProxy;

public class DecreaseSpeedCommand extends Command{
	private GameWorldProxy gw;
	public DecreaseSpeedCommand(GameWorldProxy gw)
	{
		super("DecreaseSpeed");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getKeyEvent()!= -1)
		{
			gw.decreasePlayerSpeed();
			System.out.println("Decrease Speed Invoked");
		}
		
	}
}
