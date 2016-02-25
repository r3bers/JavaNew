import java.util.StringTokenizer;

/**
 * Created by r3bers on 25.02.2016.
 * Задания от Geekbrains
 * Написать программу, которая принимает строку и делает все слова заглавными:
 * “ЭТО настояшая пРоверка Букв” => “Это Настоящая Проверка Букв”
 */
public class Capitalizator {
    public static void main(String[] args) {
        String str = "ЭТО настояшая пРоверка Букв!";
        System.out.println(str);

        StringTokenizer st = new StringTokenizer(str, " \t\n\r,.!?");
        while (st.hasMoreTokens()) {
            String slovo = st.nextToken();
            char arr[] = slovo.toCharArray();
            arr[0] = Character.toUpperCase(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                arr[i] = Character.toLowerCase(arr[i]);
            }
            String rightWord = String.valueOf(arr);
            str = str.replaceAll(slovo, rightWord);
        }
        System.out.println(str);
    }
}
