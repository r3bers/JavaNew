import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by r3bers on 07.04.16.
 * Удалить одинаковые части из Begin а то новая Идея ругается
 */
class InputKv {
    private static Scanner scanner = new Scanner(System.in);

    static BigDecimal inputNum(String zapros) {
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
}
