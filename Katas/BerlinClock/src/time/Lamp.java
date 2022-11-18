package time;

public abstract class Lamp {

	public static int FIVE_BLOCK_SEC=18000;
	public static int ONE_BLOCK_SEC=3600;
	public static int FIVE_MIN_BLOCK_SEC=300;
	public static int ONE_MIN_BLOCK_SEC=60;
	public static int ONE_SEC_BLOCK_SEC=1;
	
	private boolean state=false;
	
	public  boolean getState() {
		return state;
	}
	public abstract int getSecondsUsed();
}
