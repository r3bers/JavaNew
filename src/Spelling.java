import java.util.StringTokenizer;

/**
 * Created by r3bers on 23.02.2016.
 * Дан словарь voc = {“арбуз”, “абакан”, “абориген”, “лето”, …. } и строка с ошибками: txt =
 * “Орбуз пишется совершенно не так!”. Написать программу, которая исправит все слова,
 * которые отличаются на одну букву от словаря.
 */
public class Spelling {
    private static String[] voc = {"арбуз", "абакан", "абориген", "лето"};
    private static String rightWord = "";

    private static boolean isOneRight(String str) {
        int lenDif;
        boolean res = false;
        for (String slovar : voc) {
            lenDif = str.length() - slovar.length();
            switch (lenDif) {
/*
                    //Ищем недостающую букву
                case -1:
                    for (int i = 0; i < str.length(); i++) {

                    }
                    break;
*/
                case 0:
                    //Ищем неправильную буквку
                    int dif = -1;
                    for (int i = 0; i < str.length(); i++) {
                        if (slovar.charAt(i) != Character.toLowerCase(str.charAt(i))) {
                            if (dif != -1) {
                                dif = -1;
                                break;
                            } else {
                                dif = i;
                            }
                        }
                    }
                    if (dif >= 0) {
                        char rightChar = slovar.charAt(dif);
                        if (Character.isUpperCase(str.charAt(dif))) {
                            rightChar = Character.toUpperCase(rightChar);
                        }
                        rightWord = str.substring(0, dif) + rightChar + str.substring(dif + 1);
                        res = true;
                    }
                    break;
/*
                case 1:
                    //Ищем линюю букву
                    for (int i = 0; i < str.length(); i++) {

                    }
                    break;
*/
            }
            if (res) break;

        }
        return res;
    }

    public static void main(String[] args) {
        String txt = "АрбуЭ пишется совершенно не так!";
        StringTokenizer st = new StringTokenizer(txt, " \t\n\r,.!?");
        while (st.hasMoreTokens()) {
            String slovo = st.nextToken();
            if (isOneRight(slovo)) {
                txt = txt.replaceAll(slovo, rightWord);
            }
        }
        System.out.println(txt);
    }
}
