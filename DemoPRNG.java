// DemoPRNG.java

public class DemoPRNG {

	public static void main(String args[]) {
		PaulsPRNG generator = new PaulsPRNG();
		
		int[] hits = new int[256];
		
		// initialize
		for (int i=0; i<=255; i++) {
			hits[i] = 0;
		}
		
		// load
		for (int i=0; i<1000; i++) {
			int ans = generator.getRandomNumber();
			hits[ans]++;
		}
		
		// display
		for (int i=0; i<=255; i++) {
			System.out.println(i + "\t" + hits[i]);
		}
	}
}