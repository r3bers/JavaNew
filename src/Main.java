import java.math.BigDecimal;

/**
 * Created by r3bers on 13.02.16.
 * Main класс для экспериментов.
 */
public class Main {
    public static void main(String argc[]) {
        BigDecimal my = new BigDecimal("2");
        long step = 1;
        while (true) {
            step = step * 2;
            long startTime = System.currentTimeMillis();
            try {
                my = my.multiply(my);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
            //System.out.println(my);
            System.out.println(step + "-ая степень 2 содержит " + my.toString().length() + " знаков в 10-чной системе "
                    + step / 8 + " байт. Умножение выполнено за "+ (System.currentTimeMillis()-startTime) + " ms");
        }
    }
}
