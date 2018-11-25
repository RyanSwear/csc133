package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorldProxy;

public class TurnRight extends Command{
	private GameWorldProxy gw;
	public TurnRight(GameWorldProxy gw)
	{
		super("TurnRight");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getKeyEvent()!= -1)
		{
			gw.playerShipTurnRight();
			System.out.println("Turn Right invoked");
		}
		
	}
}
