// checking accoung
public class CheckingAccount extends Account {

    // default transaction fee
    private static double FEE = 2.5;

    // default constructor
    public CheckingAccount() {
        super();
    }

    /**
     * Parameter constructor to initialize Checking Account
     * with a custom account number and a customer transaction fee.
     */

    public CheckingAccount(int accountNumber, double fee) {
        super(accountNumber);
        FEE = fee;
    }

    /**
     * Function to deposit funds into the account as long as
     * the amount parameter is > 0
     * 
     * Apply transaction fee for the CheckingAccount
     * 
     * @param amount value to be deposited
     */
    public void deposit(double amount) {

        // First check amount
        if( amount > 0) {
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);
            // Apply transaction fee
            balance -= FEE;
            System.out.printf("Fee %.2f Applied%n", amount);
            System.out.printf("Current Balance is: %.2f%n", balance);
        } else {
            System.out.println("A negative amount cannot be deposited");
        }

    }

    /**
     * Function to withdraw funds from the account as long as
     * 1. amount to withdraw must be > 0
     * 2. amount to withdraw must be <= balance
     * 
     * @param amount value to be withdrawn
     */
    public void withdraw(double amount) {

        // Same check
        if(amount > 0) {
            // Check sufficient balance
            if((amount+FEE) <= balance) {

                System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
                balance -= amount;
                balance -= FEE;
                System.out.printf("Fee of %.2f applied%n", FEE);
                System.out.printf("Current Balance is: %.2f%n", balance);
            }
        } else {
            System.out.println("Negative amount, cannot be withdrawn!");
        }
    }
}
