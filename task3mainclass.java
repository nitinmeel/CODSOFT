public class ATMSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);  // Initial balance of 1000
        ATM atm = new ATM(account);
        atm.displayMenu();
    }
}
