import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HashBin {

	public static void main(String[] args) {
		Scanner ui = new Scanner(System.in);
		TreeMap<Integer, String> words = new TreeMap<>();
		int quota = 0;

		System.out.println("Enter ten words");
		do {
			String input = ui.nextLine();
			if(!words.containsKey(CustomHash.hashFunction(input))) {
				words.put(CustomHash.hashFunction(input), input);
			}
			quota++;
		} while (quota < 10);

		for (Map.Entry<Integer, String> entry : words.entrySet()) {
			System.out.printf("Hash: %d Word: %s\n", entry.getKey(), entry.getValue());
		}
	}
}