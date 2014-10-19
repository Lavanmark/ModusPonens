package modusponens.model;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;


//PLATFORM GENERIC STATIC
public class PlatformGenSta {

	// used to keep track of objects
	private String name;
	// this is full length. if you want a 50x50 square length = 50 width = 50
	// must divide by two for jboz
	private int length, height;
	//these values are the center of the object
	private int x,y;
	//name 
	private String imageName;
	
	private BodyDef bDef = new BodyDef();
	private PolygonShape pShape = new PolygonShape();
	private FixtureDef fDef = new FixtureDef();
	private Body platform;
	
	
	public PlatformGenSta(String platName){
		name = platName;
	}
	public PlatformGenSta(String platName, int platLength, int platHeight, int platX, int platY){
		name = platName;
		length = platLength;
		height = platHeight;
		x = platX;
		y = platY;
	}
	public PlatformGenSta(String platName, int platLength, int platHeight, int platX, int platY, String platImageName){
		name = platName;
		length = platLength;
		height = platHeight;
		x = platX;
		y = platY;
		imageName = platImageName;
	}
	
	public void initializePlat(float friction, float restitution, float density, World w){
		bDef.position.set(new Vec2(x,y));
		//static because GenSta
		bDef.type = BodyType.STATIC;
		pShape.setAsBox(length/2, height/2);
		fDef.shape = pShape;
		fDef.density = density;
		fDef.restitution = restitution;
		fDef.friction = friction;
		platform = w.createBody(bDef);
		platform.createFixture(fDef);
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
		return platform;
	}
	public int getLength(){
		return length;
	}
	public int getHeight(){
		return height;
	}
	
	
	
}
