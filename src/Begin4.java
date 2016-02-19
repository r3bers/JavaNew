import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by r3bers on 19.02.2016.
 * Тестовие задания. Начальный 4. Длина окружности.
 */
public class Begin4 {
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
        System.out.print("Введите диаметр окружонсти 'd': ");
        BigDecimal a = inputNum("Диаметр 'd'");
        System.out.println("Длина окруджности L = " + a.multiply(new BigDecimal("3.14")).toString());
    }
}
