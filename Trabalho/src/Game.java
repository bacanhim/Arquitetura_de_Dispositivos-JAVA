import Exercito.Army;
import Menu.Menu;


import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Game {

    private Army player;
    private Army enemy;

    private void createArmies() {
        int cata, cav, inf, perc, total;
        Scanner input = new Scanner(System.in);
        System.out.println("Numero de tropas nao pode ser superir a 100");
        System.out.println("Introduza a quantidade de catapultas: ");
        cata = input.nextInt();
        System.out.println("Tropas restantes: " + (100 - cata));
        System.out.println("Introduza a quantidade de cavalaria: ");
        cav = input.nextInt();
        System.out.println("Tropas restantes: " + (100 - cata - cav));
        System.out.println("Introduza a quantidade de infantaria: ");
        inf = input.nextInt();
        System.out.println("Introduza a percentagem de tropas para defensiva: ");
        perc = input.nextInt();
        total = cata + cav + inf;
        if (total > 100) {
            System.out.println("Volte a introduzir");
            createArmies();
        }

        player = new Army(cata, cav, inf, perc);

    }

    public static void main(String[] args) {
        Game game = new Game();
        boolean a = true;
        while (a) {
            Menu.Command[] options = Menu.Command.values();
            for (int i = 0; i < options.length; i++) {
                Menu.Command option = options[i];
                String name = option.name();
                int number = option.ordinal();
                System.out.println(number + ". " + name);
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduza um comando: ");
            String line = scanner.nextLine();
            Menu.Command command = Menu.Command.valueOf(line);
            switch (command) {
                case CreateArmy: {
                    game.createArmies();
                    break;
                }
                case InspectArmy: {
                    System.out.println();
                    break;
                }
                case Play: {
                    break;
                }
                case Quit: {
                    a = false;
                    break;
                }
            }
        }
    }
}
