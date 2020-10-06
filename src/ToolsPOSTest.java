import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

class ToolsPOSTest {

	@Test
	void testCheckout() {
		fail("Not yet implemented");
	}

	@Test
	void testCountChargeDays() {
		fail("Not yet implemented");
	}

	@Test
	void testIsDateHoliday() {
		fail("Not yet implemented");
	}

	@Test
	void testIsDateWeekend() {
		ToolsPOS pos = new ToolsPOS();
		String pattern = "MM/dd/yy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(simpleDateFormat.parse("10/05/20"));
		} catch (ParseException e) {
			fail("date parse error");
		}
		if (pos.isDateWeekend(calendar)) {
			fail("Monday 10-5 is not a weekend");
		}
		
		pass("all dates identified");
	}

}
