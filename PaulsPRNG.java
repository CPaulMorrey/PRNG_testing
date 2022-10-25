// PaulsPRNG

import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

public class PaulsPRNG {
	double seed;
	
	void PaulsPRNG() {
		seed = 0.0;
	}
	
	int getRandomNumber() {
		Calendar c = Calendar.getInstance();		
		Long millisecond = c.getTimeInMillis();		
		StringBuilder value1 = new StringBuilder();
		value1.append( millisecond.toString() );
		value1.reverse();
		String value2 = value1.reverse().toString();
		int value = 0;
		value += (100 * value2.charAt( value2.length() - 3));
		value += (10 * value2.charAt( value2.length() - 2));
		value += (value2.charAt( value2.length() - 1));
		
		while( value > 256 ) {
			value = value / 2;
		}
		
		return value;
	}

/*	
	int getRandomNumber () {
		Calendar c = Calendar.getInstance();		
		Long millisecond = c.getTimeInMillis();		
		int value = millisecond.intValue();
		value %= 255;
		return value;
	}
/*
	int getRandomNumber () {
		int min = 0;
		int max = 255;
		int result = (int)(Math.random()*(max-min+1)+min);
		return result;
	}
/*
	int getRandomNumber () {
		double a = seed * 15485863;
		double val = (a * a * a % 2038074743) / 2038074743; //Will return in range 0 to 1 if seed >= 0 and -1 to 0 if seed < 0.
		seed++;
		int result = (int) (255 * val);
		return result;
	}
/*
	int getRandomNumber () {
		int num = -1;
		do {
			num = ThreadLocalRandom.current().nextInt();
		} while(( num < 0 ) || ( num > 255 ));
			
		int result = num;
		return result;
	}
*/	
}
