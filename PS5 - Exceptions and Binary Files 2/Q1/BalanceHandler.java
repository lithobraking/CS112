import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class  Account {
	// fields
	private long cardNumber;
	private double balance;
	private boolean hasCashBack = false;

	// constructor method
	public Account(long cardNumber, double balance, boolean hasCashBack) {
		this.cardNumber = cardNumber;
		this.balance = balance;
		this.hasCashBack = hasCashBack;
	}

	// getter methods
	public long getCardNumber() {
		return cardNumber;
	}

	public double getBalance() {
		return balance;
	}

	public String hasCashBack() {
		String answer;

		if (!hasCashBack) {
			answer = "No";
		} else {
			answer = "Yes";
		}
		return answer;
	}
}

public class BalanceHandler {
	public static void main(String[] args) {
		Scanner ui = new Scanner(System.in);
		double tgtBalance;
		ArrayList<Account> accounts = new ArrayList<>();
		long cardNumber;
		double balance;
		boolean cashBackFlag = false;

		System.out.println("Enter a balance");
		tgtBalance = ui.nextDouble();

		try {
			FileInputStream fs = new FileInputStream("accounts.dat");
			DataInputStream ds = new DataInputStream(fs);

			boolean EOF = false;
			while (!EOF) {
				try {
					cardNumber = ds.readLong();
					balance = ds.readDouble();
					cashBackFlag = ds.readBoolean();

					if (balance >= tgtBalance) {
						accounts.add(new Account(cardNumber, balance, cashBackFlag));
					}
				}
				catch (EOFException e) {
					EOF = true;
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		System.out.printf("Accounts with a balance of at least $%.2f%n", tgtBalance);
		System.out.format("%20s%10s%12s%n", "Card Number", "Balance", "Cash Back?");
		for (Account account : accounts) {
			System.out.format("%20d%10.2f%12s%n", account.getCardNumber(), account.getBalance(), account.hasCashBack());
		}
		System.out.format("%42s%n", accounts.size() + " results");
	}
}