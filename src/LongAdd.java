import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by r3bers on 22.02.2016.
 * Задания GeekBranch.
 * Есть две строки a = “1231231231231423” и b = “8888888880000059556665455”.
 * Реализовать алгоритм, который будет складывать соответствующие числа. Результат
 * также должен быть представлен в виде строки. Подсказка: посмотрите как вы делаете
 * такое сложение на бумажке и заставьте компьютер делать то же самое. Алгоритм должен
 * работать для чисел, которые не водят в Double и Long и не использовать BigDecimal
 */
public class LongAdd {
    static int getDig(String num, int pos) {
        if (pos<0){
            System.out.println("Дурак чтоле!");
            return 0;
        }
        if ((num.length() - pos - 1) < 0) return 0;
        else return num.charAt(num.length() - pos - 1) - '0';
    }

    public static void main(String[] args) {
        String a = "1231231231231423";
        String b = "8888888880000059556665455";
        int l = Math.max(a.length(),b.length());
        int resDigits[] = new int[l+1];

        for (int i = 0; i < l; i++) {
            resDigits[i] += getDig(a,i) + getDig(b,i);
            resDigits[i+1] = resDigits[i]/10;
            resDigits[i] = resDigits[i]%10;
        }
        StringBuilder newStr = new StringBuilder();
        if (resDigits[l]!=0) newStr.append(resDigits[l]);
        for (int i = l-1; i >=0 ; i--) {
            newStr.append(resDigits[i]);
        }
        System.out.println("Получилось:\t\t" + newStr);
        System.out.println("Для проверки:\t" + new BigDecimal(a).add(new BigDecimal(b)));
    }
}
