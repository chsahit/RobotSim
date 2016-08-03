import java.util.LinkedList;
import java.util.Queue;

public class PIDLoop {
	float kP, kI, kD;
	float setpoint;
	float lasttime = -1, lasterror;
	float error, netError = 0, dError;
	Queue<Float> lookback; 
	Profile profile;
	public PIDLoop(float kP, float kI, float kD, float sp) {
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
		this.setpoint = sp;
		lasterror = setpoint;
		lookback = new LinkedList<Float>();
	}
	
	public PIDLoop(float kP, float kI, float kD, Profile profile) {
		this(kP, kI, kD, profile.sp);
		this.profile = profile;
	}
	
	public float getIdealOutput(float position, float time) {
		error = setpoint - position;
		netError += ((time - lasttime) * error);
		dError = ((error - lasterror)/(time - lasttime));
		System.out.println(dError + " " + (time - lasttime));
		lasttime = time;
		lasterror = error;
		return ((error * kP) + (netError * kI) + (dError * kD));
	}
	
	public float getIdealOutputWithLookback(float position, float time) {
		error = setpoint - position;
		lookback.add((time - lasttime) * error);
		if (lookback.size() > 300) {
			lookback.poll();
		}
		netError = sum(lookback);
		dError = ((error - lasterror)/(time - lasttime));
		System.out.println(dError + " " + (time - lasttime));
		lasttime = time;
		lasterror = error;
		Logger.writeData((error * kP) + "," + (netError * kI) + "," + 
				(dError * kD) + "," + position);
		return ((error * kP) + (netError * kI) + (dError * kD));
	}
	
	public float getStandardOutput(float position, float time) {
		float error = setpoint - position;
		if(position < 0.8 * setpoint) {
			Logger.writeData((kP * error) + ",0,0," + position);
			return (kP * error);
		} else {
			lookback.add((time - lasttime) * error);
			if (lookback.size() > 750) {
				lookback.poll();
			}
			netError = sum(lookback);
			dError = ((error - lasterror)/(time - lasttime));
			lasttime = time;
			lasterror = error;
			Logger.writeData(0 + "," + (netError * kI) + "," + 
					(dError * kD) + "," + position);
			return ((netError * kI) + (dError * kD));
		}
		
	}
	
	public float getProfiledOutput(float position, float time) {
		assert profile != null;		
		return 0f;
	}
	
	private float sum(Queue<Float> list) {
		float sum = 0;
		for (Float f: list) {
			sum += f;
		}
		return sum;
	}
}
