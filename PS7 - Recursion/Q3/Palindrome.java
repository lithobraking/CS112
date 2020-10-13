import java.util.Scanner;

public class Palindrome {
	public static String reverseString(String str) {
		if (str.length() == 0) {
			return str;
		}
		return reverseString(str.substring(1)) + str.charAt(0);
	}

	public static boolean isPalindrome(String str) {
		return (str.equalsIgnoreCase(reverseString(str)));
	}

	public static void main(String[] args) {
		Scanner ui = new Scanner(System.in);
		String inputString;

		System.out.println("Enter a String");
		inputString = ui.nextLine();

		if (isPalindrome(inputString)) {
			System.out.println("That is a palindrome");
		} else {
			System.out.println("That is NOT a palindrome");
		}
	}
}