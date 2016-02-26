import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by r3bers on 23.02.2016.
 * Аналогично задаче 0.0.4, использовать то, что длинное число может быть представлено в
 * виде: 123456789 = 789 + 1000*456 + 123*1000*1000
 */
public class LongMult {
    static long get9Dig(String num, int pos) {
        if (pos < 0) {
            System.out.println("Дурак чтоле!");
            return 0;
        }
        if (pos * 9 >= num.length()) {
            return 0;
        } else if ((pos + 1) * 9 >= num.length()) {
            return Integer.parseInt(num.substring(0, num.length() - pos * 9));
        } else {
            return Integer.parseInt(num.substring(num.length() - (pos + 1) * 9, num.length() - pos * 9));
        }
    }

    static String to9Dig(long num) {
        String res = Long.toString(num);
        if (res.length() < 9) while (res.length() != 9) res = "0" + res;
        return res;
    }

    public static void main(String[] args) {
        String a = "293482039842015107497098273490287340997925871587345098135098"; // 60
        String b = "2340216408715601634012746058761008475610387602836108456038457608149534534532523686789678986"; //91
//        String a = "1123456789098765432";
//        String b = "1123456789234567890";
//        String a = "999999999999999999999999999999999999";
//        String b = "999999999999999999999999999999999999";


        int l = Math.max(a.length(), b.length());
        l = l % 9 == 0 ? l / 9 : l / 9 + 1;
//        long resDigits[][] = new long[l + 1][l + 1];
//        long allRes[] = new long[l * 2];
        long secRes[] = new long[l * 2];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
//                resDigits[i][j] += get9Dig(a, i) * get9Dig(b, j);
//                resDigits[i][j + 1] = resDigits[i][j] / 1_000_000_000;
//                resDigits[i][j] = resDigits[i][j] % 1_000_000_000;

                //long buf = get9Dig(a, i) * get9Dig(b, j);
                secRes[i + j] += get9Dig(a, i) * get9Dig(b, j);
                secRes[i + j + 1] += secRes[i + j] / 1_000_000_000;
                secRes[i + j] = secRes[i + j] % 1_000_000_000;
            }
//            for (int n = (l - i) * 9 + 4; n >= 0; n--) System.out.print(" ");
//            for (int k = l; k >= 0; k--) System.out.print(to9Dig(resDigits[i][k]));
//            for (int k = 0; k <= l; k++) {
//                allRes[i + k] += resDigits[i][k];
//                if ((i + k + 1) < (l * 2)) allRes[i + k + 1] += allRes[i + k] / 1_000_000_000;
//                allRes[i + k] = allRes[i + k] % 1_000_000_000;
//            }
//            System.out.println("");
        }

        //Собираем массив в строчку
//        StringBuilder resStr = new StringBuilder();
        StringBuilder secStr = new StringBuilder();
        boolean started = false;
        for (int k = l * 2 - 1; k >= 0; k--) {
            if (started) {
//                resStr.append(to9Dig(allRes[k]));
                secStr.append(to9Dig(secRes[k]));
            }
            if ((!started) && (secRes[k] != 0)) {
                started = true;
//                resStr.append(allRes[k]);
                secStr.append(secRes[k]);
            }
        }
//        System.out.println("Результат:\t\t" + resStr);
        System.out.println("Результат2\t\t" + secStr);
        System.out.println("Для проверки:\t" + new BigDecimal(a).multiply(new BigDecimal(b)));

    }
}
