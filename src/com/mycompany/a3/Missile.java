package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

public class Missile extends MoveObject{
	int fuelLevel;
	char owner;// P for player N for NPS
	
	Missile()
	{
		fuelLevel = 3;
		setSpeed(5);
		setColor(ColorUtil.CYAN);
	}
	public void decrementFuel()
	{
		fuelLevel--;
	}
	
	public int getFuelLevel()
	{
		return fuelLevel;
	}
	public char getOwner()
	{
		return owner;
	}
	
	public String toString()
	{
		if (owner == 'P')
		{
			String s = "PS's Missile: loc=" + getX() + ", " + getY() + " color=" + getColor() + " speed=" + getSpeed() + " dir=" + getDirection() + " fuel=" + getFuelLevel();
			return s;
		}
		else
		{
			String s = "NPS's Missile: loc=" + getX() + ", " + getY() + " color=" + getColor() + " speed=" + getSpeed() + " dir=" + getDirection() + " fuel=" + getFuelLevel();
			return s;
		}
	}
	@Override
	public void draw(Graphics g, Point2D point) {
		// TODO Auto-generated method stub
	//iso triangle
		double R = (10/(2*(Math.sin(60.0))));
		double r = R/2;
		Point2D a = new Point2D(this.getX() - 5, this.getY() + r);
		Point2D b = new Point2D(this.getX(), this.getY() + R);
		Point2D c = new Point2D(this.getX() + 5, this.getY() + r);
		//g.drawLine((int)a.getX(),(int)a.getY() - (int)point.getY() - (int)R + (int)r/2, (int)b.getX(), (int)b.getY()- (int)point.getY() - (int)R + (int)r/2);
		//g.drawLine((int)b.getX(),(int)b.getY() - (int)point.getY() - (int)R + (int)r/2, (int)c.getX(), (int)c.getY()- (int)point.getY() - (int)R + (int)r/2);
		//g.drawLine((int)a.getX(),(int)a.getY() - (int)point.getY() - (int)R + (int)r/2, (int)c.getX(), (int)c.getY() - (int)point.getY() - (int)R + (int)r/2);
		
		g.fillTriangle((int)a.getX(), (int)a.getY() - (int)point.getY() - (int)R + (int)r/2, (int)b.getX(), (int)b.getY() - (int)point.getY() - (int)R + (int)r/2, (int)c.getX(), (int)c.getY() - (int)point.getY() - (int)R + (int)r/2);
		
	}
	@Override
	public void handleCollision(GameObject o) {
		// TODO Auto-generated method stub
		
	}
}
