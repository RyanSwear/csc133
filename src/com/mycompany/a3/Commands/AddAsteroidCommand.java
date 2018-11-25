package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;
import com.mycompany.a3.GameWorldProxy;

public class AddAsteroidCommand extends Command{
	private GameWorldProxy gw;
	public AddAsteroidCommand(GameWorldProxy gw)
	{
		super("AddAsteroid");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getKeyEvent()!= -1)
		{
			gw.addAsteroid();
			
			System.out.println("Added Asteroid");
		}
		
	}
}
