package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorldProxy;

public class AboutCommand extends Command{
	private GameWorldProxy gw;
	public AboutCommand(GameWorldProxy gw)
	{
		super("About");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
			System.out.println("Programmer: Ryan Swearingen\n Assignment2\n Asteroid Game ");
			System.out.println("About Command invoked");
		
		
	}
}
