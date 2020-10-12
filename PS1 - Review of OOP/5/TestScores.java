

public class TestScores {
	String name;
	double totalScore;
	int numScores;

	public TestScores(String name) {
		this.name = name;
	}

	public void addTestScore(double earnedScore) {
		totalScore += earnedScore;
		numScores++;
	}

	public int getNumTestsTaken() {
		return numScores;
	}

	public double getAverage() {
		return (totalScore / numScores);
	}
}