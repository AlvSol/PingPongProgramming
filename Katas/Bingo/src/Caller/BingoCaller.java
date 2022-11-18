package Caller;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BingoCaller {
	List<Integer> numbers;
	
	static int Limit_Number = 75;
	public BingoCaller() {
		this.numbers= new ArrayList<>();
		for(int i=1;i<=Limit_Number;i++) {
			numbers.add(i);	
		}
	}
	
	public int showNumber() {
		Random rand = new Random();
		int posAlt =rand.nextInt(this.numbers.size());
		int res = numbers.get(posAlt);		
		numbers.remove(posAlt);
		return res;
	}
	
	
}
