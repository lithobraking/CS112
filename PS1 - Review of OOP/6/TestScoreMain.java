import java.util.Scanner;

public class TestScoreMain {
	public static void main(String[] args) {
		Scanner ui = new Scanner(System.in);
		int i = 1;
		double score;

		System.out.println("Enter name");
		TestScores student = new TestScores(ui.nextLine());

		do {
			System.out.printf("Enter score %d or a negative number to exit\n", i);
			score = ui.nextDouble();
			if (score >= 0) {
				student.addTestScore(score);
				i++; 
			}				
		} while (score >= 0);

		System.out.printf("-- %s --\n", student.getName());
		System.out.println("Num tests taken: " + student.getNumTestsTaken());
		System.out.printf("Average: %.1f\n", student.getAverage());
	}
}