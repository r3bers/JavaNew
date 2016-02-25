import java.math.BigDecimal;

/**
 * Created by r3bers on 13.02.16.
 * Main класс для экспериментов.
 * <p>
 * На эксперименте с большими числами выяснилось, что разница между умноженим чисел по 128Kb и по 256Kb (1,3 раза)
 * существенно меньше чем последующие разницы операций над числами по 512Kb, 1Mb и дадее (3 раза).
 * Наблюдения сделаны на разных ОС платформах, но на примерно одинаковом железе. Видимо это свзано с
 * использованием кэша на ядре процессора, и оно одинаково эффективно вне зависимости от ОС.
 * Core i5-2500 3.7GHz под Win10 выигрывает у Core i7-3615QM 3.3GHz под MacOS X в 1.06 раза
 * http://ark.intel.com/products/52209/Intel-Core-i5-2500-Processor-6M-Cache-up-to-3_70-GHz
 * http://ark.intel.com/products/64900/Intel-Core-i7-3615QM-Processor-6M-Cache-up-to-3_30-GHz
 * <p>
 * Так же JVM точно знает об ограничении памяти и регулярно подчищает мусор, добравшись до предела.
 * И выбрасывает Out of Memory уже тогда, когда упор достигается с данными которые мусорщик вычистить не может.
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
                    + step / 8 + " байт. Умножение выполнено за " + (System.currentTimeMillis() - startTime) + " ms");
        }
    }
}
