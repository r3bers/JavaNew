import java.util.Random;

/**
 * Created by r3bers on 23.02.2016.
 * Написать функцию static int numOnes(int x){...}, которая вычисляет количество единиц в
 * бинарном представлении числа x.
 */
public class CalcBits {
    public static int numOnes(int x) {
        int res = 0;
        for (int i = 0; i < 31; i++) {
            if (((x >> 1) << 1) != x) res++;
            x = x >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int r = rnd.nextInt();
        System.out.println("В двоичном представлении числа \"" + r + "\" содержится " + numOnes(r) + " едениц.");

    }
}
