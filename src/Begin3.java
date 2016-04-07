import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by r3bers on 19.02.2016.
 * Тестовие задания. Начальный 3. Площадь и периметр прямоугольника.
 */
public class Begin3 {

    public static void main(String argc[]) {
        System.out.print("Введите сторону 'a': ");
        BigDecimal a = InputKv.inputNum("Сторона 'a'");
        System.out.print("Введите сторону 'b': ");
        BigDecimal b = InputKv.inputNum("Сторона 'b'");
        System.out.print("Площадь прямоугольника S = " + a.multiply(b).toString());
        System.out.println(" и периметр P = " + a.add(b).multiply(new BigDecimal("2")).toString());
    }
}
