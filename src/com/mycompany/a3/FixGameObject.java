package com.mycompany.a3;

import java.util.Random;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

abstract class FixGameObject extends GameObject{

		private int iD;
		public void setID()
		{
			Random ran = new Random();
			iD = ran.nextInt(200);
		}
		public abstract void draw(Graphics g, Point2D pCmpRelPrnt);
}
