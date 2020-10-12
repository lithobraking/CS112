import java.util.Scanner;

public class RecursiveCrash {
	public static void crash(int x) {
		System.out.println(x);
		crash(x + 1);
	}

	public static void main(String[] args) {
		crash(0);
	}
}