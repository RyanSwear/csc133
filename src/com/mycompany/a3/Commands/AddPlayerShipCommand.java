package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorldProxy;

public class AddPlayerShipCommand extends Command {
	private GameWorldProxy gw;
	public AddPlayerShipCommand(GameWorldProxy gw)
	{
		super("AddPShip");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getKeyEvent()!= -1)
		{
			gw.addPS();
			System.out.println("Added Player Ship");
		}
		
	}
}
