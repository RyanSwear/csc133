package com.mycompany.a3;
import java.util.Iterator;
import java.util.Observable;
import java.util.Random;
import java.util.Vector;

import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point2D;
public class GameWorld extends Observable implements  IGameWorld{
	private int gameScore,lives,time;
	private Dimension map = new Dimension(1024,750);
	private Dimension mins = new Dimension(0,0);
	
	public Vector<GameObject> store = new Vector<GameObject>();
	
	
	private GameCollection go;
	private boolean soundOn = true;
	
	public GameWorld()
	{
		go = new GameCollection();
		
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		//initialize the world and notify observers that objects have been created
	}
	public void displayGameDimension()
	{
		System.out.println("Map Width: " + map.getWidth() + " Map Height: " + map.getHeight());
		//display the dimensions of the game
	}
	public void setDimension( int x, int y)
	{
		map.setHeight(y);
		map.setWidth(x);
	}
	public void setMins(int x, int y)
	{
		mins.setHeight(y);
		mins.setWidth(x);
	}
	public Point2D getMins()
	{
		Point2D d = new Point2D(mins.getWidth(), mins.getHeight());
		return d;
	}
	public GameCollection getGameObjects()
	{
		return go;//pass the collection of game objects to whatever needs it
	}
	public void init()
	{
		//addStation();
		//addPS();
		gameScore = 0;
		lives = 3;
		time = 0;
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		//create the game with a player ship and space station initialized
	}
	public void addAsteroid()
	{
		Random ran = new Random();
		Asteroid asteroid = new Asteroid();
		asteroid.setLocation((double)ran.nextInt(((map.getWidth() - 10) - (mins.getWidth() + 10)) + 1) + (mins.getWidth() + 10), (double)ran.nextInt(((map.getHeight() - 10) - (mins.getHeight() + 10)) + 1) + (mins.getHeight() + 10));
		go.add(asteroid);
		System.out.println("A new asteroid has been created");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		//create a new asteroid and place it in the game collection
		System.out.println(mins.getWidth() +  " " + mins.getHeight());
	}
	public void addNPS()
	{
		Random ran = new Random();
		NonPlayerShip nps = new NonPlayerShip();
		nps.setLocation((double)ran.nextInt(((map.getWidth() - 10) - (mins.getWidth() + 10)) + 1) + (mins.getWidth() + 10), (double)ran.nextInt(((map.getHeight() - 10) - (mins.getHeight() + 10)) + 1) + (mins.getHeight() + 10));
		go.add(nps);
		System.out.println("A new NPS has appeared.");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		//create a new non player ship in game collection
	}
	public void addStation()
	{
		
		IIterator i = go.getIterator();
		while(i.hasNext())
		{
			if(i.getNext() instanceof SpaceStation)
			{
				System.out.println("A player space station has already been created. Cant have more than one");
				return;
			}
			
		}//check to make sure that a space station doesnot exist
		Random ran = new Random();
		SpaceStation ss = new SpaceStation();
		ss.setLocation((double)ran.nextInt(((map.getWidth() - 25) - (mins.getWidth() + 25)) + 1) + (mins.getWidth() + 25), (double)ran.nextInt(((map.getHeight() - 25) - (mins.getHeight() + 25)) + 1) + (mins.getHeight() + 25));
		go.add(ss);
		System.out.println(mins.getWidth() + " mins width");
		System.out.println(map.getWidth() + " map width");
		System.out.println(mins.getHeight() + "mins height");
		System.out.println(map.getHeight() + "map height");
		System.out.println("A new space station has appeared.");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		
		//if the station does not exist create on in game collection
	}
	public void addPS()
	{
		IIterator i = go.getIterator();
		while(i.hasNext())
		{
			if(i.getNext() instanceof PlayerShip)
			{
				System.out.println("A player ship has already been created. Cant have more than one");
				return;
			}
		}//check to see if a player ship has already been created, only one can appear in game collection
		Random ran = new Random();
		PlayerShip ps = new PlayerShip();
		ps.setLocation((double)ran.nextInt(((map.getWidth() - 10) - (mins.getWidth() + 10)) + 1) + (mins.getWidth() + 10), (double)ran.nextInt(((map.getHeight() - 10) - (mins.getHeight() + 10)) + 1) + (mins.getHeight() + 10));
		go.add(ps);//if not add a ps to game collection
		System.out.println("A new player ship is created.");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	public void increasePlayerSpeed()
	{
		IIterator i = go.getIterator();
		while(i.hasNext())
		{if (i.getNext() instanceof PlayerShip) 
			{
				PlayerShip ps = (PlayerShip)i.getObject();
				ps.increaseSpeed(1);}
			}
		//find and instance of player ship in collection and increase its speed
		System.out.println("Ship speed increased.");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));//notify observers that the world has changed
	}
	public void decreasePlayerSpeed()
	{
		IIterator i = go.getIterator();
		while(i.hasNext())
			if (i.getNext() instanceof PlayerShip)
			{
				PlayerShip ps = (PlayerShip)i.getObject();
				ps.decreaseSpeed(1);
			}
		//find instance of player ship and decrease its speed, notify observers
		System.out.println("Ship speed decreased.");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	public void playerShipTurnLeft()
	{
		IIterator i = go.getIterator();
		while(i.hasNext())
			if (i.getNext() instanceof PlayerShip)
			{
				PlayerShip ps = (PlayerShip)i.getObject();
				ps.steerLeft();
			}
		//find instance of player ship, turn left, notify observers
		System.out.println("Ship turned left.");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	public void playerShipTurnRight()
	{
		IIterator i = go.getIterator();
		while(i.hasNext())
			if (i.getNext() instanceof PlayerShip)
			{
				PlayerShip ps = (PlayerShip)i.getObject();
				ps.steerRight();
			}
		//find instance of player ship, turn right, notify observers
		System.out.println("Ship turned right.");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	public void turnMissileLauncherLeft()
	{
		IIterator i = go.getIterator();
		while(i.hasNext())
			if (i.getNext() instanceof PlayerShip)
			{
				PlayerShip ps = (PlayerShip)i.getObject();
				ps.steerMissileLeft();
			}
		//find instance of player ship, turn ml left, notify observers
		System.out.println("Missile Launcher turned left.");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	public void turnMissileLauncherRight()
	{
		IIterator i = go.getIterator();
		while(i.hasNext())
			if (i.getNext() instanceof PlayerShip)
			{
				PlayerShip ps = (PlayerShip)i.getObject();
				ps.steerMissileRight();
			}
		//find instance of player ship, turn ml right, notify observers
		System.out.println("Missile Launcher turned right.");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	public void firePlayerMissile()
	{
		//add missile to game world, decrease missile count in ship,
		
		IIterator i = go.getIterator();
		while(i.hasNext())
			if (i.getNext() instanceof PlayerShip)
			{
				PlayerShip ps = (PlayerShip)i.getObject();
				if (ps.missileCount > 0)		//check if player has missiles left
				{// if yes, create a new missile, add it to game world with a direction the same as missile launcher
					Missile m = new Missile();
					ps.missileCount--;
					m.setDirection(ps.getLauncherDirection());
					m.setLoc(ps.getX(), ps.getY());
					//set speed
					m.setSpeed(7);
					m.owner = 'P';
					go.add(m);
					System.out.println("Player Fired Missile.");
					this.setChanged();
					this.notifyObservers(new GameWorldProxy(this));

				}
				else
				{
					System.out.println("Ship is out of misiles.");
				}
			}
		
	}
	public void launchNPSMissiles() 
	{//make sure a NPS is in game object vector, launch a missile when one is found
		System.out.println("Detecting NPS...");
		IIterator i = go.getIterator();
		while(i.hasNext())
			if (i.getNext() instanceof NonPlayerShip)
			{
				NonPlayerShip nps = (NonPlayerShip)i.getObject();
				Missile m = new Missile();
				m.setDirection(nps.getDirection());
				m.setLocation(nps.getX(), nps.getY());
				//set direction, loc
				go.add(m);
				System.out.println("NPS fired Missile.");
			}//tell all nps to add a missile to game collection
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	public void jumpToHyperSpace()
	{//call player ship setLocation function
		IIterator i = go.getIterator();
		while(i.hasNext())
			if (i.getNext() instanceof PlayerShip)
			{
				PlayerShip ps = (PlayerShip)i.getObject();
				ps.setLoc(map.getWidth()/2,map.getHeight()/2);
			}
		//change the location of ps 
		System.out.println("Player jumped to hyperspace.");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	public void refillPSMissiles()
	{//call player ship reload function 
		PlayerShip ps = null;
		SpaceStation ss = null;
		IIterator i = go.getIterator();
		while(i.hasNext())
		{
			if (i.getNext() instanceof PlayerShip)
			{
				ps = (PlayerShip)i.getObject();
				//go through collection and pull a ps or space station
			}
			if (i.getNext() instanceof SpaceStation)
			{
				ss = (SpaceStation)i.getObject();
			}
		}
		if(ps.getLocation().equals(ss.getLocation()))
		{
			//only reload if their locations are the same
			ps.reload();
			System.out.println("Missiles reloaded");
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		//notify observers
	}
	public void missileAsteroidCrash()
	{
		System.out.println("Detecting missile/asteroid crash...");
		//check if ps missile and asteroid are at same location, if so destroy both, add points to player score
		IIterator i = go.getIterator();
		while(i.hasNext())
		{
			if (i.getNext() instanceof Asteroid)
			{
				Asteroid ast = (Asteroid)i.getObject();
				IIterator j = go.getIterator();
				while(j.hasNext())
				{
					if (j.getNext() instanceof Missile)
					{
						Missile m = (Missile)j.getObject();
						if (m.getLocation().equals(ast.getLocation()) && m.owner == 'P')
						{
							if (j.getIndex() > i.getIndex())
							{
								
								go.remove(m);
								
								go.remove(ast);
								gameScore = gameScore + 10;
								System.out.println("Missile hit Asteroid");
								this.setChanged();
								this.notifyObservers(new GameWorldProxy(this));
								return;
								
							}
							else
							{
								go.remove(ast);
								
								go.remove(m);
								gameScore = gameScore + 10;
								System.out.println("Missile hit asteroid");
								this.setChanged();
								this.notifyObservers(new GameWorldProxy(this));
								return;
							}
						}
					}
				}
			}
		}
			
		System.out.println("No missile/asteroid crash detected");
		
	}
	
	public void eliminate() //loop through vector and find instance of NPS and missile
	//if location is the same, remove from game
	{		System.out.println("Detecting NPS/missile crash...");
	IIterator i = go.getIterator();
	while(i.hasNext())
		{
			if (i.getNext() instanceof NonPlayerShip)
			{
				NonPlayerShip nps = (NonPlayerShip)i.getObject();
				IIterator j = go.getIterator();
				while(j.hasNext())
				{
					if (j.getNext() instanceof Missile)
					{
						Missile m = (Missile)j.getObject();
						if (m.getLocation().equals(nps.getLocation()) && m.owner == 'P')
						{
							if (j.getIndex() > i.getIndex())
							{
								go.remove(m);
								
								go.remove(nps);
								gameScore = gameScore + 10;
								System.out.println("Missile hit NPS!.");
								this.setChanged();
								this.notifyObservers(new GameWorldProxy(this));
								return;
							}
							else
							{
								go.remove(nps);
								
								go.remove(m);
								gameScore = gameScore + 10;
								System.out.println("Missile hit NPS!.");
								this.setChanged();
								this.notifyObservers(new GameWorldProxy(this));
								return;
							}
						}
					}
				}
			}
		}
		System.out.println("No hit detected");
		
	}
	
	public void psHitByMissile()
	{// loop through game vector and find instance of Player and NPS missile
		//if location is the same, simulate crash
		System.out.println("Detecting missile/PlayerShip...");
		IIterator i = go.getIterator();
		while(i.hasNext())
		{
			if (i.getNext() instanceof PlayerShip)
			{
				PlayerShip nps = (PlayerShip)i.getObject();
				IIterator j = go.getIterator();
				while(j.hasNext())
				{
					if (j.getNext() instanceof Missile)
					{
						Missile m = (Missile)j.getObject();
						if (m.getLocation().equals(nps.getLocation()) && m.owner == 'N')
						{
							if (j.getIndex() > i.getIndex())
							{
								go.remove(m);
								go.remove(nps);
								gameScore = gameScore - 10;
								lives--;
								System.out.println("You were hit by the enemy!.");
								go.add(nps);
								if (lives == 0)
								{
									System.out.println("Game Over!!");
								}
								this.setChanged();
								this.notifyObservers(new GameWorldProxy(this));
								return;
							}
							else
							{
								go.remove(nps);
								go.remove(m);
								gameScore = gameScore - 10;
								lives--;
								System.out.println("You were hit by the enemy!.");
								go.add(nps);
								if (lives == 0)
								{
									System.out.println("Game Over!!");
								}
								this.setChanged();
								this.notifyObservers(new GameWorldProxy(this));
								return;
							}
						}
					}
				}
			}
		}
		System.out.println("No hit detected");
		
	}
	
	public void playerAsteroidCrash()
	{//locate instance of Player and asteroid in game object vector
		// if their locations are the same, simulate a crash
		System.out.println("Detecting player/asteroid crash...");
		IIterator i = go.getIterator();
		while(i.hasNext())
		{
			if (i.getNext() instanceof PlayerShip)
			{
				PlayerShip nps = (PlayerShip)i.getObject();
				IIterator j = go.getIterator();
				while(j.hasNext())
				{
					if (j.getNext() instanceof Asteroid)
					{
						Asteroid a = (Asteroid)j.getObject();
						if (a.getLocation().equals(nps.getLocation()))
						{
							if (j.getIndex() > i.getIndex())
							{
								go.remove(nps);
								go.remove(a);
								gameScore = gameScore - 10;
								lives--;
								PlayerShip ps = new PlayerShip();
								go.add(ps);
								System.out.println("You crashed into an asteroid!");
								if (lives == 0)
								{
									System.out.println("Game Over!!");
									this.setChanged();
									this.notifyObservers(new GameWorldProxy(this));
								}
								return;
							}
							else
							{
								go.remove(a);
								go.remove(nps);
								gameScore = gameScore - 10;
								lives--;
								PlayerShip ps = new PlayerShip();
								go.add(ps);
								System.out.println("You crashed into an asteroid!");
								if (lives == 0)
								{
									System.out.println("Game Over!!");
									this.setChanged();
									this.notifyObservers(new GameWorldProxy(this));
								}
								return;
							}
						}
					}
				}
			}
		}
		System.out.println("No hit detected");//notify if no hit was detected
		
	}
	
	public void playerCrashNPS()
	{
		// loop through game object vector and find instance of NPS and Player
		//if their locations are the same, simulate crash
		System.out.println("Detecting Player/NPS crash...");
		IIterator i = go.getIterator();
		while(i.hasNext())
		{
			if (i.getNext() instanceof PlayerShip)
			{
				PlayerShip ps = (PlayerShip)i.getObject();
				IIterator j = go.getIterator();
				while(j.hasNext())
				{
					if (j.getNext() instanceof NonPlayerShip)
					{
						NonPlayerShip m = (NonPlayerShip)j.getObject();
						if (m.getLocation().equals(ps.getLocation()))
						{
							if (j.getIndex() > i.getIndex())
							{
								go.remove(ps);
								go.remove(m);
								gameScore = gameScore - 10;
								lives--;
								PlayerShip cps = new PlayerShip();
								go.add(cps);
								System.out.println("You crashed into NPS!");
								if (lives == 0)
								{
									System.out.println("Game Over!!");
									this.setChanged();
									this.notifyObservers(new GameWorldProxy(this));
								}
								return;
							}
							else
							{
								go.remove(m);
								go.remove(ps);
								gameScore = gameScore - 10;
								lives--;
								PlayerShip cps = new PlayerShip();
								go.add(cps);
								System.out.println("You crashed into NPS!");
								if (lives == 0)
								{
									System.out.println("Game Over!!");
									this.setChanged();
									this.notifyObservers(new GameWorldProxy(this));
								}
								return;
							}
						}
					}
				}
			}
		}
		System.out.println("No hit detected");// no collisions detected, notify user
		
	}
	
	public void asteroidCrashAsteroid()
	{
		//loop through game object vector and fin instances of two asteroids
		//if their locations are the same, remove from game
		System.out.println("Detecting asteroid/asteroid crash...");
		IIterator i = go.getIterator();
		while(i.hasNext())
		{
			if (i.getNext() instanceof Asteroid)
			{
				Asteroid nps = (Asteroid)i.getObject();
				IIterator j = go.getIterator();
				while(j.hasNext())
				{
					if (j.getNext() instanceof Asteroid)
					{
						Asteroid a = (Asteroid)j.getObject();
						if ((a.getLocation().equals(nps.getLocation())) && (a.equals(nps) == false))
						{
							if (j.getIndex() > i.getIndex())
							{
								go.remove(nps);
								go.remove(a);
								System.out.println("Asteroid hit asteroid");
								this.setChanged();
								this.notifyObservers(new GameWorldProxy(this));
								return;
							}
							else
							{
								go.remove(a);
								go.remove(nps);
								System.out.println("Asteroid hit asteroid");
								this.setChanged();
								this.notifyObservers(new GameWorldProxy(this));
								return;
							}
						}
					}
				}
			}
		}
		System.out.println("No hit detected");// no collisions, notify user
		
	}
	
	public void asteroidNPSCollision()
	{
		// loop through the gameobject vector and find an instance of an asteroid and a NPS
		//if their locations are the same, remove from the game
		System.out.println("Detecting NPS/asteroid crash...");
		IIterator i = go.getIterator();
		while(i.hasNext())
		{
			if (i.getNext() instanceof NonPlayerShip)
			{
				NonPlayerShip nps = (NonPlayerShip)i.getObject();
				IIterator j = go.getIterator();
				while(j.hasNext())
				{
					if (j.getNext() instanceof Asteroid)
					{
						Asteroid a = (Asteroid)j.getObject();
						if (a.getLocation().equals(nps.getLocation()))
						{
							if (j.getIndex() > i.getIndex())
							{
								go.remove(nps);
								go.remove(a);
								System.out.println("Asteroid hit nps");
								this.setChanged();
								this.notifyObservers(new GameWorldProxy(this));
								return;
							}
							else
							{
								go.remove(a);
								go.remove(nps);
								System.out.println("Asteroid hit nps");
								this.setChanged();
								this.notifyObservers(new GameWorldProxy(this));
								return;
							}
						}
					}
				}
			}
		}
		System.out.println("No hit detected");// if no instance is found, tell user no crash has been detected
		
	}
	
	public void tickClock(long timeInput)
	{
		// increase the game clock by one tick, with each tick move all moveable objects
		boolean secondPassed = false;
		long calcT = (timeInput % 1000L);
		System.out.print(calcT);
		if (calcT > 950L)
		{
			time++;
			calcT = 0;
			secondPassed = true;
		}
		else
			secondPassed = false;
		IIterator i = go.getIterator();
		while(i.hasNext())
		{
			i.getNext();
			if (i.getObject() instanceof MoveObject)
			{
				MoveObject mO = (MoveObject)i.getObject();
				mO.move();
			}
			
			if (i.getObject() instanceof SpaceStation)
			{
				if (secondPassed)
				{
					SpaceStation ss = (SpaceStation)i.getObject();
					ss.blink(time);
				}
				
				//check if spacestation needs to blink on or off
			}
			if (i.getObject() instanceof Missile)
			{
				Missile m = (Missile)i.getObject();
				if(secondPassed)
				{
					m.decrementFuel();
					if (m.getFuelLevel() <= 0)
					{
						go.remove(m);
						i.dec();
					}
				}
				
					
				
				//if the moveable object was a missile, decrease its fuel level and if it becomes 0 remove the missile
			}
		}
		System.out.println("Game clock has ticked");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	public void displayMap()
	{
		// loop through all of the game world objects and call their to string functions
		// each toString will retrieve the objects relative information
		IIterator i = go.getIterator();
		while(i.hasNext())
		{
			System.out.println(i.getNext());
		}
		//not used but served for legacy purposes
			
	}
	
	
	public void quit()
	{
		//user exits the game
		System.exit(0);
	}
	@Override
	
	public int getScore() {return this.gameScore;}
	public int getLives() {return this.lives;}
	public int getTime() {return this.time;}
	public int getMissileCount() {
		IIterator i = go.getIterator();
		while (i.hasNext())
		{
			if(i.getNext() instanceof PlayerShip)
			{//find the player ship in game collection
				PlayerShip ps = (PlayerShip)i.getObject();
				return ps.missileCount;//return its missile count
			}
		}
			
		
	return 0;	
	}
	@Override
	public boolean getSound() {
		// TODO Auto-generated method stub
		return soundOn;
	}
	public void changeSound()
	{
		if (soundOn == true)
		{
			soundOn = false;
		}
		else
			soundOn = true;
		
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	public void newGame()
	{
		go = new GameCollection();
		init();
	}
	
	public void checkCollisions()
	{
		Vector<GameObject> rObjs = new Vector<GameObject>();
		IIterator i = go.getIterator();
		while(i.hasNext())
		{
			GameObject o = (GameObject)i.getNext();
			IIterator j = go.getIterator();
			while (j.hasNext())
			{
				GameObject k = (GameObject)j.getNext();
				if (o.collidesWith(k))
				{
					if ((o instanceof Asteroid) && (k instanceof Asteroid))
					{
						
						rObjs.add(o);
						rObjs.add(k);
					}
					if ((o instanceof Asteroid) && (k instanceof Missile))
					{
						Missile m = (Missile)k;
						if (m.owner == 'P')
						{
							gameScore++;
						}
						rObjs.add(o);
						rObjs.add(k);
					}
					if ((o instanceof NonPlayerShip) && (k instanceof Missile))
					{
						Missile m = (Missile)k;
						if (m.owner == 'P')
						{
							gameScore++;
						}
						rObjs.add(o);
						rObjs.add(k);
					}
					if ((o instanceof NonPlayerShip) && (k instanceof NonPlayerShip))
					{
						rObjs.add(o);
						rObjs.add(k);
					}
					if ((o instanceof PlayerShip) && (k instanceof Asteroid))
					{
						rObjs.add(o);
						rObjs.add(k);
						lives--;
					}
					if ((o instanceof PlayerShip) && (k instanceof NonPlayerShip))
					{
						rObjs.add(o);
						rObjs.add(k);
						lives--;
					}
					if ((o instanceof SpaceStation) && (k instanceof PlayerShip))
					{
						PlayerShip p = (PlayerShip)k;
						p.reload();
					}
				}
			}
		}
		
		for(int k = 0; k < rObjs.size(); k++)
		{
			GameObject o = rObjs.elementAt(k);
			o.handleCollision();
			go.remove(o);
		}
	}
	
}
