public class Transaction {
    String type;
    double amount;
    String description;
    public Transaction(String type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
    }
    @Override
    public String toString() {
        return type + ": " + amount + " - " + description;
    }
    
}