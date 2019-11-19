package Utils;
import java.util.Scanner;

public class Verification {
    public static int isInt(String sout) {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.print(sout);
        while (!scanner.hasNextInt()) {
            System.out.println("Introduza um número válido!");
            scanner.next();
        }
        number = scanner.nextInt();
        return number;
    }
    public static <E extends Enum<E>> boolean isInEnum(String value, Class<E> enumClass) {
        for (E e : enumClass.getEnumConstants()) {
            if (e.name().equals(value)) {
                return false;
            }
        }
        System.out.println("Introduza uma opção valida!!");
        return true;
    }
}
