package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorldProxy;

public class LoadAmmoCommand extends Command{
	private GameWorldProxy gw;
	public LoadAmmoCommand(GameWorldProxy gw)
	{
		super("LoadAmmo");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getKeyEvent()!= -1)
		{
			gw.refillPSMissiles();
			System.out.println("LoadAmmo invoked");
		}
		
	}
}
