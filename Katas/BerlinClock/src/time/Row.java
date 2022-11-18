package time;

public class Row {
	
	private int lamps_on;
	private int lamps_off;
	private int timeUsed;
	
	public Row(int lamps_off, int timeUsed,int lamps_on) {
		super();
		this.lamps_off = lamps_off;
		this.timeUsed = timeUsed;
		this.lamps_on = lamps_on;
	}

	public int getLamps_on() {
		return lamps_on;
	}

	public void setLamps_on(int lamps_on) {
		this.lamps_on = lamps_on;
	}

	public int getLamps_off() {
		return lamps_off;
	}

	public void setLamps_off(int lamps_off) {
		this.lamps_off = lamps_off;
	}

	public int getTimeUsed() {
		return timeUsed;
	}

	public void setTimeUsed(int timeUsed) {
		this.timeUsed = timeUsed;
	}

	

}
