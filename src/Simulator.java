public class Simulator {

	public static void main(String[] args) {
		Robot robot = new Robot();		
		Logger.init();
		testPLoop(robot);
		Logger.close();
		System.out.println("END");
		System.out.println(robot.robot.getLinearVelocity().x);
		//System.out.println(robot.floor.getContactList().toString());
	}
	
	public static void testPLoop(Robot robot) {
		float setpoint = 40;
		float error = 0, kP = 0.2f;
		for(int i = 0; i < 800; i++) {
			error = setpoint - robot.getPosition();
			robot.set(error * kP);
			robot.step();
			Logger.writeData(robot.getPosition());
			System.out.println(robot.robot.getPosition().x + " " + robot.robot.getPosition().y);
		}		
	}
	
	public static void testStaticF(Robot robot) {
		
	}

}
