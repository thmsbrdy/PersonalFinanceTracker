import java.util.Scanner;

public class Main {
    public static void main(String[] args) { 
        FinanceTracker tracker = new FinanceTracker();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n---- Personal Finance Tracker ----\n");
            System.out.println("1. Add Income or Expense");
            System.out.println("2. Load Transaction from a file");
            System.out.println("3. View Current Balance");
            System.out.println("4. List All Transactions");
            System.out.println("5. Exit");
            
            
            int choice;
            while (true) {
                System.out.println("Please select an option (1-5): ");
                String input = scanner.nextLine(); 

                try {
                    choice = Integer.parseInt(input);
                    if (choice >=1 && choice <= 5) {
                        break;
                    } else {
                        System.out.println("Please enter a number between 1 and 4.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }
                        
            switch (choice) {
                case 1:
                    String type;
                    while (true) {
                        System.out.print("Enter transaction type (Income/Expense): ");
                        type = scanner.nextLine().trim();
                        if (type.equalsIgnoreCase("Income") || type.equalsIgnoreCase("Expense")){
                            break;
                        } else {
                            System.out.println("Invalid type. Please enter 'Income' or 'Expense'.");
                        }
                    }
                    
                    double amount;
                    while (true) {
                        System.out.print("Enter amount: ");
                        if (scanner.hasNextDouble()) {
                            amount = scanner.nextDouble();
                            scanner.nextLine();
                            break;
                        } else {
                            System.out.println("Invalid amount. Please enter a valid number.");
                            scanner.nextLine();
                        }
                    }
                    
                    String description;
                    while (true) {
                        System.out.print("Enter description: ");
                        description = scanner.nextLine();
                        if (!description.isEmpty()) {
                            break;
                        } else {
                            System.out.println("Description cannot be empty. Please try again.");
                        }
                    } 
                    
                    tracker.addTransaction(type, amount, description);
                    break;
                
                case 2:
                    System.out.println("Enter filename: ");
                    String filename = scanner.nextLine();
                    tracker.loadFromFile(filename);
                    break;

                case 3:
                    System.out.println("Current Balance: " + tracker.currentBalance());
                    break;

                case 4:
                    tracker.printTransactions();
                    break;

                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    running = false;
                    break;
            }
        }
        scanner.close();
    }
}