import Exercito.Army;
import Menu.Menu;


import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private Army player;
    private Army enemy;

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
        }
    }


    private void createArmies() {
        clearConsole();
        int cata, cav, inf, perc, total;
        Scanner input = new Scanner(System.in);
        System.out.println("\n\nNOTA: Número de tropas nao pode ser superior a 100");
        System.out.println("Introduza a quantidade de catapultas: ");
        cata = input.nextInt();
        System.out.println("\nTropas restantes: " + (100 - cata));
        System.out.println("Introduza a quantidade de cavalaria: ");
        cav = input.nextInt();
        System.out.println("\nTropas restantes: " + (100 - cata - cav));
        System.out.println("Introduza a quantidade de infantaria: ");
        inf = input.nextInt();
        System.out.println("Introduza a percentagem de tropas para defensiva: ");
        perc = input.nextInt();
        total = cata + cav + inf;
        if (total > 100) {
            System.out.println("Volte a introduzir");
            createArmies();
        }
        //System.out.println("Foram introduzidas:\nCatapultas: "+cata+"\nCavalaria: "+cav+"\nIntantaria: "+inf+"\n\n");
        player = new Army(cata, cav, inf, perc);
        enemy = new Army(cata, cav, inf, perc);
    }

    public void inspectArmies() {
        clearConsole();
        int qtCav = 0, qtInf = 0, qtCata = 0, qtTotal = 0;
        for (int i = 0; i < player.getAttackForce().size(); i++) {
            if (player.getAttackForce().get(i).getAtaque() == 100) {
                qtCata++;
                qtTotal++;
            } else if (player.getAttackForce().get(i).getAtaque() == 50) {
                qtCav++;
                qtTotal++;
            } else {
                qtInf++;
                qtTotal++;
            }
        }
        System.out.println("\nQuantidade de tropas de Ataque do Player: " + qtTotal + "\n\nCatapultas: " + qtCata + "\nCavalaria: " + qtCav + "\nInfantaria: " + qtInf);qtCav = 0;qtInf = 0;qtCata = 0;qtTotal = 0;
        for (int i = 0; i < player.getDefenceForce().size(); i++) {
            if (player.getDefenceForce().get(i).getDefesa() == 1) {
                qtCata++;
                qtTotal++;
            } else if (player.getDefenceForce().get(i).getDefesa() == 50) {
                qtCav++;
                qtTotal++;
            } else {
                qtInf++;
                qtTotal++;
            }
        }
        System.out.println("\nQuantidade de tropas de defesa do Player: " + qtTotal + "\n\nCatapultas: " + qtCata + "\nCavalaria: " + qtCav + "\nInfantaria: " + qtInf);
        qtCav = 0;qtInf = 0;qtCata = 0;qtTotal = 0;
        for (int i = 0; i < enemy.getAttackForce().size(); i++) {
            if (enemy.getAttackForce().get(i).getAtaque() == 1) {
                qtCata++;
                qtTotal++;
            } else if (enemy.getAttackForce().get(i).getAtaque() == 50) {
                qtCav++;
                qtTotal++;
            } else {
                qtInf++;
                qtTotal++;
            }
        }
        System.out.println("\nQuantidade de tropas de ataque do inimigo: " + qtTotal + "\n\nCatapultas: " + qtCata + "\nCavalaria: " + qtCav + "\nInfantaria: " + qtInf);
        qtCav = 0;qtInf = 0;qtCata = 0;qtTotal = 0;
        for (int i = 0; i < enemy.getDefenceForce().size(); i++) {
            if (enemy.getDefenceForce().get(i).getDefesa() == 1) {
                qtCata++;
                qtTotal++;
            } else if (enemy.getDefenceForce().get(i).getDefesa() == 50) {
                qtCav++;
                qtTotal++;
            } else {
                qtInf++;
                qtTotal++;
            }
        }
        System.out.println("\nQuantidade de tropas de defesa do inimigo: " + qtTotal + "\n\nCatapultas: " + qtCata + "\nCavalaria: " + qtCav + "\nInfantaria: " + qtInf);
    }

    public void play() {

    }

    public static void main(String[] args){
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
                    clearConsole();
                    game.createArmies();
                    System.out.println("\n\nPress ENTER to continue...");
                    scanner.nextLine();
                    break;
                }
                case InspectArmy: {
                    clearConsole();
                    game.inspectArmies();
                    System.out.println("\n\nPress ENTER to continue...");
                    scanner.nextLine();
                    break;
                }
                case Play: {
                    game.play();
                    System.out.println("\n\nPress ENTER to continue...");
                    scanner.nextLine();
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
