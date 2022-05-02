package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    @Before
    public void before() {
        // TODO Add initializations
    }

    @Test
    public void SpeedLimitIsAcceptable() {
        RunTest(200,300,false);
    }

    @Test
    public void SpeedLimitIsTooSmallComparedToRefSpeed() {
        RunTest(10,300,true);
    }

    @Test
    public void SpeedLimitIsTooLarge() {
        RunTest(600,200,true);
    }

    @Test
    public void SpeedLimitIsTooSmall() {
        RunTest(-10,200,true);
    }

    public void RunTest(int speedLimit, int speedReference, boolean alarm){
        TrainUser user = mock(TrainUser.class);
        TrainController controller = mock(TrainController.class);

        when(controller.getReferenceSpeed()).thenReturn(speedReference);


        TrainSensorImpl sensor = new TrainSensorImpl(controller,user);

        sensor.overrideSpeedLimit(speedLimit);

        if(alarm)
            verify(user).setAlarmState(true);
        else
            verify(user, never()).setAlarmState(true);

    }

}
