import java.util.Arrays;
import java.util.Random;

/**
 * Created by r3bers on 22.02.2016.
 * Задания Geekbrains.
 * Самостоятельно реализовать сортировку слиянием: входной массив делится на две
 * половины. Каждая сортируется с помощью слияния. Далее две половины сливаются в
 * одну с помощью двух индексов.
 */

public class MergeSort {
    private static class RecurseSort {
        private int[] sortArr;

        public RecurseSort(int[] forSort) {
            sortArr = forSort.clone();
        }

        private int sortMer(int startInd, int endInd) {
            int end1 = startInd + ((endInd - startInd) / 2); // Конец первой половинки
            int ind2 = end1 + 1; //Начало второй половинки

            if ((endInd - startInd) > 1) { // T
                sortMer(startInd, end1);
                sortMer(ind2, endInd);

                //Слияние начало
                int ind1 = startInd;
                int[] bufArr = Arrays.copyOfRange(sortArr, startInd, endInd + 1);

                for (int i = startInd; i < endInd; i++) {
                    int bufInd1 = ind1 - startInd; // Индексы в буферном массиве
                    int bufInd2 = ind2 - startInd; // Созданы потому что арифметическая операция без создания будет трижды повторятся.
                    if (bufArr[bufInd1] < bufArr[bufInd2]) {
                        sortArr[i] = bufArr[bufInd1];
                        if (ind1 != end1) {
                            ind1++;
                        } else {
                            System.arraycopy(bufArr, bufInd2, sortArr, i + 1, endInd - ind2 + 1);
                            break;
                        }
                    } else {
                        sortArr[i] = bufArr[bufInd2];
                        if (ind2 != endInd) {
                            ind2++;
                        } else {
                            System.arraycopy(bufArr, bufInd1, sortArr, i + 1, end1 - ind1 + 1);
                            break;
                        }

                    }
                }
                //Слияние конец
            } else if ((endInd - startInd) == 1) {
                //Сортировка простейшего двухэлементного массива.
                if (sortArr[startInd] > sortArr[endInd]) {
                    int buf = sortArr[endInd];
                    sortArr[endInd] = sortArr[startInd];
                    sortArr[startInd] = buf;
                }
            }
            return 0;
        }

        @Override
        public String toString() {
            return Arrays.toString(sortArr);
        }

        public int sortMer() {
            sortMer(0, sortArr.length - 1);
            return 0;
        }
    }

    public static void main(String[] args) {
        // Инициализируем рандомный массив и показываем его
        int[] inputArray = new int[25];
        Random rnd = new Random();
        for (int i = 0; i < inputArray.length; i++) inputArray[i] = rnd.nextInt(255) - 128;
        System.out.println(Arrays.toString(inputArray));

        RecurseSort myRec = new RecurseSort(inputArray);
        myRec.sortMer(); //Дёргаём метод сортировки
        System.out.println(myRec); //Выводим массив оверрайдным тустринг

        //Выводим отсортированный массив для сравнения
        Arrays.sort(inputArray);
        System.out.println(Arrays.toString(inputArray));
    }
}
