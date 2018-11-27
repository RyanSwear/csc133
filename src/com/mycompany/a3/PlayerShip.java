package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;
import java.lang.Math;

public class PlayerShip extends Ship implements ISteerable{

	private PlayerMissileLauncher missileLauncher = new PlayerMissileLauncher();
	
	PlayerShip()
	{
		
		setColor(ColorUtil.GREEN);
		setLocation(512,384);
		missileCount = 10;
		setSize(10);
		setSpeed(0);
	}
	public void fireMissile()
	{
		this.missileCount--;
	}
	
	public void reload()
	{
		this.missileCount = 10;
	}


	@Override
	public void steerLeft() {
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
		
		if (getDirection() < 350)
		{
			setDirection(getDirection() + 10);
		}
		else
		{
			setDirection(getDirection() - 360 + 10);
		}
	}
	
	public void steerMissileLeft()
	{
		missileLauncher.steerLeft();
	}
	
	public void steerMissileRight()
	{
		missileLauncher.steerRight();
	}
	public int getLauncherDirection()
	{
		return missileLauncher.getDirection();
	}
	public String toString()
	{
		 String s = "Player Ship: loc = " + this.getX() + ", " + this.getY() + " color = " + getColor() + " speed = " + getSpeed() + " dir = " + getDirection() + " missiles: " + getMissileCount() + " MissileLauncher dir = " + missileLauncher.getDirection();
		 return s;
	}
	@Override
	public void draw(Graphics g, Point2D point) {
		// TODO Auto-generated method stub
		//g.drawRect((int)this.getX() - 50, (int)this.getY() - (int)point.getY() - 50, 100, 100, 2);
		double R = (20/(2*(Math.sin(60.0))));
		double r = R/2;
		Point2D a = new Point2D(this.getX() - 10, this.getY() + r);
		Point2D b = new Point2D(this.getX(), this.getY() + R);
		Point2D c = new Point2D(this.getX() + 10, this.getY() + r);
		g.drawLine((int)a.getX(),(int)a.getY() - (int)point.getY() - (int)R + (int)r/2, (int)b.getX(), (int)b.getY()- (int)point.getY() - (int)R + (int)r/2);
		g.drawLine((int)b.getX(),(int)b.getY() - (int)point.getY() - (int)R + (int)r/2, (int)c.getX(), (int)c.getY()- (int)point.getY() - (int)R + (int)r/2);
		g.drawLine((int)a.getX(),(int)a.getY() - (int)point.getY() - (int)R + (int)r/2, (int)c.getX(), (int)c.getY() - (int)point.getY() - (int)R + (int)r/2);
		
	
		
		double theta = (missileLauncher.getDirection() - 90) * 3.14159 / 180;
		g.setColor(ColorUtil.WHITE);
		g.drawLine((int)this.getX(), (int)this.getY() - (int)point.getY() - (int)R - 30, (int)this.getX() + (int)(15 * Math.cos(theta)), (int)(this.getY() - (int)point.getY() - (int)R  - 30)+ (int)(15 * Math.sin(theta)));
	}
	@Override
	public void handleCollision() {
		// TODO Auto-generated method stub
		
	}
}
