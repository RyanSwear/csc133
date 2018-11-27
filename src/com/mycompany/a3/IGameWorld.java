package com.mycompany.a3;

import com.codename1.ui.geom.Point2D;

public interface IGameWorld {
	
	void addAsteroid();
	void addNPS();
	void addPS();
	void addStation();
	void asteroidCrashAsteroid();
	void asteroidNPSCollision();
	void decreasePlayerSpeed();
	void displayMap();
	void eliminate();
	void firePlayerMissile();
	int getLives();
	int getScore();
	int getTime();
	int getMissileCount();
	boolean getSound();
	boolean getPause();
	void changePause();
	void increasePlayerSpeed();
	void init();
	void jumpToHyperSpace();
	void launchNPSMissiles();
	void missileAsteroidCrash();
	void playerAsteroidCrash();
	void playerCrashNPS();
	void playerShipTurnLeft();
	void playerShipTurnRight();
	void psHitByMissile();
	void quit();
	void refillPSMissiles();
	void tickClock(long i);
	void turnMissileLauncherLeft();
	void turnMissileLauncherRight();
	GameCollection getGameObjects();
	void changeSound();
	void displayGameDimension();
	Point2D getMins();
}
