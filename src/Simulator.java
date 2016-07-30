public class Simulator {

	public static void main(String[] args) {
		Robot robot = new Robot();
		Logger logger = new Logger();
		logger.init();
		for(int i = 0; i < 60; i++) {
			robot.set(10f);
			robot.step();
			logger.writeData(robot.getPosition());
		}
		logger.close();
	}

}
