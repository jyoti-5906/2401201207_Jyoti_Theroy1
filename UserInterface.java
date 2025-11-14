import java.util.Scanner;

public class UserInterface {

    private final Account[] accounts = new Account[50];   
    private int accountCount = 0;
    private final Scanner sc = new Scanner(System.in);    

    public void mainMenu() {
        while (true) {
            System.out.println("\n===== Banking Application =====");
            System.out.println("1. Create new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1 -> createAccount();      
                case 2 -> performDeposit();
                case 3 -> performWithdrawal();
                case 4 -> showAccountDetails();
                case 5 -> updateContact();
                case 6 -> {
                    System.out.println("Thank you for using the app!");
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial deposit amount: ");
        double balance = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter email address: ");
        String email = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        int accountNumber = 1000 + accountCount;
        accounts[accountCount] = new Account(accountNumber, name, balance, email, phone);

        System.out.println("Account created successfully! Account Number: " + accountNumber);
        accountCount++;
    }

    private Account findAccount(int accNo) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accNo)
                return accounts[i];
        }
        return null;
    }

    private void performDeposit() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        Account acc = findAccount(accNo);

        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        acc.deposit(amount);
    }

    private void performWithdrawal() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        Account acc = findAccount(accNo);

        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        acc.withdraw(amount);
    }

    private void showAccountDetails() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        Account acc = findAccount(accNo);

        if (acc == null) {
            System.out.println("Account not found!");
        } else {
            acc.displayAccountDetails();
        }
    }

    private void updateContact() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        Account acc = findAccount(accNo);

        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter new email: ");
        String email = sc.nextLine();

        System.out.print("Enter new phone number: ");
        String phone = sc.nextLine();

        acc.updateContactDetails(email, phone);
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.mainMenu();
    }
}
