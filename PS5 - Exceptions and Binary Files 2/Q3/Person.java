

public class Person implements Comparable<Person>{
	String name;
	long accountNumber;
	double balance;
	boolean isCashBack;
	String affirmative = "No";

	// constructor method
	public Person(String name, long accountNumber, double balance, boolean isCashBack) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.isCashBack = isCashBack;

		if (isCashBack) {
			affirmative = "Yes";
		}
	}


	public String toString() {
		return String.format("%20s%20s%10.2f%10s", name, accountNumber, balance, affirmative);

	}

	@Override
	public int compareTo(Person person) {
		return this.name.compareToIgnoreCase(person.name);
	}
}