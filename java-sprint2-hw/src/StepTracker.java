import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();
    MonthData monthData = new MonthData();
    int goalByStepsPerDay = 10000;

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца от 1 до 12");
        int month = scanner.nextInt();
        if (month < 1||month > 12) {
            System.out.println("Не верный номер месяца, вводите от 1-12");
            return;
        }

        System.out.println("Введите номер дня от 1 до 30");
        int day = scanner.nextInt();
        if (day < 1||day > 30) {
            System.out.println("Не верный номер дня, вводите от 1-30");
            return;
        }

        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println("Назад уже не отшагаешь, введите положительное число");
            return;
        }

        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;
        System.out.println("Шаги внесены");
    }

    void changeStepGoal(int currentSteps) {
        if (goalByStepsPerDay >= 0) {
            goalByStepsPerDay = currentSteps;
            System.out.println("Новая цель - " + goalByStepsPerDay);
        } else {
            System.out.println("Введите положительное число шагов");
            return;
        }
    }

    void printStatistic() {
        System.out.println("Введите номер месяца для вывода статистики");
        int month = scanner.nextInt();
        if (month > 12 || month < 1) {
            System.out.println("не тот номер, введите от 1 до 12");
            return;
        }
        monthData = monthToData[month - 1];
        int sumSteps = monthData.sumStepsFromMonth();
        System.out.println("пройдено по дням в месяце:");
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Пройдено в сумме:");
        System.out.println(sumSteps);
        System.out.println("Максимум в день: " + monthData.maxSteps());
        System.out.println("В среднем в месяц: " + monthData.averageSteps());
        System.out.println("Дистанция в км пройдена: " + converter.convertToKm(sumSteps));
        System.out.println("Сожжено каллорий: " + converter.convertToStepsToKilocalories(sumSteps));
        System.out.println("Лучшая серия (максимум плодряд достигнутых целей): " + monthData.bestSeries(goalByStepsPerDay));
    }

    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
}
