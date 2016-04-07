import java.math.BigDecimal;

/**
 * Created by r3bers on 13.02.16.
 * Тестовие задания. Начальный 1. Периметр Квадрата.
 */

public class Begin1 {

    public static void main(String argc[]) {
        System.out.print("Введите сторону квадрата: ");
        BigDecimal bigD = InputKv.inputNum("Сторона квадрата");
        System.out.println("Периметр квадрата P = " + bigD.multiply(new BigDecimal("4")));
    }
}
