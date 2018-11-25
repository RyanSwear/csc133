package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorldProxy;

public class RotateGunRightCommand extends Command{
	private GameWorldProxy gw;
	public RotateGunRightCommand(GameWorldProxy gw)
	{
		super("RotateGunRight");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getKeyEvent()!= -1)
		{
			gw.turnMissileLauncherRight();
			System.out.println("RotateGunRight command invoked");
		}
		
	}
}
