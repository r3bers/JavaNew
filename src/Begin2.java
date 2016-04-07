import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by r3bers on 13.02.16.
 * Тестовие задания. Начальный 2. Площадь Квадрата.
 */

public class Begin2 {

    public static void main(String argc[]) {
        System.out.print("Введите сторону квадрата: ");
        BigDecimal bigD = InputKv.inputNum("Сторона квадрата");
        System.out.println("Площадь квадрата S = " + bigD.pow(2).toString());
    }
}
