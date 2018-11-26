package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

public class Asteroid extends MoveObject{
	

		Asteroid()
		{
			Random ran = new Random();
			setSize(ran.nextInt(30) + 6);
			setColor(ColorUtil.LTGRAY);
		}
	
	
	public String toString()
	{
		String s ="Asteroid: loc=" + getX() + ", " + getY() + " color=" + getColor() + " speed= " + getSpeed() + " dir=" + getDirection() + " size= " + getSize();
		return s;
	}


	@Override
	public void draw(Graphics g, Point2D point) {
		// TODO Auto-generated method stub
		g.fillArc((int)this.getX() - 10, (int)this.getY() - (int)point.getY() - 10, 20, 20, 0, 360);
	}


	@Override
	public void handleCollision() {
		// TODO Auto-generated method stub
		
	}

	
}
