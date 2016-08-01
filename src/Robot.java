import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public class Robot {	
	World world;
	BodyDef bdRobot, bdFloor; 
	FixtureDef fdRobot, fdFloor;
	PolygonShape botShape, floorShape;
	Body robot, floor;
	float timeStep = 1.0f/60.0f;	
    int velocityIterations = 6, positionIterations = 2;
	public Robot() {
		//create world
		timeStep = 1.0f/60.0f;
		world = new World(new Vec2(0,-10.0f),true);
		//create robot
		bdRobot = new BodyDef();
			bdRobot.position.set(0,0);
		bdRobot.type = BodyType.DYNAMIC;
		botShape = new PolygonShape();
		botShape.setAsBox(0.5f, 0.5f);		
		fdRobot = new FixtureDef();
			fdRobot.shape = botShape;
			fdRobot.density = 1f;
			fdRobot.friction = 0.25f;        
			fdRobot.restitution = 0.0f;
		robot = world.createBody(bdRobot);
		robot.createFixture(fdRobot);	
		robot.setLinearDamping(0.3f);
		//create floor
		floorShape = new PolygonShape();
		fdFloor = new FixtureDef();
			fdFloor.shape = floorShape;
			fdFloor.density = 1;
			fdFloor.friction = 0.25f;
		bdFloor = new BodyDef();
			bdFloor.type = BodyType.STATIC;
			bdFloor.position.set(-10f, -0.5f);
		floor = world.createBody(bdFloor);
		floorShape.setAsEdge(new Vec2(-0.5f,0f), new Vec2(200f, 0f));
		floor.createFixture(fdFloor);
		System.out.println();
		
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

