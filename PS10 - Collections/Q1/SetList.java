
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SetList {
	public static void main(String[] args) {
		Scanner ui = new Scanner(System.in);
		Set<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
		boolean exitRequested = false;

		do {
			System.out.println("Enter a line of text");
			String line = ui.nextLine();

			if (line.equalsIgnoreCase("exit")) {
				exitRequested = true;
			} else {
				set.add(line);
			}
		} while (!exitRequested);

		for (String i : set) {
			System.out.println(i);
		}
	}
}