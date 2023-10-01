import java.util.ArrayList;
import java.util.HashMap;

public class ComparisonData {

    MonthlyReport monthlyReport;
    YearReport yearReport;

    public ComparisonData(MonthlyReport monthlyReport, YearReport yearReport) {
        this.monthlyReport = monthlyReport;
        this.yearReport = yearReport;
    }

    public boolean examination() {
        if (yearReport.exception() == true && monthlyReport.exception() == true) {
            System.out.println("Считайте данные за все месяцы и годовой отчет!");
            return false;
        } else if (yearReport.exception() == false && monthlyReport.exception() == true) {
            System.out.println("Считайте данные за все месяцы!");
            return false;
        } else if (yearReport.exception() == true && monthlyReport.exception() == false) {
            System.out.println("Считайте годовой отчет!");
            return false;
        } else {
            return true;
        }
    }

    public void comparisonMonthAndYear() {
        ArrayList<String> listYear = yearReport.getYearList();
        for (String lines : listYear) {
            String[] line = lines.split(",");
            if (Boolean.parseBoolean(line[2]) == true) {
                if (!(Integer.parseInt(line[1]) == sumWestMonth(line[0]))) {
                    System.out.println("В месяце " + yearReport.getNameMonth(Integer.parseInt(line[0]))
                            + " обнаружено несоответсвие по расходам");
                    break;
                }
            } else if (Boolean.parseBoolean(line[2]) == false) {
                if (!(Integer.parseInt(line[1]) == sumProfitMonth(line[0]))) {
                    System.out.println(line[1] + "   " + sumProfitMonth(line[0]));
                    System.out.println("В месяце " + yearReport.getNameMonth(Integer.parseInt(line[0]))
                            + " обнаружено несоответсвие по расходам");
                    break;
                }
            }
        }
        System.out.println("Успешное завершение операции!");
    }

    private int sumProfitMonth(String month) {
        int sum = 0;
        String numbMonth = "m.2021" + month + ".csv";
        HashMap<String, ArrayList<String>> hashMap = monthlyReport.getMapMonth();
        ArrayList<String> list = hashMap.get(numbMonth);
        for (int i = 1; i < list.size(); i++) {
            String[] line = list.get(i).split(",");
            if (!Boolean.parseBoolean(line[1])) {
                sum += Integer.parseInt(line[2]) * Integer.parseInt(line[3]);
            }
        }

        return sum;
    }

    private int sumWestMonth(String month) {
        int sum = 0;
        String numbMonth = "m.2021" + month + ".csv";
        HashMap<String, ArrayList<String>> hashMap = monthlyReport.getMapMonth();
        ArrayList<String> list = hashMap.get(numbMonth);
        for (int i = 1; i < list.size(); i++) {
            String[] line = list.get(i).split(",");
            if (Boolean.parseBoolean(line[1])) {
                sum += Integer.parseInt(line[2]) * Integer.parseInt(line[3]);
            }
        }
        return sum;
    }
}
