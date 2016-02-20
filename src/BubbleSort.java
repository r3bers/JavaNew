import java.util.Arrays;
import java.util.Random;

/**
 * Created by r3bers on 21.02.16.
 * BubbleSort из Заданий к Geekbrains 1
 */
public class BubbleSort {
    public static void main(String[] args) {

        int z[] = new int[10];
        Random rnd = new Random();
        for (int i = 0; i < z.length; i++) {
            z[i] = rnd.nextInt(100);
        }
        System.out.print(Arrays.toString(z) + " -> ");
        for (int i = 0; i < z.length - 1; i++) {
            for (int j = 0; j < z.length - i - 1; j++) {
                if (z[j] > z[j + 1]) {
                    int k = z[j];
                    z[j] = z[j + 1];
                    z[j + 1] = k;
                }
            }
        }
        System.out.println(Arrays.toString(z));
    }
}
