public class TestScoresDemo
{
    public static void main(String[] args)
    {
        TestScores t1 = new TestScores("Alice");
        TestScores t2 = new TestScores("Bob");

        t1.addTestScore(50);
        t1.addTestScore(60);
        t1.addTestScore(54);
        t1.addTestScore(73);
        t1.addTestScore(88);
        t1.addTestScore(92);

        t2.addTestScore(87);
        t2.addTestScore(97);
        t2.addTestScore(37);
        t2.addTestScore(99);

        System.out.println("-- Alice --");
        System.out.println("Num tests taken: " + t1.getNumTestsTaken());
        System.out.println("Average: " + t1.getAverage());

        System.out.println("-- Bob --");
        System.out.println("Num tests taken: " + t2.getNumTestsTaken());
        System.out.println("Average: " + t2.getAverage());
    }
}
