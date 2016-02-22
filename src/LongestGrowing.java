import java.util.Arrays;

/**
 * Created by r3bers on 22.02.2016.
 * Задания Geekbrains
 * Напишите код, который ишет в массиве int arr[]={1,2,3,2,1,3,1,2,6,7,8,9,10,11,0,1} самую
 * длинную непрерывную возрастающую подпоследовательность: {1,2,6,7,8,9,10,11}.
 */
public class LongestGrowing {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 1, 3, 1, 2, 6, 7, 8, 9, 10, 11, 0, 1};
        int indStart = 0;
        int indEnd = 0;
        int maxLen = 0;
        int curLen = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]<arr[i+1]){
                curLen ++;
                if (curLen > maxLen){
                    maxLen = curLen;
                    indEnd = i+1;
                    indStart = i+1-curLen;
                }
            }else {
                curLen = 0;
            }
        }
        System.out.println("Длиннейшая непрерывная последовательность: " + Arrays.toString(Arrays.copyOfRange(arr,indStart,indEnd+1)));

    }
}
