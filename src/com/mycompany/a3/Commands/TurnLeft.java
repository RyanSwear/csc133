package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorldProxy;

public class TurnLeft extends Command{
	private GameWorldProxy gw;
	public TurnLeft(GameWorldProxy gw)
	{
		super("TurnLeft");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getKeyEvent()!= -1)
		{
			gw.playerShipTurnLeft();
			System.out.println("Turn Left invoked");
		}
		
	}
}
