import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class CardValidation {

}

public class CardReader {
	public static void main(String[] args) {
		Scanner ui = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int checksum;
		long cardNumber;

		System.out.println("Enter a filename");

//		To determine if a credit card is valid, use the following algorithm:

//		From the rightmost digit, which is the check digit, and moving left, double the value of every second digit.

//		The check digit is not doubled; the first digit doubled is immediately to the left of the check digit.

//		If the result of this doubling operation is greater than 9 (e.g., 8 * 2 = 16), then add the digits of the result (e.g., 16: 1 + 6 = 7, 18: 1 + 8 = 9)
//		or, alternatively, the same final result can be found by subtracting 9 from that result (e.g., 16: 16 - 9 = 7, 18: 18 - 9 = 9).

//		Take the sum of all the digits. (Display this to the user)

//		If the total modulo 10 is equal to 0 (if the total ends in zero) then the number is valid.

		try {
			FileInputStream fstream = new FileInputStream(ui.nextLine());
			DataInputStream dstream = new DataInputStream(fstream);

			boolean fileEnd = false;

			while (!fileEnd) {
				try {
					cardNumber = dstream.readLong();
					System.out.println("Credit card number: " + cardNumber);
					setChecksum(cardNumber);
					System.out.println("Checksum: " + checksum);
				} catch (EOFException e) {
					System.out.println("All done!");
					fileEnd = true;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// 1. add every other number, excluding the check
		public void setChecksum(long cNum) {
			int sum = 0;
			int doubledNum;
			String card = Long.toString(cNum);

			for (int i = (card.length() - 2); i >= 0; i -= 2) {
				doubledNum = Integer.parseInt(String.valueOf(card.charAt(i))) * 2;
				if (doubledNum > 9) {
					doubledNum -= 9;
					sum += doubledNum;
				} else {
					sum += doubledNum;
				}
			}
			checksum = sum;
		}
		public boolean validation() {

		}
	}
}