import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class BalanceRecord {
    public static TreeMap<String, Account> loadFile(String filename) {
        TreeMap<String, Account> accounts = null;

        try {
            Scanner accountDB = new Scanner(new File(filename));

            try {
                String accountNumber;
                String balance;
                accounts = new TreeMap<>();

                for (int i = 0; accountDB.hasNextLine(); i++) {
                    String line = accountDB.nextLine();
                    if (line.equalsIgnoreCase("customer id\tbalance")) {
                        continue;
                    }

                    String[] current = line.split("\t");
                    accountNumber = current[0];
                    balance = current[1];
                    accounts.put(accountNumber, new Account(accountNumber, balance));
                }

            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    public static void main(String[] args) {
        loadFile("balances-0.txt");
        loadFile("balances-1.txt");
        loadFile("balances-2.txt");
        loadFile("balances-3.txt");
        loadFile("balances-4.txt");
        loadFile("balances-5.txt");


    }
}
