package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorldProxy;

public class ClockTickCommand extends Command {
	private GameWorldProxy gw;
	public ClockTickCommand(GameWorldProxy gw)
	{
		super("TickClock");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getKeyEvent()!= -1)
		{
			gw.tickClock(1000);
			System.out.println("Clock Tick Invoked");
		}
		
	}
}
