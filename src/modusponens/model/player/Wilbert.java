package modusponens.model.player;

import modusponens.model.Model;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.World;

public class Wilbert extends Player{

	
	
	
	
	
	
	public Wilbert(String wilbertName){
		name = wilbertName;
	}
	public Wilbert(String wilbertName, int wilbertLength, int wilbertHeight, int wilbertX, int wilbertY){
		name = wilbertName;
		length = wilbertLength;
		height = wilbertHeight;
		x = wilbertX;
		y = wilbertY;
	}
	public Wilbert(String wilbertName, int wilbertLength, int wilbertHeight, int wilbertX, int wilbertY, String wilbertImageName){
		name = wilbertName;
		length = wilbertLength;
		height = wilbertHeight;
		x = wilbertX;
		y = wilbertY;
		imageName = wilbertImageName;
	}
	
	public void initializeWilbert(float friction, float restitution, float density, World w){
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
