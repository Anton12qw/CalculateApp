import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {

    HashMap<Integer, MonthData> monthToData = new HashMap<>();
    int defaultGoal = 10000;

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    public void setGoal(int goal) {
        if (goal < 0) {
            System.out.println("Цель должна быть неотрицательным числом.");
        } else {
            defaultGoal = goal;
        }
    }

    public void addSteps(int month, int day, int steps) {
        if (month >= 0 && month < 12) {
            MonthData monthData = monthToData.get(month);
            if (monthData != null) {
                monthData.addSteps(day, steps);
            } else {
                System.out.println("Некорректный номер месяца.");
            }
        } else {
            System.out.println("Некорректный номер месяца.");
        }
    }

    public boolean getStatistics(int month) {
        if (month >= 0 && month < 12) {
            MonthData monthData = monthToData.get(month);
            if (monthData != null) {
                monthData.printStatistics();
                return true;
            } else {
                System.out.println("Нет данных для указанного месяца.");
                return false;
            }
        } else {
            System.out.println("Некорректный номер месяца.");
            return false;
        }
    }

    public void addSteps(int steps) {
    }

    class MonthData {
        int[] stepsPerDay = new int[30];

        public void addSteps(int day, int steps) {
            if (day >= 1 && day <= 30) {
                stepsPerDay[day - 1] = steps;
            } else {
                System.out.println("Некорректный номер дня.");
            }
        }

        public void printStatistics() {
            int totalSteps = 0;
            int maxSteps = 0;
            int currentSeries = 0;
            int maxSeries = 0;
            double totalDistance = 0;
            double totalCalories = 0;

            for (int i = 0; i < stepsPerDay.length; i++) {
                int steps = stepsPerDay[i];
                totalSteps += steps;
                if (steps > maxSteps) {
                    maxSteps = steps;
                }
                if (steps >= defaultGoal) {
                    currentSeries++;
                    if (currentSeries > maxSeries) {
                        maxSeries = currentSeries;
                    }
                } else {
                    currentSeries = 0;
                }
                totalDistance += steps * 0.000762; // Конвертация шагов в километры
                totalCalories += steps * 0.05; // Приближенный расчет килокалорий
            }

            System.out.println("Количество пройденных шагов по дням:");
            for (int i = 0; i < stepsPerDay.length; i++) {
                System.out.println((i + 1) + " день: " + stepsPerDay[i]);
            }
            System.out.println("Общее количество шагов за месяц: " + totalSteps);
            System.out.println("Максимальное количество пройденных шагов в месяце: " + maxSteps);
            System.out.println("Среднее количество шагов: " + (totalSteps / 30));
            System.out.println("Пройденное расстояние в километрах: " + totalDistance);
            System.out.println("Количество сожженных килокалорий: " + totalCalories);
            System.out.println("Лучшая серия максимальное количество подряд идущих дней, в которых количество шагов было выше целевого: " + maxSeries);
        }
    }

    public static void main(String[] args) {
        StepTracker tracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        int month = 0;

        // Пример использования функций класса
        tracker.setGoal(8000); // Установка целевого количества шагов
        tracker.addSteps(month, 1, 6000); // Добавление шагов за первый день
        tracker.addSteps(month, 2, 9000); // Добавление шагов за второй день
        tracker.getStatistics(month); // Вывод статистики за указанный месяц
    }
}
