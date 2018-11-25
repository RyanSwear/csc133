package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

public class PlayerMissileLauncher extends MissileLauncher implements ISteerable {

	PlayerMissileLauncher()
	{
		setSpeed(0);
		setDirection(0);
		setLocation(512,384);
		
	}
	@Override
	public void steerLeft() {
		// TODO Auto-generated method stub
		if (getDirection() >= 30)
		{
			setDirection(getDirection() - 30);
		}
		else
		{
			setDirection(getDirection() + 360 - 30);
		}
	}

	@Override
	public void steerRight() {
		// TODO Auto-generated method stub
		if (getDirection() <= 329)
		{
			setDirection(getDirection() + 30);
		}
		else
		{
			setDirection(getDirection() - 360 + 30);
		}
	}
	@Override
	public void draw(Graphics g, Point2D pCmpRelPrnt) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void handleCollision(GameObject o) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

}
