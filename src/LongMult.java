import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by r3bers on 23.02.2016.
 * Аналогично задаче 0.0.4, использовать то, что длинное число может быть представлено в
 * виде: 123456789 = 789 + 1000*456 + 123*1000*1000
 */
public class LongMult {
    private static long get9Dig(String num, int pos) {
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

    private static String to9Dig(long num) {
        String res = Long.toString(num);
        if (res.length() < 9) while (res.length() != 9) res = "0" + res;
        return res;
    }

    public static void main(String[] args) {
        String a = "293482039842015107497098273490287340997925871587345098135098"; // 60
        String b = "2340216408715601634012746058761008475610387602836108456038457608149534534532523686789678986"; //91


        int l = Math.max(a.length(), b.length());
        l = l % 9 == 0 ? l / 9 : l / 9 + 1;

        long secRes[] = new long[l * 2];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                secRes[i + j] += get9Dig(a, i) * get9Dig(b, j);
                secRes[i + j + 1] += secRes[i + j] / 1_000_000_000;
                secRes[i + j] = secRes[i + j] % 1_000_000_000;
            }
        }

        //Собираем массив в строчку
        StringBuilder secStr = new StringBuilder();
        boolean started = false;
        for (int k = l * 2 - 1; k >= 0; k--) {
            if (started) {
                secStr.append(to9Dig(secRes[k]));
            }
            if ((!started) && (secRes[k] != 0)) {
                started = true;
                secStr.append(secRes[k]);
            }
        }
        System.out.println("Результат\t\t" + secStr);
        System.out.println("Для проверки:\t" + new BigDecimal(a).multiply(new BigDecimal(b)));

    }
}
