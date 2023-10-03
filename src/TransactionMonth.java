public class TransactionMonth implements TransactionMont{

    private String name;
    private int quantity;
    private int unitPrice;
    private boolean expense;

    public TransactionMonth(String[] line){
        name = line[0];
        expense = Boolean.parseBoolean(line[1]);
        quantity = Integer.parseInt(line[2]);
        unitPrice = Integer.parseInt(line[3]);
    }

    public int totalPrice() {
        return quantity * unitPrice;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public int getUnitPrice() {
        return unitPrice;
    }

    @Override
    public boolean getExpense() {
        return expense;
    }
}
