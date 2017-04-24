package pl.edu.pjatk.tau;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * To jest ta najwa�niejsza klasa do test�w behawioralnych kt�ra implementuje opowie�� (story)
 *
 * Zobacz, �e ta jedna klasa mo�e pasowa� do wielu opowie�ci.
 */

public class AlarmClockSteps {
    private AlarmClock alarm;
    Time time;

    @Given("there is the time $alarmTime to ring")
    public void createAlarm(String alarmTime){  
        alarm = new AlarmClock();
        given(time.getTime().toString()).willReturn(alarmTime);
    }

    @When("$alarmTime is set to Alarm Ring")
    public void setAlarm(String alarmTime) {
        	alarm.addAlarmTime(time);
    }

    @Then("Alarm should ring at $alarmTime")
    public void alarmRinged(String alarmTime) {
        assertTrue(alarm.shouldRing());
        verify(time).getTime().equals(alarmTime);
    }

}