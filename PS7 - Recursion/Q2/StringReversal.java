import java.util.Scanner;

public class StringReversal {
	public static String reverseString(String str) {
		if (str.length() == 0) {
			return str;
		}
		return reverseString(str.substring(1)) + str.charAt(0);
	}

	public static void main(String[] args) {
		Scanner ui = new Scanner(System.in);
		String inputString;

		System.out.println("Enter a string");
		inputString = ui.nextLine();
		System.out.println("Here is that string in reverse");
		System.out.println(reverseString(inputString));

	}
}