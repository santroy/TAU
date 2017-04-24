package pl.edu.pjatk.tau;

import org.junit.runner.RunWith;


import static org.junit.Assert.*;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;


import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class AlarmClockTest extends TestCase {

	
	Time time = mock(Time.class);
	
	AlarmClock alarm = spy(new AlarmClock());
		
	@Test
    public void AlarmWorksTest(){
		alarm = new AlarmClock();
		Time t1 = new Time(9,0);
		alarm.addAlarmTime(t1);
		alarm.setCurrentTime(t1);
        when(time.getTime().toString()).thenReturn("90");

        alarm.addAlarmTime(time);
        assertTrue(alarm.shouldRing());
        assertFalse(alarm.shouldRing());
    }
	
	     
	
}