package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;

public class PointsView extends Container implements Observer{
	
	private Label pointsValueLabel;
	private Label livesValueLabel;
	private Label missileValueLabel;
	private Label soundValueLabel;
	private Label timeValueLabel;
	
	public void update(Observable o, Object arg)
	{
		IGameWorld gw = (IGameWorld) arg;
		int score = gw.getScore();
		int lives = gw.getLives();
		int time = gw.getTime();
		int missiles = gw.getMissileCount();
		boolean sound = gw.getSound();
		//create values for labels
		pointsValueLabel.setText("" + (score > 99 ? "" : "0") + (score > 9 ? "" : "0") + score);
		livesValueLabel.setText("" + lives);
		timeValueLabel.setText("" + time);
		missileValueLabel.setText("" + missiles);
		//set their texts to the values
		if(sound)
		{
			soundValueLabel.setText("On");
		}
		else
		{
			soundValueLabel.setText("Off");
		}
		
		this.repaint();
	}
	
	PointsView(GameWorld gw)
	{
		//style
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBgColor(ColorUtil.WHITE);
		this.setScrollable(true);
		
		//text label instances
		Label pointsTextLabel = new Label("Points: ");
		Label livesTextLabel = new Label ("Lives: ");
		Label missileTextLabel = new Label("Missiles: ");
		Label soundTextLabel = new Label("Sound: ");
		Label timeTextLabel = new Label("Time: ");
		
		
		pointsValueLabel = new Label("000");
		pointsTextLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		livesValueLabel = new Label("3");
		livesTextLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		missileValueLabel = new Label("10");
		missileTextLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		soundValueLabel = new Label("On");
		soundTextLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		timeValueLabel = new Label("0");
		timeTextLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		//initialize the label texts
		
		Container myContainer = new Container();
		myContainer.setLayout(new BoxLayout(BoxLayout.X_AXIS));
		//create a place to put all of the labels
		
		myContainer.add(pointsTextLabel);
		myContainer.add(pointsValueLabel);
		myContainer.add(livesTextLabel);
		myContainer.add(livesValueLabel);
		myContainer.add(missileTextLabel);
		myContainer.add(missileValueLabel);
		myContainer.add(soundTextLabel);
		myContainer.add(soundValueLabel);
		myContainer.add(timeTextLabel);
		myContainer.add(timeValueLabel);
		//add all labels to the place
		
		this.add(myContainer);
		this.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
	}
}
