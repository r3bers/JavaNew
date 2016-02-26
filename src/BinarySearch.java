import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by soul on 25.02.2016.
 * Задания Geekbrains.
 * Самостоятельно реализовать бинарный поиск по значению в упорядоченном массиве.
 */

public class BinarySearch {
    public static void main(String[] args) {
        int a[] = new int[100_000_000];
        long startTime = System.currentTimeMillis();
        Random rnd = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rnd.nextInt(Integer.MAX_VALUE);
        }
        Arrays.sort(a);
        System.out.println("Времени на заполнение и сортировку затрачено: " + (System.currentTimeMillis() - startTime) + " мс.");
        int findValue = rnd.nextInt(a[a.length - 1]);
        int findInd = (new BigDecimal(findValue).multiply(new BigDecimal(a.length)).divideToIntegralValue(new BigDecimal(a[a.length - 1] - a[0]))).intValue();
        int itero = 0;
        int numIter = 0;
        boolean hasNext = true;
        startTime = System.currentTimeMillis();
        while (hasNext) {
            findInd += itero;
            numIter++;
            if ((findInd >= a.length) || (findInd < 0)) {
                System.out.println("Значение за пределами массива");
                hasNext = false;
            } else {
                if (findValue != a[findInd]) {
                    if (findValue > a[findInd]) {
                        if (findValue < a[findInd + 1]) {
                            System.out.println("Нету. Два ближайших индекса: " + findInd + " и " + (findInd + 1));
                            hasNext = false;
                        } else {
                            itero = (new BigDecimal(findValue - a[findInd]).multiply(new BigDecimal(a.length)).divideToIntegralValue(new BigDecimal(a[a.length - 1] - a[0]))).intValue();
                            if ((findInd + itero) > (a.length - 1)) findInd = a.length - 1;
                        }
                    } else {
                        if (findValue > a[findInd - 1]) {
                            System.out.println("Нету. Два ближайших индекса: " + findInd + " и " + (findInd + 1));
                            hasNext = false;
                        } else {
                            itero = (new BigDecimal(findValue - a[findInd]).multiply(new BigDecimal(a.length)).divideToIntegralValue(new BigDecimal(a[a.length - 1] - a[0]))).intValue();
                            if ((findInd + itero) < 0) findInd = 0;
                        }
                    }

                } else {
                    hasNext = false;
                }
            }
        }
        System.out.println("Времени на поиск затрачено: " + (System.currentTimeMillis() - startTime) + " мс.");
        System.out.println("Искали: " + findValue);
        System.out.println("Индекс: " + findInd);
        System.out.println("Предидущее: " + a[findInd - 1]);
        System.out.println("Среднее: " + a[findInd]);
        System.out.println("Следущее:" + a[findInd + 1]);
        System.out.println("Итераций:" + numIter);
    }
}
