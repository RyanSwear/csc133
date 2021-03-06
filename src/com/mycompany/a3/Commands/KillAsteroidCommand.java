package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorldProxy;

public class KillAsteroidCommand extends Command {
	private GameWorldProxy gw;
	public KillAsteroidCommand(GameWorldProxy gw)
	{
		super("Kill Asteroid");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getKeyEvent()!= -1)
		{
			gw.missileAsteroidCrash();
			System.out.println("KillAsteroid invoked");
		}
		
	}
}
