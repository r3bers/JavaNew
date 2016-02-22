import java.math.BigDecimal;

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
    public static void main(String[] args) {
        String a = "1231231231231423";
        String b = "8888888880000059556665455";
//        String a = "18999999999";
//        String b = "10000";
        int small = a.length();
        int big = b.length();
        String sBuf;
        int iBuf;
        if (small > big) { // Это если исходные условия поменяются и что бы не дёргать постоянно length()
            sBuf = a;
            a = b;
            b = sBuf;
            iBuf = big;
            big = small;
            small = iBuf;
        }
        iBuf = 0;
        sBuf = "";
        for (int i = big - 1; i >= big - small; i--) {
            iBuf = Integer.parseInt(b.charAt(i) + "") + Integer.parseInt(a.charAt(i - big + small) + "") + iBuf;
            sBuf = iBuf % 10 + sBuf;
            iBuf = iBuf / 10;
        }
        int i = big - small - 1;
        while ((iBuf != 0) && (i >= 0)) {
            iBuf = Integer.parseInt(b.charAt(i) + "") + iBuf;
            sBuf = iBuf % 10 + sBuf;
            iBuf = iBuf / 10;
            i--;
        }
        if ((i<0)&&(iBuf==1)) {
            sBuf = "1" + sBuf;
        }
        if ((i>=0)&&(iBuf==0)){
            sBuf = b.substring(0,i+1)+sBuf;
        }

        System.out.println("Получилось:\t\t" + sBuf);
        System.out.println("Для проверки:\t" + new BigDecimal(a).add(new BigDecimal(b)));
    }
}
