package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorldProxy;

public class RotateGunLeftCommand extends Command{
	private GameWorldProxy gw;
	public RotateGunLeftCommand(GameWorldProxy gw)
	{
		super("RotateGunL");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getKeyEvent()!= -1)
		{
			gw.turnMissileLauncherLeft();
			System.out.println("Rotate Gun Left Command invoked");
		}
		
	}
}
