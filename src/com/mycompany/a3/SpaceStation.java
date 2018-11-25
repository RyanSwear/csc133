package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

public class SpaceStation extends FixGameObject {
	private int blinkRate;
	private boolean lightStatus;
	
	SpaceStation()
	{
		setID();
		Random ran = new Random();
		blinkRate = ran.nextInt(4) + 1;
		lightStatus = true;
		setColor(ColorUtil.YELLOW);
	}
	public void fillMissile(PlayerShip ps)
	{
		ps.reload();
	}
	
	public void blink(int time)
	{
		if (time % blinkRate == 0)
		{
			changeStatus();
		}
	}
	
	public void changeStatus()
	{
		if (lightStatus)
		{
			lightStatus = false;
		}
		else
			lightStatus = true;
	}
	
	public String toString()
	{
		String s = "Station: loc = " + getX() + ", " + getY() + " color = " + getColor() + " rate = " + blinkRate;
		return s;
	}
	
	public void draw(Graphics g, Point2D point)
	{
		if (lightStatus)
		{
			g.fillRect((int)this.getX() - 25, (int)this.getY() - (int)point.getY() - 25, 50, 50);
		}
		else
		{
			g.drawRect((int)this.getX() - 25, (int)this.getY() - (int)point.getY() - 25, 50, 50, 2);
		}
		
		
	}
	@Override
	public void handleCollision(GameObject o) {
		// TODO Auto-generated method stub
		if (o instanceof PlayerShip)
		{
			PlayerShip p = (PlayerShip)o;
			p.reload();
		}
	}
}
