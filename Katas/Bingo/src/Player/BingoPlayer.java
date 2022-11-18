package Player;

import java.util.ArrayList;
import java.util.List;

import BingoCard.BingoCardGenerator;
import Caller.BingoCaller;

public class BingoPlayer {

	private BingoCardGenerator cardGenerator;
	private int numbersOK;

	public BingoPlayer() {
		super();
		numbersOK=0;
		cardGenerator= new BingoCardGenerator();
	}
	public void checkNumber(int number) {
		
		if(cardGenerator.getColumB().contains(number)) {
			numbersOK++;
		}else if(cardGenerator.getColumI().contains(number)) {
			numbersOK++;
		}else if(cardGenerator.getColumN().contains(number)) {
			numbersOK++;
		}else if(cardGenerator.getColumG().contains(number)) {
			numbersOK++;
		}else if(cardGenerator.getColumO().contains(number)) {
			numbersOK++;
		}
	}
	public boolean isWinner() {
		return numbersOK==24;
	}
	
	@Override
	public String toString() {
		return "BingoPlayer [cardGenerator=" + cardGenerator + ", numbersOK=" + numbersOK + "]";
	}
	public static void main(String[]args) {
		
		BingoPlayer gen = new BingoPlayer();
		BingoPlayer gen2 = new BingoPlayer();
		BingoCaller arb = new BingoCaller();
		List<Integer> numbers = new ArrayList<Integer>();
		while(!gen.isWinner()&&!gen2.isWinner()) {
			int number = arb.showNumber();
			numbers.add(number);
			gen.checkNumber(number);
			if(!gen.isWinner()) {
				gen2.checkNumber(number);	
			}			
		}
		System.out.println(gen.toString());
		System.out.println(gen2.toString());
		System.out.println(numbers.toString());
		System.out.println(numbers.size());
		System.out.println("Winner?"+gen.isWinner());
		System.out.println("Winner?"+gen2.isWinner());
	}
}
