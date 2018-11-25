package com.mycompany.a3;

import java.util.Iterator;
import java.util.Observable;

import com.codename1.ui.geom.Point2D;

public class GameWorldProxy extends Observable implements IGameWorld{
	private GameWorld realGameWorld;
	public GameWorldProxy(GameWorld gw)
	{
		this.realGameWorld = gw;
		//init();
	}

	
	public Point2D getMins()
	{
		return realGameWorld.getMins();
	}
	@Override
	public void addAsteroid() {
		// TODO Auto-generated method stub
		realGameWorld.addAsteroid();
		notifyObservers(realGameWorld);
	}

	@Override
	public void addNPS() {
		// TODO Auto-generated method stub
		realGameWorld.addNPS();
	}

	@Override
	public void addPS() {
		// TODO Auto-generated method stub
		realGameWorld.addPS();
	}

	@Override
	public void addStation() {
		// TODO Auto-generated method stub
		realGameWorld.addStation();
	}

	@Override
	public void asteroidCrashAsteroid() {
		// TODO Auto-generated method stub
		realGameWorld.asteroidCrashAsteroid();
	}

	@Override
	public void asteroidNPSCollision() {
		// TODO Auto-generated method stub
		realGameWorld.asteroidNPSCollision();
	}

	@Override
	public void decreasePlayerSpeed() {
		// TODO Auto-generated method stub
		realGameWorld.decreasePlayerSpeed();
	}

	@Override
	public void displayMap() {
		// TODO Auto-generated method stub
		realGameWorld.displayMap();
	}

	@Override
	public void eliminate() {
		// TODO Auto-generated method stub
		realGameWorld.eliminate();
	}

	@Override
	public void firePlayerMissile() {
		// TODO Auto-generated method stub
		realGameWorld.firePlayerMissile();
	}

	@Override
	public int getLives() {
		// TODO Auto-generated method stub
		return realGameWorld.getLives();
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return realGameWorld.getScore();
	}

	@Override
	public int getTime() {
		// TODO Auto-generated method stub
		return realGameWorld.getTime();
	}

	@Override
	public void increasePlayerSpeed() {
		// TODO Auto-generated method stub
		realGameWorld.increasePlayerSpeed();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		realGameWorld.init();
	}

	@Override
	public void jumpToHyperSpace() {
		// TODO Auto-generated method stub
		realGameWorld.jumpToHyperSpace();
	}

	@Override
	public void launchNPSMissiles() {
		// TODO Auto-generated method stub
		realGameWorld.launchNPSMissiles();
	}

	@Override
	public void missileAsteroidCrash() {
		// TODO Auto-generated method stub
		realGameWorld.missileAsteroidCrash();
	}

	@Override
	public void playerAsteroidCrash() {
		// TODO Auto-generated method stub
		realGameWorld.playerAsteroidCrash();
	}

	@Override
	public void playerCrashNPS() {
		// TODO Auto-generated method stub
		realGameWorld.playerCrashNPS();
	}

	@Override
	public void playerShipTurnLeft() {
		// TODO Auto-generated method stub
		realGameWorld.playerShipTurnLeft();
	}

	@Override
	public void playerShipTurnRight() {
		// TODO Auto-generated method stub
		realGameWorld.playerShipTurnRight();
	}

	
	@Override
	public void psHitByMissile() {
		// TODO Auto-generated method stub
		realGameWorld.psHitByMissile();
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		realGameWorld.quit();
	}

	@Override
	public void refillPSMissiles() {
		// TODO Auto-generated method stub
		realGameWorld.refillPSMissiles();
	}

	@Override
	public void tickClock(long i) {
		// TODO Auto-generated method stub
		realGameWorld.tickClock(i);
	}

	@Override
	public void turnMissileLauncherLeft() {
		// TODO Auto-generated method stub
		realGameWorld.turnMissileLauncherLeft();
	}

	@Override
	public void turnMissileLauncherRight() {
		// TODO Auto-generated method stub
		realGameWorld.turnMissileLauncherRight();
	}

	@Override
	public int getMissileCount() {
		// TODO Auto-generated method stub
		return realGameWorld.getMissileCount();
	}

	@Override
	public boolean getSound() {
		// TODO Auto-generated method stub
		return realGameWorld.getSound();
	}
	public GameCollection getGameObjects()
	{
		return realGameWorld.getGameObjects();
	}
	@Override
	public void changeSound()
	{
		realGameWorld.changeSound();
	}
	public void newGame()
	{
		realGameWorld.newGame();
	}
	public void displayGameDimension()
	{
		realGameWorld.displayGameDimension();
	}

}
