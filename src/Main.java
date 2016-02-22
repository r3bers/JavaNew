import java.math.BigDecimal;

/**
 * Created by r3bers on 13.02.16.
 * Main класс для экспериментов.
 */
public class Main {
    public static void main(String argc[]) {
        System.out.println(new BigDecimal("2983742897489215178572974124").multiply(new BigDecimal("394058345839045823095809358039845")).multiply(new BigDecimal("43957398579357934592375982374682739579327597354987359")));
        BigDecimal my = new BigDecimal("2");
        long step = 1;
        while (true) {
            step = step * 2;
            try {
                my = my.multiply(my);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
            //System.out.println(my);
            System.out.println(step + "-ая степень 2 содержит " + my.toString().length() + " знаков в 10-чной системе. " + step / 256 + " байт.");
        }
    }
}
