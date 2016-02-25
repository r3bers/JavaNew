import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by soul on 21.02.2016.
 * Задание Geekbrains
 * Простое число это такое, которое не делится ни на одно из других простых чисел.
 * Напишите алгоритм для поиска простых чисел. Перебираем все числа от 1 до N и
 * пытаемся делить на уже найденные числа (их храним в ArrayList). Если ни на кого не
 * делится, то значит простое и его можно добавить в массив.
 */
public class Primes {
    private static Scanner scanner = new Scanner(System.in);
    final static int consoleWidth = 120;

    public static long inputNum(String zapros) {
        boolean b;
        long a = 0;
        do {
            String s = scanner.nextLine();
            try {
                a = Long.parseLong(s);
                if (a <= 1) {
                    throw new NumberFormatException("Почему меньше двух.");
                } else {
                    b = true;
                }
            } catch (NumberFormatException e) {
                System.out.print("Неверный ввод, попробуйте ещё: ");
                b = false;
            }
        } while (!b);
        return a;
    }

    public static void main(String[] args) {
        System.out.print("Введите не перый элемент из множества натуральных чисел N : ");
        long n = inputNum("Число N");
        List<Long> pri = new ArrayList<>();
        String toCons = "{ ";
        long start = System.currentTimeMillis();
        for (long i = 2; i <= n; i++) {
            boolean hasDivider = false;
            for (Long aPri : pri) {
                if (i % aPri == 0) {
                    hasDivider = true;
                    break;
                }
            }
            if (!hasDivider) {
                pri.add(i);
                if ((toCons + i + ", ").length() > consoleWidth) {
                    System.out.println(toCons);
                    toCons = i + ", ";
                } else {
                    toCons = toCons + i + ", ";
                }
            }
        }
        start = System.currentTimeMillis() - start;
        System.out.println(toCons.substring(0, toCons.length() - 2) + " }");
        System.out.println("Затрачено " + start + " мс.");
    }
}
