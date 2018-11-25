package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorldProxy;

public class AddSpaceStationCommand extends Command{
	private GameWorldProxy gw;
	public AddSpaceStationCommand(GameWorldProxy gw)
	{
		super("AddSpaceStation");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getKeyEvent()!= -1)
		{
			gw.addStation();
			System.out.println("Added Space Station");
		}
		
	}
}
