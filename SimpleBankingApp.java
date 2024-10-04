import java.util.Scanner;

public class SimpleBankingApp
{

    private static double balance = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("Welcome to the Simple Banking Application!");

        do {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    deposit(scanner);
                    break;
                case "2":
                    withdraw(scanner);
                    break;
                case "3":
                    checkBalance();
                    break;
                case "4":
                    System.out.println("Exiting the application. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("4"));

        scanner.close();
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();
            if (amount > 0) {
                balance += amount;
                System.out.printf("Successfully deposited: %.2f%n", amount);
            } else {
                System.out.println("Invalid amount. Please enter a positive value.");
            }
        } else {
            System.out.println("Invalid input. Please enter a numeric value.");
        }
        scanner.nextLine(); 
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.printf("Successfully withdrew: %.2f%n", amount);
            } else if (amount > balance) {
                System.out.println("Insufficient balance. Please enter a valid amount.");
            } else {
                System.out.println("Invalid amount. Please enter a positive value.");
            }
        } else {
            System.out.println("Invalid input. Please enter a numeric value.");
        }
        scanner.nextLine();
    }

    private static void checkBalance() {
        System.out.printf("Current balance: %.2f%n", balance);
    }
}
