import java.util.ArrayList;

public class PrimeNumberGenerator {

	public static ArrayList<Long> generate(int bound) {
		ArrayList<Long> primeList = new ArrayList<>();

		while(primeList.size() < bound) {
			for (long i = 0; i < Long.MAX_VALUE; i++) {
				if (i < 2) {
					continue;
				}

				boolean isPrime = true;

				for (int j = 2; j <= (i / 2); j++) {
					if (i % j == 0) {
						isPrime = false;
						break;
					}
				}

				if (isPrime) {
					primeList.add(i);
					if (primeList.size() >= bound) {
						break;
					}
				}
			}
		}
		return primeList;
	}
}