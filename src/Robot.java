import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.World;

public class Robot {
	World world;
	BodyDef bd;
	PolygonShape bot;
	public Robot() {
		world = new World(new Vec2(0,0),true);
		bd = new BodyDef();
		bd.position.set(0,0);
		bd.type = BodyType.DYNAMIC;
		bot = new PolygonShape();
		bot.setAsBox(0.5f, 0.5f);
		
		
	}
}

