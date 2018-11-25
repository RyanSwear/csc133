package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorldProxy;

public class NewCommand extends Command{
	private GameWorldProxy gw;
	public NewCommand(GameWorldProxy gw)
	{
		super("New");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
			gw.newGame();
			System.out.println("New Game Created");
		
		
	}
}
