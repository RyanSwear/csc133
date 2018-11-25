package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;
import java.util.Random;
abstract class GameObject implements IDrawable, ICollider{
	private Point2D location = new Point2D(0,0);
	private int color;
	//private Graphics g;
	
	
	GameObject()
	{
		Random ran = new Random();
		location.setX(ran.nextDouble()*(1024.0) + 0);
		location.setY(ran.nextDouble()*(768) + 0);
		
	}
	public void setX(double x)
	{
		location.setX(x);
	}
	public void setY(double y)
	{
		location.setY(y);
	}
	//can be used to set specific coordinates of location
	public double getX()
	{
		double aVal = location.getX();
		return Math.round(aVal*10.0)/10.0;
	}
	public double getY()
	{
		double aVal = location.getY();
		return Math.round(aVal*10.0)/10.0;
	}
	//used to get specific coordinates of location
	public int getColor()
	{
		return color;
	}
	//specifies color toString
	public Point2D getLocation()
	{
		return location;
	}
	public void setColor( int c)
	{
		color = c;
	}
	public void setLocation(double x, double y)
	{
		location.setX(x);
		location.setY(y);
	}
	//public Graphics getGraphic()
	//{
		//return g;
	//}
	public abstract void draw(Graphics g, Point2D pCmpRelPrnt);
	public boolean collidesWith()
	{
		return false;
	}
	public abstract void handleCollision(GameObject o);
	
	
}
