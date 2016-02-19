import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by r3bers on 19.02.2016.
 * Тестовие задания. Начальный 3. Площадь прямоугольника.
 */
public class Begin3 {
    private static Scanner scanner = new Scanner(System.in);

    public static BigDecimal inputNum (String zapros) {
        boolean b;
        BigDecimal bigD = new BigDecimal("0");
        do {
            String s = scanner.nextLine();
            try {
                double a = Double.parseDouble(s);
                if (a <= 0) {
                    System.out.print(zapros+" не может быть с отрицательным значением, попробуйте ещё: ");
                    b = false;
                } else {
                    b = true;
                    bigD = new BigDecimal(s);
                }
            } catch (NumberFormatException e) {
                System.out.print("Неверный ввод, попробуйте ещё: ");
                b = false;
            }
        } while (!b);
        return bigD;
    }

    public static void main(String argc[]) {
        System.out.print("Введите сторону 'a': ");
        BigDecimal a = inputNum("Сторона 'a'");
        System.out.print("Введите сторону 'b': ");
        BigDecimal b = inputNum("Сторона 'b'");
        System.out.print("Площадь прямоугольника S = " + a.multiply(b).toString());
        System.out.println(" и периметр P = " + a.add(b).multiply(new BigDecimal("2")).toString());
    }
}
