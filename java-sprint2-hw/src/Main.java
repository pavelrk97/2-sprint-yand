import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();

            int i = scanner.nextInt();

            switch (i) {
                case 1:
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                case 2:
                    System.out.println("Введите цель шагов");
                    int goalByStepsPerDay = scanner.nextInt();
                    stepTracker.changeStepGoal(goalByStepsPerDay);
                    break;
                case 3:
                    stepTracker.printStatistic();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Введите команду от 1 до 4");
                    break;
            }
        }
    }

    static void printMenu() {
        System.out.println("1 - ввести количество шагов за определённый день");
        System.out.println("2 - изменить цель по количеству шагов в день");
        System.out.println("3 - напечатать статистику за определённый месяц;");
        System.out.println("4 - выйти из приложения");
    }
}