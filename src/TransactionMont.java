public interface TransactionMont {

    public String getName();
    public int getQuantity();
    public int getUnitPrice();
    public boolean getExpense();

    public int totalPrice();
}
