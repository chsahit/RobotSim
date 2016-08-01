public class Simulator {

	public static void main(String[] args) {
		Robot robot = new Robot();		
		IdealPIDLoop pid = new IdealPIDLoop(0.1f, 0.0004f, 3f, 40);
		Logger.init();
		float output;
		for(int i = 0; i < 4200; i++) {
			output = pid.getOutput(robot.getPosition(), i);
			robot.set(output);
			Logger.writeData(output + "," + robot.getPosition());
			robot.step();
			
		}
		Logger.close();
		System.out.println("END");
		System.out.println(robot.robot.getLinearVelocity().x);
	}

}
