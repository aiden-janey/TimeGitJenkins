package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	//GetTotalSeconds() Tests
	@Test
	void testGetTotalSecondsGood() {
		int seconds = Time.getTotalSeconds("05:05:05");
		assertTrue("The seconds were not calculated properly", seconds==18305);
	}
	@Test
	void testGetTotalSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()->{Time.getTotalSeconds("10:00");});
	}
	@ParameterizedTest
	@ValueSource(strings = {"99:00:00", "00:59:00", "00:59:59"})
	void testGetTotalSecondsBoundary(String candidate) {
		int seconds = Time.getTotalSeconds(candidate);
		assertTrue("The seconds were not between 0 and 359999", seconds <= 359999 && seconds >= 0);
	}

	//GetSeconds() Test
	@Test
	void testGetSecondsGood() {
		int seconds = Time.getSeconds("05:05:59");
		assertTrue("The seconds weren't calculated properly", seconds==59);
	}
	@Test
	void testGetSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()->{Time.getSeconds("10:00");});
	}
	@Test
	void testGetSecondsBoundary() {
		int seconds = Time.getSeconds("05:05:59");
		assertTrue("The seconds were not between 0 and 60", seconds < 60 && seconds >= 0);
	}
	
	//GetTotalMinutes() Tests
	@Test
	void testGetTotalMinutesGood() {
		int minutes = Time.getTotalMinutes("05:59:05");
		assertTrue("The minutes weren't calculated propery", minutes==59);
	}
	@Test
	void testGetTotalMinutesBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()->{Time.getTotalMinutes("10");});
	}
	@Test
	void testGetTotalMinutesBoundary() {
		int minutes = Time.getTotalMinutes("05:59:05");
		assertTrue("The minutes were not between 0 and 60", minutes < 60 && minutes >= 0);
	}
	
	//GetTotalHours() Tests
	@Test
	void testGetTotalHoursGood() {
		int hours = Time.getTotalHours("99:05:05");
		assertTrue("The hours weren't calculated properly", hours==99);
	}
	@Test
	void testGetTotalHoursBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()->{Time.getTotalHours("");});
	}
	@Test
	void testGetTotalHoursBoundary() {
		int hours = Time.getTotalHours("99:05:05");
		assertTrue("The hours were not between 0 and 99", hours <= 99 && hours >= 0);
	}

	//GetMilliseconds() Tests
	@Test
	void testGetMillisecondsGood() {
		int ms = Time.getMilliseconds("12:05:05:005");
		assertTrue("The milliseconds weren't calculated properly", ms==5);
	}
	@Test
	void testGetMillisecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()->{Time.getMilliseconds("10:00:00");});
	}
	@Test
	void testGetMillisecondsBoundary() {
		int ms = Time.getMilliseconds("12:05:05:999");
		assertTrue("The milliseconds were not between 0 and 999", ms <= 999 && ms >= 0);
	}
	
	//GetTotalMilliseconds Tests
	@Test
	void testGetTotalMillisecondsGood() {
		int ms = Time.getTotalMilliseconds("05:05:05:005");
		assertTrue("The total milliseconds weren't calculated properly", ms==18305005);
	}
	@Test
	void testGetTotalMillisecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()->{Time.getTotalMilliseconds("10:00:00");});
	}
	@Test
	void testGetTotalMillisecondsBoundary() {
		int ms = Time.getTotalMilliseconds("99:60:60:999");
		assertTrue("The total milliseconds were not between 0 and 360060999", ms <= 360060999 && ms >= 0);
	}
}
