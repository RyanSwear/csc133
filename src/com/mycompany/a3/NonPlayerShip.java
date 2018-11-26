package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

public class NonPlayerShip extends Ship{
	private NPMissileLauncher ml;
	
	Random ran = new Random();
	NonPlayerShip()
	{
		int i = ran.nextInt(1);
		ml = new NPMissileLauncher(getDirection());
		setColor(ColorUtil.rgb(255, 0, 0));
		if (i == 0)
		{
			setSize(10);
		}
		else
		{
			setSize(20);
		}
	}
	

	public String toString()
	{
		String s = "Non-Player Ship: loc=" + getX() + ", " + getY() + " color= " + getColor() + " speed= " + getSpeed() + " dir= " + getDirection() + " size: " + getSize();
		return s;
	}


	@Override
	public void draw(Graphics g, Point2D point) {
		// TODO Auto-generated method stub
		double R = (20/(2*(Math.sin(60.0))));
		double r = R/2;
		Point2D a = new Point2D(this.getX() - 10, this.getY() + r);
		Point2D b = new Point2D(this.getX(), this.getY() + R);
		Point2D c = new Point2D(this.getX() + 10, this.getY() + r);
		g.drawLine((int)a.getX(),(int)a.getY() - (int)point.getY() - (int)R + (int)r/2, (int)b.getX(), (int)b.getY()- (int)point.getY() - (int)R + (int)r/2);
		g.drawLine((int)b.getX(),(int)b.getY() - (int)point.getY() - (int)R + (int)r/2, (int)c.getX(), (int)c.getY()- (int)point.getY() - (int)R + (int)r/2);
		g.drawLine((int)a.getX(),(int)a.getY() - (int)point.getY() - (int)R + (int)r/2, (int)c.getX(), (int)c.getY() - (int)point.getY() - (int)R + (int)r/2);
		
	}


	@Override
	public void handleCollision() {
		// TODO Auto-generated method stub
		
	}

}
