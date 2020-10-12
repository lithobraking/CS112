import java.util.Scanner;
import java.io.*;
import java.util.regex.*;

class AdditionHandler {
	private static int sum;
	private static int wheat;
	private static boolean containsInteger = true;

	public static int getSum() {
		return sum;
	}
	public static int getWheat() {
		return wheat;
	}
	public static boolean getIntFlag() {
		return containsInteger;
	}


	public static void addNum(int number) {
		sum += number;
	}

	public static void extractInt(String chaff) {
		try {
			wheat = Integer.parseInt(chaff.replaceAll("\\D", ""));
			sum += wheat;
		}
		catch (NumberFormatException f) {
			containsInteger = false;
		}

	}
}

public class IntegerAddition {
	public static void main(String[] args) {
		Scanner ui = new Scanner(System.in);
		String input;
		int n;
		boolean noIntFlag = false;

		do {
			System.out.println("Enter a integer");
			input = ui.nextLine();

			try {
				n = Integer.parseInt(input);
				AdditionHandler.addNum(n);
			}
			catch (NumberFormatException e) {
				AdditionHandler.extractInt(input);
				if (AdditionHandler.getIntFlag()) {
					System.out.println("Well, that's not a number but here's what I extracted: " + AdditionHandler.getWheat());
				}
			}
			finally {
				if (AdditionHandler.getIntFlag()) {
					System.out.println("Current sum: " + AdditionHandler.getSum());
				} else {
					System.out.println("There were no digits in that input.");
					noIntFlag = true;
				}
			}
		} while (!noIntFlag);

		System.out.println("Final sum: " + AdditionHandler.getSum());
	}
}