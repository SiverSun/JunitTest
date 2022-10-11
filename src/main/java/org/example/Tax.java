package org.example;

import java.util.Scanner;

public class Tax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;
        while (true) {
            System.out.println("Выберите операцию и введите ее номер:\n " +
                    "1. Добавить новый доход\n" +
                    "2. Добавить новый расход\n" +
                    "3. Выбрать систему налогообложения");
            String operationStr = scanner.nextLine();
            int operation = Integer.parseInt(operationStr);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода");
                    String money1Str = scanner.nextLine();
                    int money1 = Integer.parseInt(money1Str);
                    spendings += money1;
                    break;
                case 3:
                    if (taxEarningsMinusSpendings(earnings, spendings) > taxEarnings(earnings)) {
                        int econom = taxEarningsMinusSpendings(earnings, spendings) - taxEarnings(earnings);
                        System.out.println("Мы советуем Вам УСН Доходы");
                        System.out.println("Ваш налог составит " + taxEarnings(earnings) + " рублей");
                        System.out.println("Налог на другой системе: " + taxEarningsMinusSpendings(earnings, spendings) + " рублей");
                        System.out.println("Экономия " + econom + " рублей");
                    } else if (taxEarnings(earnings) > taxEarningsMinusSpendings(earnings, spendings)) {
                        int econom1 = taxEarnings(earnings) - taxEarningsMinusSpendings(earnings, spendings);
                        System.out.println("Мы советуем Вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + taxEarningsMinusSpendings(earnings, spendings) + " рублей");
                        System.out.println("Налог на другой системе: " + taxEarnings(earnings) + " рублей");
                        System.out.println("Экономия " + econom1 + " рублей");
                    } else {
                        System.out.println("Мы советуем Вам выбрать любую систему");
                        System.out.println("Ваш налог составит: " + taxEarningsMinusSpendings(earnings, spendings) + " рублей");
                        System.out.println("Налог на другой системе: " + taxEarnings(earnings) + " рублей");
                        System.out.println("Налоги равны, экономии нет");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
                    break;

            }
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
        }


        System.out.println("Программа завершена!");
    }


    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarnings(int earnings) {
        int tax1 = earnings * 6 / 100;
        return tax1;
    }

}
