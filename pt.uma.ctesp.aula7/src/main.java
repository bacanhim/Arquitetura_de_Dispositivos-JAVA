import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Menu.Command[] options = Menu.Command.values();
        for (int i = 0; i < options.length; i++) {
            Menu.Command option = options[i];
            String name = option.name();
            System.out.println(name);
        }
//        Menu.optionsIfs();


        Rational r1 = new Rational(2,4);
        Rational r2 = r1;
        System.out.println(r1.equals(r2));
    }
}

