import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by r3bers on 13.02.16.
 * Main класс ддля экспериментов.
 */
public class Main {
    public static void main(String argc[]) {

//Задача 0.0.1 Переворот массива

        int x[] = new int[]{1, 2, 3, 7};
        System.out.print(Arrays.toString(x) + " -> ");
        for (int i = 0; i < x.length / 2; i++) {
            int k = x[i];
            x[i] = x[x.length - i - 1];
            x[x.length - i - 1] = k;
        }
        System.out.println(Arrays.toString(x));

//Задача 0.0.2 Среднее значение и максимум

        int y[] = new int[]{2, 2, 4, 4};
        System.out.print(Arrays.toString(y) + " - > ");
        int maxValue = y[0];
        int summ = y[0];
        for (int i = 1; i < y.length; i++) {
            summ += y[i];
            if (y[i] > maxValue) {
                maxValue = y[i];
            }
        }
        double midValue = summ / y.length;
        System.out.println(midValue + " , " + maxValue);

    }
}
