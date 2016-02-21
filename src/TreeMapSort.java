import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by r3bers on 22.02.2016.
 * Задания Geekbrains.
 * Реализовать сортировку массива с помощью TreeMap<Integer,Integer>. В TreeMap будут
 * лежать пары из двух интов ключа и значения. Ключ число, которое встретилось в
 * массиве, а значение количество раз, которое оно встретилось. Сначала собираем
 * статистику, а потом, с помощью цикла по TreeMap выводим числа нужное количество раз.
 * После работы программы, в массиве должны быть отсортированные данные.
 */
public class TreeMapSort {
    public static void main(String[] args) {
        int[] inputArray = new int[100];
        Random rnd = new Random();
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = rnd.nextInt(30);
        }
//        System.out.println(Arrays.toString(inputArray));
        Map<Integer, Integer> myMap = new TreeMap<>();
        for (int value : inputArray) {
            if (myMap.containsKey(value)) {
                myMap.put(value, myMap.get(value) + 1);
            } else {
                myMap.put(value, 1);
            }
        }
        int j = 0;
        for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.print(entry.getKey() + " ");
                inputArray[j] = entry.getKey();
                j++;
            }
            System.out.println("");
        }

        System.out.println(Arrays.toString(inputArray));
    }

}
