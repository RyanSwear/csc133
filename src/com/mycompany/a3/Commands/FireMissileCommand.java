package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorldProxy;

public class FireMissileCommand extends Command {
	private GameWorldProxy gw;
	public FireMissileCommand(GameWorldProxy gw)
	{
		super("FireMissile");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getKeyEvent()!= -1)
		{
			gw.firePlayerMissile();
			System.out.println("Fire Missile Invoked");
		}
		
	}
}
