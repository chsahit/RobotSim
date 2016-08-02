public class Simulator {

	public static void main(String[] args) {
		Robot robot = new Robot();		
		IdealPIDLoop pid = new IdealPIDLoop(0.2f, 0.001f, 3f, 40);
		Logger.init();
		float output;
		for(int i = 0; i < 4200; i++) {
			output = pid.getOutputWithLookback(robot.getPosition(), i);
			robot.set(output);
			robot.step();
			
		}
		Logger.close();
		System.out.println("END");
		System.out.println(robot.robot.getLinearVelocity().x);
	}

}
