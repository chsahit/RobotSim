public class Simulator {

	public static void main(String[] args) {
		Robot robot = new Robot();
		Logger logger = new Logger();
		logger.init();
		float setpoint = 40;
		float error = 0, kP = 0.2f;
		for(int i = 0; i < 2200; i++) {
			error = setpoint - robot.getPosition();
			robot.set(error * kP);
			robot.step();
			logger.writeData(robot.getPosition());
			System.out.println(robot.robot.getPosition().x + " " + robot.robot.getPosition().y);
		}		
		logger.close();
		System.out.println(error * kP);
		System.out.println("END");
		//System.out.println(robot.floor.getContactList().toString());
	}

}
