package com.mycompany.a3.Commands;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorldProxy;

public class AsteroidCollisionCommand extends Command{
	private GameWorldProxy gw;
	public AsteroidCollisionCommand(GameWorldProxy gw)
	{
		super("AsteroidCollision");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getKeyEvent()!= -1)
		{
			gw.asteroidCrashAsteroid();
			gw.asteroidNPSCollision();
			gw.missileAsteroidCrash();
			gw.playerAsteroidCrash();
			System.out.println("AsteroidCollision invoked");
		}
		
	}
}
