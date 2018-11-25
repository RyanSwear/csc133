package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorldProxy;

public class QuitCommand extends Command{
	private GameWorldProxy gw;
	public QuitCommand(GameWorldProxy gw)
	{
		super("Quit");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
			gw.quit();
			System.out.println("Quit invoked");
		
		
	}
}
