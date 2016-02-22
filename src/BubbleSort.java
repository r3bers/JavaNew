import java.util.Arrays;
import java.util.Random;

/**
 * Created by r3bers on 21.02.16.
 * Задание от Geekbrains
 * Самостоятельно реализовать пузырьковую сортировку массива.
 * <p>
 * Рассмотренны два метода.
 * Со сравнением о наличии пузырька в проходе и без.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int k;
        boolean hasBubble;

        for (int d = 8; d < 24 * 3; d++) {
            //int size = (1 << d)/12;
            int size = d * 1000;

            int z[] = new int[size];
            Random rnd = new Random();
            for (int i = 0; i < z.length; i++) {
                z[i] = rnd.nextInt(255);
            }
            int y[] = z.clone();

//С прерыванием по наличию пузырька.
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < z.length - 1; i++) {
                hasBubble = false;
                for (int j = 0; j < z.length - i - 1; j++) {
                    if (z[j] > z[j + 1]) {
                        hasBubble = true;
                        k = z[j];
                        z[j] = z[j + 1];
                        z[j + 1] = k;
                    }
                }
                if (!hasBubble) break;
            }
            System.out.println("Размер " + size + ". С прерыванием по наличию пузырька: " + (System.currentTimeMillis() - startTime) + " ms");

//Без прерывания по наличию пузырька.
            startTime = System.currentTimeMillis();
            for (int i = 0; i < y.length - 1; i++) {
                for (int j = 0; j < y.length - i - 1; j++) {
                    if (y[j] > y[j + 1]) {
                        k = y[j];
                        y[j] = y[j + 1];
                        y[j + 1] = k;
                    }
                }
            }
            System.out.println("Размер " + size + ". Без прерывания по наличию пузырька: " + (System.currentTimeMillis() - startTime) + " ms\n");

            //System.out.println("Равны ли: " + Arrays.equals(z, y));
        }

    }
}
