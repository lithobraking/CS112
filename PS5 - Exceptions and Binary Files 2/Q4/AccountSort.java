import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Account implements Comparable<Account>{
	private final String name;
	private final long accountNum;
	private double accountBalance;
	private boolean isCashBack = false;
	private String cb = "No";

	// constructor method
	public Account(String name, long account, double balance, boolean cashBack) {
		this.name = name;
		this.accountNum = account;
		this.accountBalance = balance;
		this.isCashBack = cashBack;

		if (isCashBack) {
			cb = "Yes";
		}
	}

	@Override
	public String toString() {
		return String.format("%20s%20d%10.2f%10s", name, accountNum, accountBalance, cb);
	}

	@Override
	public int compareTo(Account a) {
		if (this.accountBalance == a.getAccountBalance()) {
			return  0;
		} else if (this.accountBalance < a.getAccountBalance()) {
			return 1;
		} else {
			return -1;
		}
	}

	// getter methods
	public String getName() {
		return name;
	}
	public long getAccountNum() {
		return accountNum;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public boolean isCashBack() {
		return isCashBack;
	}
	public String getCb() {
		return cb;
	}

	// setter methods

	public void setAccountBalance(double newBalance) {
		this.accountBalance = newBalance;
	}
}

public class AccountSort {
	public static void main(String[] args) {
		Scanner ui = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		ArrayList<Account> list = new ArrayList<>();
		double tgtBalance;
		int nameLength;
		String name;
		long acctNum;
		double balance;
		boolean isCashBack;

		System.out.println("Enter a balance");
		tgtBalance = ui.nextDouble();

		try {
			DataInputStream ds = new DataInputStream(
					new BufferedInputStream(
							new FileInputStream("accounts-with-names.dat")
					)
			);
			boolean EOF = false;

			while (!EOF) {
				try {
					// get name of account holder
					nameLength = ds.readInt();
					for (int i = 1; i <= nameLength; i++) {
						sb.append(ds.readChar());
					}
					name = sb.toString();
					sb.setLength(0);

					// get account number
					acctNum = ds.readLong();

					// get account balance
					balance = ds.readDouble();

					// get cashback status
					isCashBack = ds.readBoolean();

					// take gathered information and instantiate new account into list
					list.add(new Account(name, acctNum, balance, isCashBack));
				}
				catch (EOFException e) {
					EOF = true;
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int resultCount = 0;
		Collections.sort(list);
		System.out.printf("Accounts with a balance of at least $%.2f (sorted by balance)\n", tgtBalance);
		System.out.printf("%20s%20s%10s%10s%n", "Name", "Account Number", "Balance", "Cash Back");
		for (Account a : list) {
			if (a.getAccountBalance() > tgtBalance) {
				System.out.println(a);
				resultCount++;
			}
		}
		System.out.println(resultCount + " results");
	}
}