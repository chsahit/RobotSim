
public class IdealPIDLoop {
	float kP, kI, kD;
	float setpoint;
	float thistime, lasttime;
	float error;
	public IdealPIDLoop(float kP, float kI, float kD, float sp) {
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
		this.setpoint = sp;
	}
	
	public float getOutput(float position, float time) {
		for(int i = 0; i < 800; i++) {
			error = setpoint - position; 
		}		
		return (error * kP);
	}
}
