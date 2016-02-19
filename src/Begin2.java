import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by odmin on 13.02.16.
 */

public class Begin2 {

    public static void main(String argc[]) {
        System.out.print("Введите сторону квадрата: ");
        Scanner scanner = new Scanner(System.in);
        boolean b = true;
        double a = 0;
        BigDecimal bigD = new BigDecimal("0");
        do {
            String s = scanner.nextLine();
            try {
                a = Double.parseDouble(s);
                if (a <= 0) {
                    System.out.print("Квадрат не может быть с отрицательными сторонами, попробуйте ещё: ");
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

        System.out.println("Площадь квадрата S = " + bigD.pow(2).toString());
    }
}
