import Exercito.Army;
import Exercito.Catapult;
import Menu.Menu;
import Utils.Verification;

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
        while (player.defenceForceRound() > 0 && enemy.defenceForceRound() > 0) {
            if (turn) {
                rounds++;
                System.out.println("----------------Round " + rounds + "-----------------------");
                System.out.println("Defesa Atual player->" + player.defenceForceRound());
                System.out.println("Defesa Atual computador->" + enemy.defenceForceRound());
                System.out.println("Player attack");
                player.attack(enemy);
                System.out.println("Total de impacto: " + player.getDamage());
                turn = false;
                if (enemy.defenceForceRound() <= 0) {
                    System.out.println("\n\nVoce ganhou!!");
                } else if (player.defenceForceRound() <= 0) {
                    System.out.println("\n\nO computador ganhou!!");
                }
                else {
                    System.out.println("\nPress ENTER to go to next round");
                    scanner.nextLine();
                }

            } else {
                rounds++;
                System.out.println("----------------Round " + rounds + "-----------------------");
                System.out.println("Defesa Atual player->" + player.defenceForceRound());
                System.out.println("Defesa Atual computador->" + enemy.defenceForceRound());
                System.out.println("Enemy attack");
                enemy.attack(player);
                System.out.println("Total de impacto: " + enemy.getDamage());
                turn = true;
                if (player.defenceForceRound() <= 0) {
                    System.out.println("\n\nO computador ganhou!!");
                } else if (enemy.defenceForceRound() <= 0) {
                    System.out.println("\n\nVoce ganhou!!");
                }
                else {
                    System.out.println("\nPress ENTER to go to next round");
                    scanner.nextLine();
                }
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
            while (Verification.isInEnum(line.toUpperCase(), Menu.Command.class));
            Menu.Command command = Menu.Command.valueOf(line.toUpperCase());
            switch (command) {
                case CREATEARMY: {
                    clearConsole();
                    game.createArmies();
                    System.out.println("\nPress ENTER to continue...");
                    scanner.nextLine();
                    break;
                }
                case INSPECTARMY: {
                    clearConsole();
                    game.inspectArmies();
                    System.out.println("\nPress ENTER to continue...");
                    scanner.nextLine();
                    break;
                }
                case PLAY: {
                    game.play();
                    System.out.println("\nPress ENTER to continue...");
                    scanner.nextLine();
                    break;
                }
                case QUIT: {
                    run = false;
                    break;
                }
            }
        }
    }
}
