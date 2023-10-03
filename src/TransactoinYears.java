public class TransactoinYears implements TransactionYear{

    private String month;
    private int amount;
    private boolean expenses;

    public TransactoinYears(String[] line){
        month = line[0];
        amount = Integer.parseInt(line[1]);
        expenses = Boolean.parseBoolean(line[2]);
    }
    @Override
    public String getMonth() {
        return month;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public boolean getExpense() {
        return expenses;
    }
}
