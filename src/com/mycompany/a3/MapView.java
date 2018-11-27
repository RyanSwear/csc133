package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point2D;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer{
	//private CommandList cl;
	private GameWorldProxy gwp;
	private GameCollection go;
	public void update(Observable o, Object arg)
	{
	
		IGameWorld gw = (IGameWorld) arg;
		System.out.println("_______________________________________");
		gw.displayGameDimension();
		go = gw.getGameObjects();
		IIterator gameI = go.getIterator();
		while (gameI.hasNext())
		{
			//loop through each object in game collection and call its to string function
			System.out.println(gameI.getNext());
			
			
		}
		repaint();
		System.out.println("_______________________________________");
		System.out.println("Update called");
		System.out.println(this.getX() + " x pos " + this.getAbsoluteX());
		System.out.println(this.getY() + " y pos " + this.getAbsoluteY());
		System.out.println(this.getHeight() + " h pos " + this.getWidth() + " wid");
		
	}
	MapView(GameWorld gw)
	{
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBgColor(ColorUtil.GRAY);
		//style
		this.gwp = new GameWorldProxy(gw);
		//only sees proxy
		this.setLayout(new BorderLayout());
		this.getAllStyles().setBorder(Border.createLineBorder(1, ColorUtil.BLACK));
		
	}
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Point2D d = gwp.getMins();
		d.setY(d.getY() - this.getY());
		IIterator gameI = go.getIterator();
		while (gameI.hasNext())
		{
			//loop through each object in game collection and call its to string function
			GameObject goD = (GameObject)gameI.getNext();
			g.setColor(goD.getColor());
			
			if (goD.getX() < this.getAbsoluteX())
			{
				goD.setX((double)this.getWidth() + this.getAbsoluteX() - 1);
			}
			if (goD.getX() > this.getWidth() + this.getAbsoluteX())
			{
				goD.setX((double)this.getAbsoluteX() + 1);
			}
			if (goD.getY() < this.getAbsoluteY())
			{
				goD.setY((double)this.getHeight() + this.getAbsoluteY() - 1);
			}
			if (goD.getY() > this.getHeight() + this.getAbsoluteY())
			{
				goD.setY((double)this.getAbsoluteY() + 1);
			}
			
			goD.draw(g, d);
			if (gwp.getLives() == 0)
			{
				String s = "Out of Lives, reset to play again";
				g.setColor(ColorUtil.CYAN);
				g.drawChars(s.toCharArray(), 0, s.length(), 240, 300);
			}
		}
	}
}
