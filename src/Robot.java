import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public class Robot {	
	World world;
	BodyDef bd; 
	FixtureDef fd;
	PolygonShape botShape;
	Body robot;
	float timeStep = 1.0f/60.0f;	
    int velocityIterations = 6, positionIterations = 2;
	public Robot() {
		timeStep = 1.0f/60.0f;
		world = new World(new Vec2(0,0),true);
		bd = new BodyDef();
			bd.position.set(0,0);
		bd.type = BodyType.DYNAMIC;
		botShape = new PolygonShape();
		botShape.setAsBox(0.5f, 0.5f);		
		fd = new FixtureDef();
			fd.shape = botShape;
			fd.density = 1f;
			fd.friction = 0.3f;        
			fd.restitution = 0.5f;
		robot = world.createBody(bd);
		robot.createFixture(fd);	
		robot.setLinearDamping(0.3f);
	}
	
	public void set(float input) {
		Vec2 force = new Vec2(input,0f);
		robot.applyForce(force, robot.getWorldPoint(robot.getWorldCenter()));
	}
	
	public void step() {
		world.step(timeStep, velocityIterations, positionIterations);
	}
	
	public float getPosition() {
		return robot.getPosition().x;
	}
}

