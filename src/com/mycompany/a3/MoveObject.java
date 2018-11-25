package com.mycompany.a3;

import java.util.Random;
import java.lang.Math;
abstract class MoveObject extends GameObject implements IMoveable {
	private int speed, direction;
	MoveObject()
	{
		Random ran = new Random();
		speed = ran.nextInt(10);
		direction = ran.nextInt(359);
	}
	public void move()
	{
		this.setLoc(getX() + Math.cos(direction * (3.14159/180))*speed, getY() + Math.sin(direction*(3.14159/180))*speed);
	}
	public void increaseSpeed(int i)
	{
		if (speed < 10 && speed >= 0 )
		{
			speed = speed + i;
		}
		else
		{
			System.out.println("SPEED IS AT ITS MAX");
		}
	}
	public void decreaseSpeed(int i)
	{
		if (speed > 0)
		{
			speed = speed - i;
		}
	}
	public int getDirection()
	{
		return this.direction;
	}
	public int getSpeed()
	{
		return this.speed;
	}
	public void setDirection(int i)
	{
		direction = i;
	}
	public void setLoc(double x, double y) {
		// TODO Auto-generated method stub
		super.setX(x);
		super.setY(y);
	}
	public void setSpeed(int i)
	{
		speed = i;
	}
}
