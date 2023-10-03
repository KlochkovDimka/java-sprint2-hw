
import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {

    private FileReader fileReader;
    private HashMap<String, ArrayList<TransactionMont>> mapMonth = new HashMap<>();
    private TransactionMonth transaction;

    public MonthlyReport(FileReader fileReader1) {
        fileReader = fileReader1;
    }
    public void readerMont() {

        for (int i = 1; i < 4; i++) {
            ArrayList<TransactionMont> transactions = new ArrayList<>();
            String numberMonth = "m.20210" + i + ".csv";
            ArrayList<String> m = fileReader.readFileContents(numberMonth);
            for (int j = 1; j < m.size(); j++){
                String [] line = m.get(j).split(",");
                transaction = new TransactionMonth(line);
                transactions.add(transaction);
            }
            mapMonth.put(numberMonth, transactions);

        }
        System.out.println("Операция успешно выполнена!");
    }
    public boolean exception(){
        return mapMonth.isEmpty();
    }
    public void get() {
        for (int i = 1; i < 4; i++) {
            String numberMonth = "m.20210" + i + ".csv";
            String mont = getNameMonth(numberMonth);
            ArrayList<TransactionMont> list = mapMonth.get(numberMonth);
            int maxProfit = 0;
            int maxWest = 0;
            String productProfit = "";
            String productWest = "";
            for (TransactionMont transactionMont : list){
                if (transactionMont.getExpense()) {
                    maxWest = Math.max(maxWest, transactionMont.totalPrice());
                    if (maxWest == transactionMont.totalPrice()) {
                        productWest = transactionMont.getName();
                    }
                } else {
                    maxProfit = Math.max(maxProfit, transactionMont.totalPrice());
                    if (maxProfit == transactionMont.totalPrice()) {
                        productProfit = transactionMont.getName();
                    }
                }
            }
            System.out.println(mont);
            System.out.println("Самый прибыльный товар: " + productProfit + " - " + maxProfit);
            System.out.println("Самая большая трата: " + productWest + " - " + maxWest);
        }
    }

    public String getNameMonth(String nameFile){
        String month;
        switch (nameFile) {
            case "m.202101.csv":
                month = "Январь";
                break;
            case "m.202102.csv":
                month = "Февраль";
                break;
            default:
                month = "Март";
                break;
        }
        return month;
    }

    public HashMap<String, ArrayList<TransactionMont>> getMapMonth(){
        return mapMonth;
    }
}
