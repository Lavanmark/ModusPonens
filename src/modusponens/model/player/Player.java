package modusponens.model.player;

import modusponens.model.Model;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public class Player {

	// used to keep track of objects
	protected String name;
	// this is full length. if you want a 50x50 square length = 50 width = 50
	// must divide by two for jbox
	protected int length, height;
	//these values are the center of the object
	protected int x,y;
	//name of image
	protected String imageName;
	
	protected BodyDef bDef = new BodyDef();
	protected PolygonShape pShape = new PolygonShape();
	protected FixtureDef fDef = new FixtureDef();
	protected Body player;
	
	//Direction player is facing. 0 left. 1 right.
	protected int dir = 1;
	
	
	
	public Player(String playerName){
		name = playerName;
	}
	public Player(String playerName, int playerLength, int playerHeight, int playerX, int playerY){
		name = playerName;
		length = playerLength;
		height = playerHeight;
		x = playerX;
		y = playerY;
	}
	public Player(String playerName, int playerLength, int playerHeight, int playerX, int playerY, String playerImageName){
		name = playerName;
		length = playerLength;
		height = playerHeight;
		x = playerX;
		y = playerY;
		imageName = playerImageName;
	}
	
	public void initializePlayer(float friction, float restitution, float density, World w){
		//when dynamic it just goes to origin and doesn't work
		bDef.position.set(new Vec2(x/Model.getConv(),y/Model.getConv()));
		//static because GenSta
		bDef.type = BodyType.DYNAMIC;
		pShape.setAsBox(length/Model.getConv()/2, height/Model.getConv()/2);
		fDef.shape = pShape;
		fDef.density = density;
		fDef.restitution = restitution;
		fDef.friction = friction;
		player = w.createBody(bDef);
		player.createFixture(fDef);
	}
	
	public void moveLeft(){
		//make player face the left
		dir = 0;
		player.applyLinearImpulse(new Vec2(-0.001f,0.0f), player.getPosition());
		
	}
	public void stopMoveLeft(){
		player.setLinearDamping(100);
	}
	
	public int getDir(){
		return dir;
	}
	public String getName(){
		return name;
	}
	public void setName(String newName){
		name = newName;
	}
	public String getImageName(){
		return imageName;
	}
	public Body getBody(){
		return player;
	}
	public int getLength(){
		return length;
	}
	public int getHeight(){
		return height;
	}

	
}
