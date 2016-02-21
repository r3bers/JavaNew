import java.util.Arrays;

/**
 * Created by r3bers on 21.02.2016.
 * Задание от Geekbrains
 * Написать код, который переворачивает массив: {1,2,3,7} > {7,3,2,1}
 */
public class Uturn {
    public static void main(String[] args) {
        int x[] = new int[]{1, 2, 3, 7};
        System.out.print(Arrays.toString(x) + " -> ");
        for (int i = 0; i < x.length / 2; i++) {
            int k = x[i];
            x[i] = x[x.length - i - 1];
            x[x.length - i - 1] = k;
        }
        System.out.println(Arrays.toString(x));
    }
}
