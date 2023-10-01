
import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {

    private FileReader fileReader;
    private HashMap<String, ArrayList<String>> mapMonth;

    public MonthlyReport(FileReader fileReader1) {
        fileReader = fileReader1;
        mapMonth = new HashMap<>();
    }
    public void readerMont() {
        for (int i = 1; i < 4; i++) {
            String numberMonth = "m.20210" + i + ".csv";
            ArrayList<String> m = fileReader.readFileContents(numberMonth);
            mapMonth.put(numberMonth, m);
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
            ArrayList<String> list = mapMonth.get(numberMonth);
            int maxProfit = 0;
            int maxWest = 0;
            String productProfit = "";
            String productWest = "";
            for (int j = 1; j < list.size(); j++) {
                String[] array = list.get(j).split(",");
                Transaction transaction = new Transaction(array);
                if (Boolean.parseBoolean(array[1])) {
                    maxWest = Math.max(maxWest, transaction.totalPrice());
                    if (maxWest == transaction.totalPrice()) {
                        productWest = transaction.getName();
                    }
                } else {
                    maxProfit = Math.max(maxProfit, transaction.totalPrice());
                    if (maxProfit == transaction.totalPrice()) {
                        productProfit = transaction.getName();
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

    public HashMap<String, ArrayList<String>> getMapMonth(){
        return mapMonth;
    }
}
