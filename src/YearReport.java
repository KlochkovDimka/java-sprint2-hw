
import java.util.ArrayList;
import java.util.Objects;

public class YearReport {

    private FileReader fileReader;
    private ArrayList<TransactionYear> yearList = new ArrayList<>();
    private TransactoinYears years;

    public YearReport(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public void readerYear() {
        String numberMonth = "y.2021.csv";
        ArrayList<String> list = fileReader.readFileContents(numberMonth);
        for (int i = 1; i < list.size(); i++) {
            String[] line = list.get(i).split(",");
            years = new TransactoinYears(line);
            yearList.add(years);
        }
        System.out.println("Операция успешно выполнена!");

    }

    public boolean exception() {
        return yearList.isEmpty();
    }

    public void getYear() {
        int j = 1;
        System.out.println("Отчет за 2021 год");
        for (int i = 0; i<yearList.size(); i+=2) {
            TransactionYear year = yearList.get(i);
            TransactionYear year1 = yearList.get(j);
            j+=2;
                if (Objects.equals(year.getMonth(), year1.getMonth())){
                    System.out.println("Прибыль за " + getNameMonth(Integer.parseInt(year.getMonth())) + " - "
                            + profitMont(year,year1));
                }
            }
        System.out.println("Средний расход за все имеющиеся операции в году: " + averageWest());
        System.out.println("Средний доход за все имеющиеся операции в году: " + averageProfit());

    }

    public ArrayList<TransactionYear> getYearList(){
        return yearList;
    }

    private int profitMont(TransactionYear oneYear, TransactionYear twoYear) {
        if (!oneYear.getExpense()){
            return oneYear.getAmount() - twoYear.getAmount();
        }else {
            return twoYear.getAmount() - oneYear.getAmount();
        }

    }


    private int averageWest() {
        int averWest = 0;
        int j = 0;
        for (TransactionYear year : yearList) {
            if (year.getExpense()) {
                averWest += year.getAmount();
                j++;
            }
        }
        return averWest / j;
    }

    private int averageProfit() {
        int averProfit = 0;
        int j = 0;
        for (TransactionYear year : yearList) {
            if (!year.getExpense()) {
                averProfit += year.getAmount();
                j++;
            }
        }
        return averProfit / j;
    }

    public String getNameMonth(int number) {
        String nameMonth;
            switch (number) {
                case 01:
                    nameMonth = "Январь";
                    break;
                case 02:
                    nameMonth = "Февраль";
                    break;
                default:
                    nameMonth = "Март";
                    break;
            }
        return nameMonth;
        }
    }



