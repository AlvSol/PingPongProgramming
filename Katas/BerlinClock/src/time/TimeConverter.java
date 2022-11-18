package time;

import java.time.LocalTime;

public class TimeConverter {

	public static int ConvertToSeconds(String timeInput) {
		
		LocalTime time = LocalTime.parse(timeInput);
		int seconds = time.toSecondOfDay();
		
		return seconds;
	}
}
