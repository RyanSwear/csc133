package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;
import java.lang.Math;

public class PlayerMissileLauncher extends MissileLauncher implements ISteerable {

	PlayerMissileLauncher()
	{
		setSpeed(0);
		setDirection(0);
		//setLocation(512,384);
		setColor(ColorUtil.WHITE);
	}
	@Override
	public void steerLeft() {
		// TODO Auto-generated method stub
		if (getDirection() >= 10)
		{
			setDirection(getDirection() - 10);
		}
		else
		{
			setDirection(getDirection() + 360 - 15);
		}
	}

	@Override
	public void steerRight() {
		// TODO Auto-generated method stub
		if (getDirection() < 350)
		{
			setDirection(getDirection() + 10);
		}
		else
		{
			setDirection(getDirection() - 360 + 10);
		}
	}
	@Override
	public void draw(Graphics g, Point2D point) {
		// TODO Auto-generated method stub
		double theta = (this.getDirection() - 90) * (3.14159 / 180);
		g.setColor(ColorUtil.WHITE);
		g.drawLine((int)point.getX(), (int)point.getY(),(int)point.getX() + (int)(10 * Math.cos(theta)) , (int)point.getY() + (int)(10 * Math.sin(theta)));
	}
	@Override
	public void handleCollision() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

}
