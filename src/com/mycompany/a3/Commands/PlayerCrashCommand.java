package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorldProxy;

public class PlayerCrashCommand extends Command{
	private GameWorldProxy gw;
	public PlayerCrashCommand(GameWorldProxy gw)
	{
		super("PlayerCrash");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getKeyEvent()!= -1)
		{
			gw.playerAsteroidCrash();
			gw.playerCrashNPS();
			gw.psHitByMissile();
			System.out.println("PlayerCrash invoked");
		}
		
	}
}
