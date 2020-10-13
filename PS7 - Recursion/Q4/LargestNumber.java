import java.util.ArrayList;
import java.util.Scanner;

public class LargestNumber {

	public static int findLargest(ArrayList<Integer> list, int index, int max) {
		if (index == list.size()) {
			return max;
		}
		else if (max < list.get(index)) {
			max = list.get(index);
		}

		return findLargest(list, index + 1, max);
	}

	public static void main(String[] args) {
		Scanner ui = new Scanner(System.in);
		ArrayList<Integer> numberList = new ArrayList<>();
		boolean isEndOfInput = false;

		System.out.println("Enter several numbers. Enter a non-integer to end.");

		do {
			if (ui.hasNextInt()) {
				numberList.add(ui.nextInt());
			} else {
				isEndOfInput = true;
			}
		} while (!isEndOfInput);

		System.out.println("Greatest number in that sequence is " + findLargest(numberList, 0, 0));
	}
}