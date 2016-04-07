import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by r3bers on 19.02.2016.
 * Тестовие задания. Начальный 4. Длина окружности.
 * Коммит надо не забывать редактировать во время Коммита, потому как Push уже не даёт поменять.
 */
public class Begin4 {

    public static void main(String argc[]) {
        System.out.print("Введите диаметр окружонсти 'd': ");
        BigDecimal a = InputKv.inputNum("Диаметр 'd'");
        System.out.println("Длина окруджности L = " + a.multiply(new BigDecimal("3.14")).toString());
    }
}
