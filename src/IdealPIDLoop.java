import java.util.LinkedList;
import java.util.Queue;

public class IdealPIDLoop {
	float kP, kI, kD;
	float setpoint;
	float lasttime = -1, lasterror;
	float error, netError = 0, dError;
	Queue<Float> lookback; 
	public IdealPIDLoop(float kP, float kI, float kD, float sp) {
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
		this.setpoint = sp;
		lasterror = setpoint;
		lookback = new LinkedList<Float>();
	}
	
	public float getOutput(float position, float time) {
		error = setpoint - position;
		netError += ((time - lasttime) * error);
		dError = ((error - lasterror)/(time - lasttime));
		System.out.println(dError + " " + (time - lasttime));
		lasttime = time;
		lasterror = error;
		return ((error * kP) + (netError * kI) + (dError * kD));
	}
	
	public float getOutputWithLookback(float position, float time) {
		error = setpoint - position;
		lookback.add((time - lasttime) * error);
		if (lookback.size() > 100) {
			lookback.poll();
		}
		netError = sum(lookback);
		dError = ((error - lasterror)/(time - lasttime));
		System.out.println(dError + " " + (time - lasttime));
		lasttime = time;
		lasterror = error;
		return ((error * kP) + (netError * kI) + (dError * kD));
	}
	
	private float sum(Queue<Float> list) {
		float sum = 0;
		for (Float f: list) {
			sum += f;
		}
		return sum;
	}
}
