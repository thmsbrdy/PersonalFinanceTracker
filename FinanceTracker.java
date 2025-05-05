import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FinanceTracker{
    ArrayList<Transaction> transactions;
    public FinanceTracker() {
        transactions = new ArrayList<>();
    }
    public void addTransaction(String t, double a, String d) {
        if (!t.equalsIgnoreCase("Income") && !t.equalsIgnoreCase("Expense")) {
            System.out.println("Invalid transaction type: " + t + ". Please use 'Income' or 'Expense'.");
            return;
        }
        Transaction transaction = new Transaction(t, a, d);
        transactions.add(transaction);
    }
    public double currentBalance() {
        double balance = 0;
        for (Transaction transaction : transactions) {
            if (transaction.type.equalsIgnoreCase("Income")) {
                balance += transaction.amount;
            } else if (transaction.type.equalsIgnoreCase("Expense")) {
                balance -= transaction.amount;
                }
            }
        return balance;    
        }
    public void printTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 3);
                if (parts.length == 3) {
                    String type = parts[0].trim();
                    double amount = Double.parseDouble(parts[1].trim());
                    String description = parts[2].trim();
                    addTransaction(type, amount, description);
                } else {
                    System.out.println("Skipping malformed line: " + line);
                }
            }
            System.out.println("Transactions loaded successfully from " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number in file: " + e.getMessage());
        }
    }
}
    
