import java.util.Arrays;
import java.util.Random;

/**
 * Created by r3bers on 25.02.2016.
 * Задания GeekBrains
 * Дан массив чисел a[]={1,2,3,4} и число s=7. Найти два числа из массива, которые в сумме
 * дают s (в данном случае 7=3+4). Добиться, чтобы программа работала приемлемое
 * время на огромных массивах (например длинной миллион).
 */
public class Amazon {
    public static void main(String[] args) {
        int a[] = new int[100_000];
        final int summ = 1_711_456_234;
        final int top = 1_000_000_000;
        Random rnd = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rnd.nextInt(top);
        }
        Arrays.sort(a); // Тут время не считаю потому что условие отсортированный массив
        int minB = summ - a[a.length - 1];
        System.out.println("Минимальное слагаемое:" + minB);
        int startB = Math.abs(Arrays.binarySearch(a,minB));
        System.out.println("Индекс старта: " + startB);

        boolean hasSum = false;
        for (int i = startB; i < a.length; i++) {
            int isk = summ-a[i];
            if (Arrays.binarySearch(a,isk)>0) {
                System.out.println("Bingo: " + a[i] + " + " + isk + " = " + summ + ". Выполнено за "+ (i-startB) + " операций.");
                hasSum = true;
                break;
            }
        }
        if (!hasSum) System.out.println("Суммы не найдено!");
    }
}