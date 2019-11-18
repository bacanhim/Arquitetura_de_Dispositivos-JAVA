import Exercito.Army;
import Menu.Menu;
import Verification.Verification;
import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    private Army player;
    private Army enemy;

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
        }
    }

    private void createArmyBot() {
        Random random = new Random();
        int catapult = random.nextInt(100 + 1);
        int cavalary = random.nextInt(100 + 1);
        int infatry = random.nextInt(100 + 1);
        int percentage = random.nextInt(100 + 1);
        int total = catapult + cavalary + infatry;
        if (total > 100) {
            createArmyBot();
        } else {
            enemy = new Army(catapult, cavalary, infatry, percentage);
        }
    }

    private void createArmies() {
        clearConsole();
        int catapult, cavalary, infatry, percentage, total;
        System.out.println("\n\nNOTA: Número de tropas nao pode ser superior a 100");
        catapult = Verification.isInt("Introduza a quantidade de catapultas: ");
        System.out.println("\nTropas restantes: " + (100 - catapult));
        cavalary = Verification.isInt("Introduza a quantidade de cavalaria: ");
        System.out.println("\nTropas restantes: " + (100 - catapult - cavalary));
        infatry = Verification.isInt("Introduza a quantidade de infantaria: ");
        percentage = Verification.isInt("Introduza a percentagem de tropas para o ataque: ");
        total = catapult + cavalary + infatry;
        if (total > 100) {
            System.out.println("Volte a introduzir");
            createArmies();
        } else {
            player = new Army(catapult, cavalary, infatry, percentage);
        }
        createArmyBot();
    }

    public void inspectArmies() {
        clearConsole();
        int qtCavalary = 0, qtInfantry = 0, qtCatapult = 0, qtTotal = 0;
        for (int i = 0; i < player.getAttackForce().size(); i++) {
            if (player.getAttackForce().get(i).getAtaque() == 100) {
                qtCatapult++;
                qtTotal++;
            } else if (player.getAttackForce().get(i).getAtaque() == 50) {
                qtCavalary++;
                qtTotal++;
            } else {
                qtInfantry++;
                qtTotal++;
            }
        }
        System.out.println("\nQuantidade de tropas de Ataque do Player: " + qtTotal + "\n\nCatapultas: " + qtCatapult + "\nCavalaria: " + qtCavalary + "\nInfantaria: " + qtInfantry);
        qtCavalary = 0;
        qtInfantry = 0;
        qtCatapult = 0;
        qtTotal = 0;
        for (int i = 0; i < player.getDefenceForce().size(); i++) {
            if (player.getDefenceForce().get(i).getAtaque() == 100) {
                qtCatapult++;
                qtTotal++;
            } else if (player.getDefenceForce().get(i).getAtaque() == 50) {
                qtCavalary++;
                qtTotal++;
            } else {
                qtInfantry++;
                qtTotal++;
            }
        }
        System.out.println("\nQuantidade de tropas de defesa do Player: " + qtTotal + "\n\nCatapultas: " + qtCatapult + "\nCavalaria: " + qtCavalary + "\nInfantaria: " + qtInfantry);
        qtCavalary = 0;
        qtInfantry = 0;
        qtCatapult = 0;
        qtTotal = 0;
        for (int i = 0; i < enemy.getAttackForce().size(); i++) {
            if (enemy.getAttackForce().get(i).getAtaque() == 1) {
                qtCatapult++;
                qtTotal++;
            } else if (enemy.getAttackForce().get(i).getAtaque() == 50) {
                qtCavalary++;
                qtTotal++;
            } else {
                qtInfantry++;
                qtTotal++;
            }
        }
        System.out.println("\nQuantidade de tropas de ataque do inimigo: " + qtTotal + "\n\nCatapultas: " + qtCatapult + "\nCavalaria: " + qtCavalary + "\nInfantaria: " + qtInfantry);
        qtCavalary = 0;
        qtInfantry = 0;
        qtCatapult = 0;
        qtTotal = 0;
        for (int i = 0; i < enemy.getDefenceForce().size(); i++) {
            if (enemy.getDefenceForce().get(i).getAtaque() == 100) {
                qtCatapult++;
                qtTotal++;
            } else if (enemy.getDefenceForce().get(i).getAtaque() == 50) {
                qtCavalary++;
                qtTotal++;
            } else {
                qtInfantry++;
                qtTotal++;
            }
        }
        System.out.println("\nQuantidade de tropas de defesa do inimigo: " + qtTotal + "\n\nCatapultas: " + qtCatapult + "\nCavalaria: " + qtCavalary + "\nInfantaria: " + qtInfantry);
    }

    public void play() {
        Random random = new Random();
        boolean turn = random.nextBoolean();
        int rounds = 0;
        if (turn) {
            do {
                rounds++;
                System.out.println("Round " + rounds + "-----------------");
                System.out.println("Defesa Atual->" + player.defenceForceRound());
                System.out.println("Player attack");

                player.attack(enemy);
                if (enemy.defenceForceRound() > 0) {
                    System.out.println("enemy attack");
                    enemy.attack(player);
                    System.out.println("\n\nPress ENTER to go to next round");
                    scanner.nextLine();
                }
            } while (player.defenceForceRound() > 0 && enemy.defenceForceRound() > 0);
            if (enemy.defenceForceRound() <= 0) {
                System.out.println("Voce ganhou!!");
            } else if (player.defenceForceRound() <= 0) {
                System.out.println("O computador ganhou!!");
            }


        } else {
            do {
                rounds++;
                System.out.println("----------------Round " + rounds + "-----------------------");
                System.out.println("Defesa Atual->" + player.defenceForceRound());
                System.out.println("enemy attack");
                enemy.attack(player);
                if (player.defenceForceRound() > 0) {
                    System.out.println("Player attack");
                    player.attack(enemy);
                    System.out.println("\n\nPress ENTER to go to next round...");
                    scanner.nextLine();
                }
            } while (player.defenceForceRound() > 0 && enemy.defenceForceRound() > 0);
            if (player.defenceForceRound() <= 0) {
                System.out.println("O computador ganhou!!");
            } else if (enemy.defenceForceRound() <= 0) {
                System.out.println("Voce ganhou!!");
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        boolean run = true;
        while (run) {
            Menu.Command[] options = Menu.Command.values();
            for (Menu.Command option : options) {
                String name = option.name();
                int number = option.ordinal();
                System.out.println(number + ". " + name);
            }
            Scanner scanner = new Scanner(System.in);
            String line;
            do {
                System.out.println("Introduza um comando: ");
                line = scanner.nextLine();
            }
            while (Verification.isInEnum(line, Menu.Command.class));
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
                    run = false;
                    break;
                }
            }
        }
    }
}
