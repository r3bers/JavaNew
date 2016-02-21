import java.util.Arrays;

/**
 * Created by r3bers on 21.02.2016.
 * Задание от Geekbrains
 * Написать код, который ищет среднее значение и максимум в массиве: {2,2,4,4} > 3.0, 4
 */
public class AverageAndMax {
    public static void main(String[] args) {
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
