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
        if (yearReport.exception() && monthlyReport.exception()) {
            System.out.println("Считайте данные за все месяцы и годовой отчет!");
            return false;
        } if (!yearReport.exception() && monthlyReport.exception()) {
            System.out.println("Считайте данные за все месяцы!");
            return false;
        } if (yearReport.exception() && !monthlyReport.exception()) {
            System.out.println("Считайте годовой отчет!");
            return false;
        } return true;
    }

    public void comparisonMonthAndYear() {
        ArrayList<TransactionYear> listYear = yearReport.getYearList();
        for (TransactionYear year : listYear) {
            if (yearReport.exception()) {
                if (!(year.getAmount() == sumWestMonth(year.getMonth()))) {
                    System.out.println("В месяце " + yearReport.getNameMonth(Integer.parseInt(year.getMonth()))
                            + " обнаружено несоответсвие по расходам");
                    break;
                }
            }if (!yearReport.exception()) {
                if (!(year.getAmount() == sumProfitMonth(year.getMonth()))) {
                    System.out.println("В месяце " + yearReport.getNameMonth(Integer.parseInt(year.getMonth()))
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
        HashMap<String, ArrayList<TransactionMont>> hashMap = monthlyReport.getMapMonth();
        ArrayList<TransactionMont> list = hashMap.get(numbMonth);
        for (TransactionMont mont: list) {
            if (!mont.getExpense()) {
                sum += mont.getQuantity() * mont.getUnitPrice();
            }
        }

        return sum;
    }

    private int sumWestMonth(String month) {
        int sum = 0;
        String numbMonth = "m.2021" + month + ".csv";
        HashMap<String, ArrayList<TransactionMont>> hashMap = monthlyReport.getMapMonth();
        ArrayList<TransactionMont> list = hashMap.get(numbMonth);
        for (TransactionMont mont: list) {
            if (mont.getExpense()) {
                sum += mont.getQuantity() * mont.getUnitPrice();
            }
        }
        return sum;
    }
}
