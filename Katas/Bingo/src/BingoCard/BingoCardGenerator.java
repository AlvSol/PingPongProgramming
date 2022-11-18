package BingoCard;

import java.util.ArrayList;
import java.util.List;

import Caller.BingoCaller;

public class BingoCardGenerator {

	List<Integer>columB;
	List<Integer>columI;
	List<Integer>columN;
	List<Integer>columG;
	List<Integer>columO;
	
	
	
	public BingoCardGenerator() {
		this.columB = new ArrayList<Integer>();
		this.columI = new ArrayList<Integer>();
		this.columN = new ArrayList<Integer>();
		this.columG = new ArrayList<Integer>();
		this.columO = new ArrayList<Integer>();
		
		BingoCaller caller = new BingoCaller();
		fillColumn(columB, caller, false);
		fillColumn(columI, caller, false);
		fillColumn(columN, caller, true);
		fillColumn(columG, caller, false);
		fillColumn(columO, caller, false);
	}
	
	public void fillColumn(List<Integer> column, BingoCaller caller, boolean center) {
		
		int count = 5;
		if(center)
			count = 4;
		
		while(count > 0) {
			int num = caller.showNumber();
			column.add(num);
			count--;
		}
	}



	@Override
	public String toString() {
		return "BingoCardGenerator [columB=" + columB + ", columI=" + columI + ", columN=" + columN + ", columG="
				+ columG + ", columO=" + columO + "]";
	}

	public static void main(String[]args) {
		BingoCardGenerator gen = new BingoCardGenerator();
		System.out.println(gen.toString());
	}
}
