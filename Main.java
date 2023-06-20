import java.util.Scanner;

public class Main {
    private static StepTracker stepTracker;
    private static Scanner scanner;

    public static void main(String[] args) {
        stepTracker = new StepTracker();
        scanner = new Scanner(System.in);

        int choice = -1;
        while (choice != 0) {
            printMenu();
            choice = scanner.nextInt();
            handleChoice(choice);
        }

        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Ввести количество шагов за определенный день");
        System.out.println("2. Напечатать статистику за определенный месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("0. Выйти из приложения");
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                enterSteps();
                break;
            case 2:
                printStatistics();
                break;
            case 3:
                changeGoal();
                break;
            case 0:
                break;
            default:
                System.out.println("Ошибка: Неверный выбор действия.");
        }
    }

    private static void enterSteps() {
        System.out.println("Введите количество шагов:");
        int steps = scanner.nextInt();
        stepTracker.addSteps(steps);
        System.out.println("Количество шагов успешно добавлено.");
    }

    private static void printStatistics() {
        System.out.println("Введите месяц (число):");
        int month = scanner.nextInt();
        System.out.println(stepTracker.getStatistics(month));
    }

    private static void changeGoal() {
        System.out.println("Введите новую цель по количеству шагов в день:");
        int goal = scanner.nextInt();
        stepTracker.setGoal(goal);
        System.out.println("Цель успешно изменена.");
    }
}
