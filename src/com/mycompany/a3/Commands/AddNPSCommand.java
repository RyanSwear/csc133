package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;
import com.mycompany.a3.GameWorldProxy;

public class AddNPSCommand extends Command{
	private GameWorldProxy gw;
	public AddNPSCommand(GameWorldProxy gw)
	{
		super("Add NP Ship");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getKeyEvent()!= -1)
		{
			gw.addNPS();
			System.out.println("Added NonPlayer Ship");
		}
		
	}
}
