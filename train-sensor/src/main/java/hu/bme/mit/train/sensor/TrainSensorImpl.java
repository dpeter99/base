package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

/***
 * Detects the speed limit of the track
 */
public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
		checkSpeed(speedLimit,controller.getReferenceSpeed());
	}


	public void checkSpeed(int speedLimit, int refspeed){
		if(speedLimit < 0 || speedLimit > 500){
			user.setAlarmState(true);
		}
		else if (speedLimit < refspeed *0.5){
			user.setAlarmState(true);
		}

	}

}
