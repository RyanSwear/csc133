package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorldProxy;

public class HyperspaceCommand extends Command{
	private GameWorldProxy gw;
	public HyperspaceCommand(GameWorldProxy gw)
	{
		super("Hyperscpace Command");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getKeyEvent()!= -1)
		{
			gw.jumpToHyperSpace();
			System.out.println("Hyperspace command invoked");
		}
		
	}
}
