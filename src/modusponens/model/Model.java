package modusponens.model;

import modusponens.model.player.Player;
import modusponens.model.player.Wilbert;
import modusponens.model.scenery.PlatformGenSta;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;


public class Model {

	//used to scale from jbox meter to pixels
	private static final float PIX_METER = 30;
	//gravity in the world
	private Vec2 gravity = new Vec2(0.0f,9.81f);
	//variables used to control world updating and stepping
	private float timeStep = 1.0f/60.0f;
    private int velocityIterations = 8;
    private int positionIterations = 3;
    //the world
	public World world = new World(gravity);
	
	//scenery
	public PlatformGenSta floor;
	//characters
	public Player[] players;
	public int numOfPlayers = 1;
	public Wilbert wilbert;
	
	public Model(){
		//new Model("name",length,height,x,y)
		//init func (friction,restitution,density)
		wilbert = new Wilbert("Wilbert1", 10, 15, 500, 50);
		wilbert.initializeWilbert(0.1f, 0.01f, 0.09f, world);
		
		players = new Player[numOfPlayers];
		players[0] = wilbert;
		
		floor = new PlatformGenSta("floor", 600, 10, 400, 300);
		floor.initializePlat(0.2f, 0.5f, 1.0f, world);
		
	}
	
	
	public void update(){
		world.step(timeStep, velocityIterations, positionIterations);
	}
	
	public static float getConv(){
		return PIX_METER;
	}
}
