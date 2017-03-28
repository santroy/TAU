package pl.edu.pjatk.tau;

import org.easymock.EasyMock;
import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AlarmClockTest {
	
	@TestSubject
	private AlarmClock alarm = new AlarmClock();
	
	@Mock
	ITime time;
	
	@Rule
	public EasyMockRule rule = new EasyMockRule(this);
	
	@Test
	public void alarmShouldRingOneTimeForOneTimeTest() {
		
		Time t1 = new Time(22,0);
		Time t2 = new Time(23,0);
		alarm.setCurrentTime(t1);
		
		EasyMock.expect(time.getTime()).andReturn(t1).times(3).andReturn(t2);
		replay(time);
		alarm.addAlarmTime(t1);
		assertEquals(alarm.shouldRing(),true);
		assertEquals(alarm.shouldRing(),false);
		assertEquals(alarm.shouldRing(),false);
		alarm.setCurrentTime(t2);
		alarm.addAlarmTime(t2);
		assertEquals(alarm.shouldRing(),true);
		verify(time);
		
	}
	

}
