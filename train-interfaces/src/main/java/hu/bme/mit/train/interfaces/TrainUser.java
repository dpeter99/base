package hu.bme.mit.train.interfaces;

public interface TrainUser {

	int getJoystickPosition();

	@Deprecated
	boolean getAlarmFlag();

	boolean getAlarmState();
	void setAlarmState(boolean value);

	void overrideJoystickPosition(int joystickPosition);

}
