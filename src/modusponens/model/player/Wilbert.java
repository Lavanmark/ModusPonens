package modusponens.model.player;

import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

public class Wilbert extends Player{

	
	
	
	
	
	
	public Wilbert(String playerName) {
		super(playerName);
	}
	public Wilbert(String wilbertName, int wilbertLength, int wilbertHeight, int wilbertX, int wilbertY){
		super(wilbertName, wilbertLength, wilbertHeight, wilbertX, wilbertY);
	}
	public Wilbert(String wilbertName, int wilbertLength, int wilbertHeight, int wilbertX, int wilbertY, String wilbertImageName){
		super(wilbertName, wilbertLength, wilbertHeight, wilbertX, wilbertY, wilbertImageName);
	}
	public void initializeWilbert(float friction, float restitution, float density, World w){
		super.initializePlayer(friction, restitution, density, w);
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
		return super.player;
	}
	public int getLength(){
		return length;
	}
	public int getHeight(){
		return height;
	}



	
}
