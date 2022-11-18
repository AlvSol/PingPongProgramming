package time;
import java.util.*;

public class BerlinTime {
	
	private List<Row> rows = null;
	private static int FIVE_H_L=4;
	private static int ONE_H_L=4;
	private static int FIVE_M_L=11;
	private static int ONE_M_L=4;
	
	
	public BerlinTime() {
		super();
		this.rows = new ArrayList<Row>();
	}

	public void manageTime(int seconds) {
		int restSeconds = seconds;
		restSeconds = calcFiveHoursBlocks(restSeconds);
		restSeconds = calcOneHourBlocks(restSeconds);
		restSeconds = calcFiveMinBlocks(restSeconds);
		restSeconds = calcOneMinBlocks(restSeconds);
		restSeconds = calcOneSec(restSeconds);
		
	}
	
	public int calcFiveHoursBlocks(int seconds) {
		
		int restSecs = seconds;
		int countLamp = FIVE_H_L;
		
		while(restSecs >= Lamp.FIVE_BLOCK_SEC && countLamp>0) {
			restSecs -= Lamp.FIVE_BLOCK_SEC;
			countLamp--;
		}
		
		Row row = new Row(countLamp, Lamp.FIVE_BLOCK_SEC, FIVE_H_L-countLamp);
		rows.add(row);
		
		return restSecs;
	}
	
	public int calcOneHourBlocks(int seconds) {
		
		int restSecs = seconds;
		int countLamp = ONE_H_L;
		
		while(restSecs >= Lamp.ONE_BLOCK_SEC && countLamp>0) {
			restSecs -= Lamp.ONE_BLOCK_SEC;
			countLamp--;
		}
		
		Row row = new Row(countLamp, Lamp.ONE_BLOCK_SEC, ONE_H_L-countLamp);
		rows.add(row);
		
		return restSecs;
	}
	
	public int calcFiveMinBlocks(int seconds) {
		
		int restSecs = seconds;
		int countLamp = FIVE_M_L;
		
		while(restSecs >= Lamp.FIVE_MIN_BLOCK_SEC && countLamp>0) {
			restSecs -= Lamp.FIVE_MIN_BLOCK_SEC;
			countLamp--;
		}
		
		Row row = new Row(countLamp, Lamp.FIVE_MIN_BLOCK_SEC, FIVE_M_L-countLamp);
		rows.add(row);
		
		return restSecs;
	}
	
	public int calcOneMinBlocks(int seconds) {
		
		int restSecs = seconds;
		int countLamp = ONE_M_L;
		
		while(restSecs >= Lamp.ONE_MIN_BLOCK_SEC && countLamp>0) {
			restSecs -= Lamp.ONE_MIN_BLOCK_SEC;
			countLamp--;
		}
		
		Row row = new Row(countLamp, Lamp.ONE_MIN_BLOCK_SEC, ONE_M_L-countLamp);
		rows.add(row);
		
		return restSecs;
	}
	
	public int calcOneSec(int seconds) {
		
		Row row;
		if(seconds %2 == 0) {
			row = new Row(0, Lamp.ONE_SEC_BLOCK_SEC, 1);
		}else {
			row = new Row(1, Lamp.ONE_SEC_BLOCK_SEC, 0);
		}
		
		rows.add(row);		
		return seconds;
	}
	public String OneSecRow() {
		Row row = rows.get(4);
		String lamps = "";
		int count = row.getLamps_on();
		if(count > 0) {
				return "Y";
		}
		else {
				return "O";
		}
	}
	
	public String FiveHourRow() {
		Row row = rows.get(0);
		String lamps = "";
		int count = row.getLamps_on();
		
		for(int i = 0; i < FIVE_H_L; i++) {
			if(count > 0) {
				lamps = lamps + "R";
				count--;
			}
			else {
				lamps = lamps + "O";
			}
		}
		return lamps;
	}
	public String SingleHourRow() {
		Row row = rows.get(1);
		String lamps = "";
		int count = row.getLamps_on();
		
		for(int i = 0; i < ONE_H_L; i++) {
			if(count > 0) {
				lamps = lamps + "R";
				count--;
			}
			else {
				lamps = lamps + "O";
			}
		}
		
		return lamps;
	}
	
	public String FiveMinRow() {
		Row row = rows.get(2);
		String lamps = "";
		int count = row.getLamps_on();
		
		for(int i = FIVE_M_L; i >0; i--) {
			if(count > 0) {
				if(i%3 == 0) {
					lamps = lamps + "R";
				}else {
					lamps = lamps + "Y";
				}
				
				count--;
			}
			else {
				lamps = lamps + "O";
			}
		}
		
		return lamps;
	}
	
	public String SingleMinRow() {
		Row row = rows.get(3);
		String lamps = "";
		int count = row.getLamps_on();
		
		for(int i = 0; i < ONE_M_L; i++) {
			if(count > 0) {
				lamps = lamps + "Y";
				count--;
			}
			else {
				lamps = lamps + "O";
			}
		}
		
		return lamps;
	}
	
	@Override
	public String toString() {
		
		return this.OneSecRow()+this.FiveHourRow()+this.SingleHourRow()+this.FiveMinRow()+this.SingleMinRow();
	}

	public static void main(String[] args) {
		
		BerlinTime clock = new BerlinTime();
		String time1 = "12:23:00";
		String time2 = "23:59:59";
		String time3 = "00:00:00";
		String time4 = "02:04:00";
		String time=time3;
		
		int seconds = TimeConverter.ConvertToSeconds(time);
		clock.manageTime(seconds);
		System.out.println(clock.SingleMinRow());
		System.out.println(clock.FiveMinRow());
		System.out.println(clock.SingleHourRow());
		System.out.println(clock.FiveHourRow());
		System.out.println(clock.OneSecRow());
		System.out.println(clock.toString());

	}

}
