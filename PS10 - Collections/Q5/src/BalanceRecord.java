import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BalanceRecord {
    public static TreeMap<String, Account> loadFile(String filename) {
        TreeMap<String, Account> accounts = null;

        try {
//            System.out.println("Received filename: " + filename);
//            Scanner accountDB = new Scanner(new File(filename));
//            System.out.println("Loaded!");

            FileReader fr = new FileReader(filename);
            BufferedReader accountDB = new BufferedReader(fr);

            try {
                String accountNumber;
                String balance;
                accounts = new TreeMap<>();

                for (int i = 0; accountDB.readLine() != null; i++) {
                    String line = accountDB.readLine();
                    if (line.equalsIgnoreCase("customer id\tbalance")) {
                        continue;
                    }

                    String[] current = line.split("\t");
                    accountNumber = current[0];
                    balance = current[1];
                    accounts.put(accountNumber, new Account(accountNumber, balance));
                }
                System.out.println("Loaded!");
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
        String filename;
        Scanner ui = new Scanner(System.in);

        System.out.println("Enter a filename");
//        filename = ui.next();
//        System.out.println("Your filename is: " + filename);
        Map<String, Account> accounts = loadFile(ui.next().trim());
        System.out.println(accounts);


    }
}
