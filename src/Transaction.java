public class Transaction {

    private String name;

    private int quantity;

    private int unitPrice;
    
    private boolean expense;

    public Transaction(String[] lineContents) {
        name = lineContents[0];
        expense = Boolean.parseBoolean(lineContents[1]);
        quantity = Integer.parseInt(lineContents[2]);
        unitPrice = Integer.parseInt(lineContents[3]);
    }

    public String getName() {
        return name;
    }

    public int totalPrice() {
        return quantity * unitPrice;
    }

}
