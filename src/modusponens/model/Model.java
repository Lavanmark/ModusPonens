package modusponens.model;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;


public class Model {

	
	public World world = new World(new Vec2(0.0f,9.81f));
	public BodyDef bdef = new BodyDef();
	public CircleShape cShape = new CircleShape();
	public PolygonShape pShape = new PolygonShape();
	public FixtureDef fDef = new FixtureDef();
	public Body ground;
	public Body bod;
	
	public Model(){
		bdef.position.set(new Vec2(50,50));
		bdef.type = BodyType.DYNAMIC;
		
		
		cShape.m_radius = 5f;
		
		
		fDef.shape = cShape;
		fDef.density = .01f;
		fDef.friction = .0f;
		fDef.restitution = .5f;
		
		bod = world.createBody(bdef);
		bod.createFixture(fDef);
		
		bdef.position.set(new Vec2(40,300));
		bdef.type = BodyType.STATIC;
		
		pShape.setAsBox(600, 50);
		
		fDef.shape = pShape;
		fDef.density = 1.0f;
		fDef.restitution = 0.5f;
		ground = world.createBody(bdef);
		ground.createFixture(fDef);
		
	}
	float timeStep = 1.0f/19.0f;
    int velocityIterations = 8;
    int positionIterations = 3;
	public void update(){
		world.step(timeStep, velocityIterations, positionIterations);
		
		
	}
}
