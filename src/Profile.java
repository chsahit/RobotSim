
public class Profile {
	public static final int kLinear = 0;
	public static final int kTrapezoidal = 1;
	int profileType;
	float sp;
	float maxVel;
	public Profile(int profileType, float setpoint, float maxVel) {
		this.profileType = profileType;
		this.sp = setpoint;
		this.maxVel = maxVel;
	}
	
	public float getDesiredPosition(float time) {
		if(profileType == kLinear) {
			
		} else if(profileType == kTrapezoidal) {
			
		}
		return 0f;
	}
}
