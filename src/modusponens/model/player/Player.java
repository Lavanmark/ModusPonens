package modusponens.model.player;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.FixtureDef;

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
