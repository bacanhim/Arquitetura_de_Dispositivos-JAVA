package Utils;

import java.util.Scanner;

public class Verification {
    // create army troops verification
    public static int isInt(String sout) {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.print(sout);
        while (!scanner.hasNextInt()) {
            System.out.println("ERRO: Introduza um número válido!");
            scanner.next();
        }
        number = scanner.nextInt();
        return number;
    }

    public static String isTrue(String sout) {
        Scanner scanner = new Scanner(System.in);
        String res;
        System.out.println(sout);
        while (!(scanner.hasNext("sim")) && !(scanner.hasNext("nao")) ){
            System.out.println("ERRO: Introduza uma opcao válida!");
            scanner.next();
        }
        res = scanner.nextLine();
        return res;
    }

    // menu select option verification
    public static <E extends Enum<E>> boolean isInEnum(String value, Class<E> enumClass) {
        for (E e : enumClass.getEnumConstants()) {
            if (e.name().equals(value)) {
                return false;
            }
        }
        System.out.println("ERRO: Introduza uma opção válida!");
        return true;
    }
}
