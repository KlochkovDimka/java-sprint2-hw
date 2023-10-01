
import java.util.ArrayList;

public class YearReport {

    private FileReader fileReader;
    private ArrayList<String> yearList = new ArrayList<>();

    public YearReport(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public void readerYear() {
        String numberMonth = "y.2021.csv";
        yearList = fileReader.readFileContents(numberMonth);
        yearList.remove(0);
        System.out.println("Операция успешно выполнена!");

    }

    public boolean exception() {
        return yearList.isEmpty();
    }

    public void getYear() {
        System.out.println("Отчет за 2021 год");
        for (int i = 0; i < yearList.size(); i+=2) {
            String[] line = yearList.get(i).split(",");
            int j = i+1;
            String[] lineTwo = yearList.get(j).split(",");
            System.out.println("Прибыль за "+getNameMonth(Integer.parseInt(line[0])) + " - "
             + profitMont(line,lineTwo));
        }
        System.out.println("Средний расход за все имеющиеся операции в году: " + averageWest());
        System.out.println("Средний доход за все имеющиеся операции в году: " + averageProfit());

    }

    public ArrayList<String> getYearList(){
        return yearList;
    }

    private int profitMont(String[] line, String[] lineTwo) {
        int profit;
        if (!Boolean.parseBoolean(line[2])){
            profit = Integer.parseInt(line[1]) - Integer.parseInt(lineTwo[1]);
        }else {
            profit = Integer.parseInt(lineTwo[1]) - Integer.parseInt(line[1]);
        }
        return profit;
    }


    private int averageWest() {
        int averWest = 0;
        int j = 0;
        for (String s : yearList) {
            String[] line = s.split(",");
            if (Boolean.parseBoolean(line[2])) {
                averWest += Integer.parseInt(line[1]);
                j++;
            }
        }
        return averWest / j;
    }

    private int averageProfit() {
        int averProfit = 0;
        int j = 0;
        for (String s : yearList) {
            String[] line = s.split(",");
            if (!Boolean.parseBoolean(line[2])) {
                averProfit = +Integer.parseInt(line[1]);
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



