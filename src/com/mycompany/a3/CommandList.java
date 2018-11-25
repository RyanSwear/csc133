package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.a3.Commands.*;

public class CommandList extends Container {

	private GameWorldProxy gw;
	Button turnLeft;
	Button turnRight;
	Button increaseSpeed;
	Button decreaseSpeed;
	Button addPS;
	Button addNPS;
	Button addSS;
	Button clockB;
	Button fireB;
	Button hyperB;
	Button loadB;
	CommandList(GameWorldProxy gw)
	{
		this.gw = gw;
		
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBgColor(ColorUtil.WHITE);
		this.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		//this.getAllStyles().setMarginBottom(100);
		//turn left command
		Button turnLeft = new Button("TurnLeft");
		TurnLeft tl = new TurnLeft(gw);
		turnLeft.setCommand(tl);
		turnLeft.getAllStyles().setBgTransparency(255);
		turnLeft.getAllStyles().setBgColor(0x5EFF94);
		turnLeft.getAllStyles().setBorder(Border.createLineBorder(4, 0x2A7041));
		turnLeft.getAllStyles().setFgColor(0x2A7041);
		//turnLeft.setAutoSizeMode(true);
		//turn right command
		Button turnRight = new Button("TurnRight");
		TurnRight tr = new TurnRight(gw);
		turnRight.setCommand(tr);
		turnRight.getAllStyles().setBgTransparency(255);
		turnRight.getAllStyles().setBgColor(0x5EFF94);
		turnRight.getAllStyles().setBorder(Border.createLineBorder(4, 0x2A7041));
		turnRight.getAllStyles().setFgColor(0x2A7041);
		//increaseSpeed
		Button increaseSpeed = new Button("Increase Speed");
		IncreaseSpeedCommand isc = new IncreaseSpeedCommand(gw);
		increaseSpeed.setCommand(isc);
		increaseSpeed.getAllStyles().setBgTransparency(255);
		increaseSpeed.getAllStyles().setBgColor(0x5EFF94);
		increaseSpeed.getAllStyles().setBorder(Border.createLineBorder(4, 0x2A7041));
		increaseSpeed.getAllStyles().setFgColor(0x2A7041);
		//decrease speed
		Button decreaseSpeed = new Button("Decrease Speed");
		DecreaseSpeedCommand dsc = new DecreaseSpeedCommand(gw);
		decreaseSpeed.setCommand(dsc);
		decreaseSpeed.getAllStyles().setBgTransparency(255);
		decreaseSpeed.getAllStyles().setBgColor(0x5EFF94);
		decreaseSpeed.getAllStyles().setBorder(Border.createLineBorder(4, 0x2A7041));
		decreaseSpeed.getAllStyles().setFgColor(0x2A7041);
		//add player ship command
		Button addPS = new Button("Add Player Ship");
		AddPlayerShipCommand apsc = new AddPlayerShipCommand(gw);
		addPS.setCommand(apsc);
		addPS.getAllStyles().setBgTransparency(255);
		addPS.getAllStyles().setBgColor(0x5EFF94);
		addPS.getAllStyles().setBorder(Border.createLineBorder(4, 0x2A7041));
		addPS.getAllStyles().setFgColor(0x2A7041);
		//add nps
		Button addNPS = new Button("Add NonPlayer Ship");
		AddNPSCommand anpsc = new AddNPSCommand(gw);
		addNPS.setCommand(anpsc);
		addNPS.getAllStyles().setBgTransparency(255);
		addNPS.getAllStyles().setBgColor(0x5EFF94);
		addNPS.getAllStyles().setBorder(Border.createLineBorder(4, 0x2A7041));
		addNPS.getAllStyles().setFgColor(0x2A7041);
		//add asteroid command
		Button addAsteroid = new Button("Add Asteroid");
		AddAsteroidCommand addA = new AddAsteroidCommand(gw);
		addAsteroid.setCommand(addA);
		addAsteroid.getAllStyles().setBgTransparency(255);
		addAsteroid.getAllStyles().setBgColor(0x5EFF94);
		addAsteroid.getAllStyles().setBorder(Border.createLineBorder(4, 0x2A7041));
		addAsteroid.getAllStyles().setFgColor(0x2A7041);
		//addSpaceStation
		Button addSS = new Button("Add Space Station");
		AddSpaceStationCommand addSSC = new AddSpaceStationCommand(gw);
		addSS.setCommand(addSSC);
		addSS.getAllStyles().setBgTransparency(255);
		addSS.getAllStyles().setBgColor(0x5EFF94);
		addSS.getAllStyles().setBorder(Border.createLineBorder(4, 0x2A7041));
		addSS.getAllStyles().setFgColor(0x2A7041);
		//clock tick command
		Button clockB = new Button("TickClock");
		ClockTickCommand clockC = new ClockTickCommand(gw);
		clockB.setCommand(clockC);
		clockB.getAllStyles().setBgTransparency(255);
		clockB.getAllStyles().setBgColor(0x5EFF94);
		clockB.getAllStyles().setBorder(Border.createLineBorder(4, 0x2A7041));
		clockB.getAllStyles().setFgColor(0x2A7041);
		//fire missile button
		Button fireB = new Button("Fire Missile");
		FireMissileCommand fireC = new FireMissileCommand(gw);
		fireB.setCommand(fireC);
		fireB.getAllStyles().setBgTransparency(255);
		fireB.getAllStyles().setBgColor(0x5EFF94);
		fireB.getAllStyles().setBorder(Border.createLineBorder(4, 0x2A7041));
		fireB.getAllStyles().setFgColor(0x2A7041);
		
		//hyperspace button
		Button hyperB = new Button("Jump HyperSpace");
		HyperspaceCommand hyperC = new HyperspaceCommand(gw);
		hyperB.setCommand(hyperC);
		hyperB.getAllStyles().setBgTransparency(255);
		hyperB.getAllStyles().setBgColor(0x5EFF94);
		hyperB.getAllStyles().setBorder(Border.createLineBorder(4, 0x2A7041));
		hyperB.getAllStyles().setFgColor(0x2A7041);
		//load ammo button
		Button loadB = new Button("Load Ammo");
		LoadAmmoCommand loadC = new LoadAmmoCommand(gw);
		loadB.setCommand(loadC);
		loadB.getAllStyles().setBgTransparency(255);
		loadB.getAllStyles().setBgColor(0x5EFF94);
		loadB.getAllStyles().setBorder(Border.createLineBorder(4, 0x2A7041));
		loadB.getAllStyles().setFgColor(0x2A7041);
		//player crash button
		Button crashB = new Button("Player Ship Crash");
		PlayerCrashCommand crashC = new PlayerCrashCommand(gw);
		crashB.setCommand(crashC);
		crashB.getAllStyles().setBgTransparency(255);
		crashB.getAllStyles().setBgColor(0x5EFF94);
		crashB.getAllStyles().setBorder(Border.createLineBorder(4, 0x2A7041));
		crashB.getAllStyles().setFgColor(0x2A7041);
		// asteroid collision button
		Button asteroidCB = new Button("Asteroid Collision");
		AsteroidCollisionCommand asteroidCC = new AsteroidCollisionCommand(gw);
		asteroidCB.setCommand(asteroidCC);
		asteroidCB.getAllStyles().setBgTransparency(255);
		asteroidCB.getAllStyles().setBgColor(0x5EFF94);
		asteroidCB.getAllStyles().setBorder(Border.createLineBorder(4, 0x2A7041));
		asteroidCB.getAllStyles().setFgColor(0x2A7041);
		// rotate left button
		Button rotateLB = new Button("Rotate Gun Left");
		RotateGunLeftCommand rotateLC = new RotateGunLeftCommand(gw);
		rotateLB.setCommand(rotateLC);
		rotateLB.getAllStyles().setBgTransparency(255);
		rotateLB.getAllStyles().setBgColor(0x5EFF94);
		rotateLB.getAllStyles().setBorder(Border.createLineBorder(4, 0x2A7041));
		rotateLB.getAllStyles().setFgColor(0x2A7041);
		//rotate gun right button
		Button rotateRB = new Button("Rotate Gun Right");
		RotateGunRightCommand rotateRC = new RotateGunRightCommand(gw);
		rotateRB.setCommand(rotateRC);
		rotateRB.getAllStyles().setBgTransparency(255);
		rotateRB.getAllStyles().setBgColor(0x5EFF94);
		rotateRB.getAllStyles().setBorder(Border.createLineBorder(4, 0x2A7041));
		rotateRB.getAllStyles().setFgColor(0x2A7041);
		//quit button
		Button qquitB = new Button("Quit");
		QuitCommand quitC = new QuitCommand(gw);
		qquitB.setCommand(quitC);
		qquitB.getAllStyles().setBgTransparency(255);
		qquitB.getAllStyles().setBgColor(0x5EFF94);
		qquitB.getAllStyles().setBorder(Border.createLineBorder(4, 0x2A7041));
		qquitB.getAllStyles().setFgColor(0x2A7041);
		//Container myContainer = new Container();
		//myContainer.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		
		
		this.add(turnLeft);
		this.add(turnRight);
		this.add(increaseSpeed);
		this.add(decreaseSpeed);
		this.add(addPS);
		this.add(addNPS);
		this.add(addAsteroid);
		this.add(addSS);
		this.add(clockB);
		this.add(fireB);
		this.add(hyperB);
		this.add(loadB);
		this.add(crashB);
		this.add(asteroidCB);
		this.add(rotateLB);
		this.add(rotateRB);
		this.add(qquitB);
		
		//this.add(myContainer);
		this.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
		this.getAllStyles().setFgColor(ColorUtil.YELLOW);
		this.setScrollable(true);
		
		
		
	}
}
