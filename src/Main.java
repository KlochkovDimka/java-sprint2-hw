import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Поехали!
        FileReader fileReader = new FileReader();
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport(fileReader);
        YearReport yearReport = new YearReport(fileReader);
        ComparisonData comparisonData = new ComparisonData(monthlyReport,yearReport);

        while (true) {

            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                monthlyReport.readerMont();
            } else if (command == 2) {
                yearReport.readerYear();
            } else if (command == 3) {
                if (comparisonData.examination()){
                   comparisonData.comparisonMonthAndYear();
                }
            } else if (command == 4) {
               if (monthlyReport.exception()) {
                    System.out.println("Считайте отчеты!");
               }else {
                   monthlyReport.get();
                }
            } else if (command == 5) {
                if (yearReport.exception()) {
                    System.out.println("Считайте отчеты!");
                }else {
                    yearReport.getYear();
                }
            } else if (command == 6) {
                break;
            } else {
                System.out.println("Такой команты нет");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выбирите, что нужно сделать:");
        System.out.println("1 - Считать все месячные отчеты.");
        System.out.println("2 - Считать годовой отчёт.");
        System.out.println("3 - Сверить отчёты.");
        System.out.println("4 - Вывести информацию обо всех месячных отчётах.");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("6 - Выход.");
    }
}

