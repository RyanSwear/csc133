
package com.mycompany.a3;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.UITimer;
import com.mycompany.a3.Commands.*;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent; 
import java.lang.String;
import java.util.Random;
class Game extends Form implements Runnable{
	private GameWorld gw;
	private GameWorldProxy gwp;
	private MapView mv;
	private PointsView pv;
	private CommandList cl;
	private UITimer u;
	private long start;
	public Game()
	{
		gw = new GameWorld();
		gwp = new GameWorldProxy(gw);
		cl = new CommandList(gwp);
		pv = new PointsView(gw);
		mv = new MapView(gw);
		
		//PointsView pv2 = new PointsView();
		gw.addObserver(pv);
		gw.addObserver(mv);
		PointerListener pl = new PointerListener();
		this.addPointerPressedListener(pl);
		//toolbar
		Toolbar myToolbar = new Toolbar();
		
		setToolbar(myToolbar);
		myToolbar.setTitle("Asteroid Game");
		// commands
		AddAsteroidCommand addAsteroid = new AddAsteroidCommand(gwp);
		myToolbar.addCommandToSideMenu(addAsteroid);
		
		AddSpaceStationCommand addStation = new AddSpaceStationCommand(gwp);
		myToolbar.addCommandToSideMenu(addStation);
		Command addPS = new AddPlayerShipCommand(gwp);
		myToolbar.addCommandToSideMenu(addPS);
		Command refillMissiles = new LoadAmmoCommand(gwp);
		myToolbar.addCommandToSideMenu(refillMissiles);
		Command missileAsteroidC = new KillAsteroidCommand(gwp);
		myToolbar.addCommandToSideMenu(missileAsteroidC);
		Command shipCrash = new PlayerCrashCommand(gwp);
		myToolbar.addCommandToSideMenu(shipCrash);
		Command astCollision = new AsteroidCollisionCommand(gwp);
		myToolbar.addCommandToSideMenu(astCollision);
		Command clockTick = new ClockTickCommand(gwp);
		myToolbar.addCommandToSideMenu(clockTick);
		Command soundCheck = new SoundCommand(gwp);
		CheckBox soundCheckBox = new CheckBox("Sound");
		soundCheckBox.getAllStyles().setBgTransparency(255);
		soundCheckBox.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		soundCheck.putClientProperty("SideComponent", soundCheckBox);
		myToolbar.addCommandToSideMenu(soundCheck);
		Command cquit = new QuitCommand(gwp);
		myToolbar.addCommandToSideMenu(cquit);
		//overflow menu
		Command newOverflow = new NewCommand(gwp);
		myToolbar.addCommandToOverflowMenu(newOverflow);
		Command saveOverflow = new Command("Save");
		myToolbar.addCommandToOverflowMenu(saveOverflow);
		Command undoOverflow = new Command("Undo");
		myToolbar.addCommandToOverflowMenu(undoOverflow);
		Command aboutOverflow = new AboutCommand(gwp);
		myToolbar.addCommandToOverflowMenu(aboutOverflow);
		SoundCommand soundOverflow = new SoundCommand(gwp);
		myToolbar.addCommandToOverflowMenu(soundOverflow);
		QuitCommand quitOverflow = new QuitCommand(gwp);
		myToolbar.addCommandToOverflowMenu(quitOverflow);
		
		
		//adding keyListeners
		addKeyListener(-91, new IncreaseSpeedCommand(gwp));
		addKeyListener(-92, new DecreaseSpeedCommand(gwp));
		addKeyListener(-93, new TurnLeft(gwp));
		addKeyListener(-94, new TurnRight(gwp));
		addKeyListener(-90, new FireMissileCommand(gwp));
		addKeyListener(44, new RotateGunLeftCommand(gwp));
		addKeyListener(46, new RotateGunRightCommand(gwp));
		addKeyListener('j', new HyperspaceCommand(gwp));
		addKeyListener('y', new AddNPSCommand(gwp));
		
		this.setLayout(new BorderLayout());
		add(BorderLayout.NORTH, pv);
		add(BorderLayout.WEST, cl);
		add(BorderLayout.CENTER, mv);
		//add(BorderLayout.SOUTH, pv2);
		
		u = new UITimer(this);//make the timer tick every second and bind it to this form
		u.schedule(50, true, this);
		start = System.currentTimeMillis();
		
		this.show();
		gw.setDimension(this.getWidth(), this.getHeight());
		gw.setMins(mv.getAbsoluteX(), mv.getAbsoluteY());
		gw.init();
		//play();
		
		
	}
	public class PointerListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(e.getEventType() + " x and y: " + e.getX() + " " + e.getY() + " " + e.getActualComponent().getName());
				
			}
		}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random ran = new Random();
		int r = ran.nextInt(100);
		if (r > 98)
		{
			//System.out.println(r);
			gw.addNPS();
			gw.addAsteroid();
		}
		
		if (r < 3)
		{
			gw.launchNPSMissiles();
		}
		gw.tickClock(System.currentTimeMillis() - start);
		gw.checkCollisions();
	}
	
	
}

