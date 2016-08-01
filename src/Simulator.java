public class Simulator {

	public static void main(String[] args) {
		Robot robot = new Robot();		
		Logger.init();
		float setpoint = 40;
		float error = 0, kP = 0.2f;
		for(int i = 0; i < 2200; i++) {
			error = setpoint - robot.getPosition();
			robot.set(error * kP);
			robot.step();
			Logger.writeData(robot.getPosition());
			System.out.println(robot.robot.getPosition().x + " " + robot.robot.getPosition().y);
		}		
		Logger.close();
		System.out.println(error * kP);
		System.out.println("END");
		//System.out.println(robot.floor.getContactList().toString());
	}
	
	public static void p_loop() {
		
	}

}
