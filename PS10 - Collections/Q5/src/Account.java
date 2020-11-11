public class Account {
    private final String accountNumber;
    private double balance;
    private double highestBalance;
    private double lowestBalance;

    public Account(String accountNumber, String balance) {
        this.accountNumber = accountNumber;
        this.balance = Double.parseDouble(balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", highestBalance=" + highestBalance +
                ", lowestBalance=" + lowestBalance +
                '}';
    }
}
