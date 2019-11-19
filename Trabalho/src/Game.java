import Exercito.Army;
import Exercito.Catapult;
import Menu.Menu;
import Utils.Verification;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    private Army player = new Army();
    private Army enemy = new Army();

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

    // create random bot army
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

    // create my army
    private void createArmies() {
        clearConsole();
        int catapult, cavalary, infatry, percentage, total;
        System.out.println("\n\nNOTA: Exército não pode ultrupassar as 100 Unidades.");
        catapult = Verification.isInt("Unidades de Catapultas: \n");
        System.out.println("\nTropas restantes: " + (100 - catapult));
        cavalary = Verification.isInt("Unidades de Cavalaria: \n");
        System.out.println("\nTropas restantes: " + (100 - catapult - cavalary));
        infatry = Verification.isInt("Unidades de Infantaria: \n");
        percentage = Verification.isInt("Percentagem de unidades para o ataque: \n");
        total = catapult + cavalary + infatry;
        if (total > 100) {
            System.out.println("ERRO: Exército com demasiadas unidades. Volte a criar!\n");
            createArmies();
        } else {
            player = new Army(catapult, cavalary, infatry, percentage);
        }
        createArmyBot();
    }

    // inspect armies
    public void inspectArmies() {
        String line = Verification.isTrue("Deseja visualizar as tropas por ordem de ataque: (sim/nao)");
        if (line.equals("sim")) {

        } if(line.equals("nao")) {
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
            System.out.println("\n|------------- PLAYER -------------|");
            System.out.println("\nTROPAS NO ATAQUE: " + qtTotal + "\nCatapultas: " + qtCatapult + "\nCavalaria: " + qtCavalary + "\nInfantaria: " + qtInfantry);
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
            System.out.println("\nTROPAS NA DEFESA: " + qtTotal + "\nCatapultas: " + qtCatapult + "\nCavalaria: " + qtCavalary + "\nInfantaria: " + qtInfantry);
            System.out.println("\n|------------ COMPUTADOR ------------|");
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
            System.out.println("\nTROPAS NO ATAQUE:  " + qtTotal + "\nCatapultas: " + qtCatapult + "\nCavalaria: " + qtCavalary + "\nInfantaria: " + qtInfantry);
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
            System.out.println("\nTROPAS NA DEFESA: " + qtTotal + "\nCatapultas: " + qtCatapult + "\nCavalaria: " + qtCavalary + "\nInfantaria: " + qtInfantry);
        }

    }

    // start
    public void play() {
        Random random = new Random();
        boolean turn = random.nextBoolean();
        int rounds = 0;
        while (player.defenceForceRound() > 0 && enemy.defenceForceRound() > 0) {
            if (turn) {
                rounds++;
                System.out.println("-------- RONDA " + rounds + " - PLAYER ATACA COMPUTADOR ------");
                System.out.println("Defesa do Player: " + player.defenceForceRound());
                System.out.println("Defesa do Computador: " + enemy.defenceForceRound());
                player.attack(enemy);
                System.out.println("Impacto do Ataque: " + player.getDamage());
                turn = false;
                if (enemy.defenceForceRound() <= 0) {
                    System.out.println("\n[- PLAYER GANHOU A BATALHA -]");
                } else if (player.defenceForceRound() <= 0) {
                    System.out.println("\n[- COMPUTADOR GANHOU A BATALHA -]");
                } else {
                    System.out.println("\nPressione ENTER para passar à próxima ronda.");
                    scanner.nextLine();
                }
            } else {
                rounds++;
                System.out.println("-------- RONDA " + rounds + " - COMPUTADOR ATACA PLAYER ------");
                System.out.println("Defesa do Player: " + player.defenceForceRound());
                System.out.println("Defesa do Computador: " + enemy.defenceForceRound());
                enemy.attack(player);
                System.out.println("Impacto do Ataque: " + enemy.getDamage());
                turn = true;
                if (player.defenceForceRound() <= 0) {
                    System.out.println("\n[- COMPUTADOR GANHOU A BATALHA -]");
                } else if (enemy.defenceForceRound() <= 0) {
                    System.out.println("\n[- PLAYER GANHOU A BATALHA -]");
                } else {
                    System.out.println("\nPressione ENTER para passar à próxima ronda.");
                    scanner.nextLine();
                }
            }
        }
    }

    //menu and call functions
    public static void main(String[] args) {
        Game game = new Game();
        boolean run = true;
        while (run) {
            System.out.println("----- MENU -----");
            Menu.Command[] options = Menu.Command.values();
            for (Menu.Command option : options) {
                String name = option.name();
                int number = option.ordinal();
                System.out.println(number + " - " + name);
            }
            Scanner scanner = new Scanner(System.in);
            String line;
            do {
                System.out.println("\nINTRODUZA UM COMANDO: ");
                line = scanner.nextLine();
            }
            while (Verification.isInEnum(line.toUpperCase(), Menu.Command.class));

            Menu.Command command = Menu.Command.valueOf(line.toUpperCase());
            switch (command) {
                case CREATEARMY: {
                    clearConsole();
                    game.createArmies();
                    System.out.println("\nPressione ENTER para continuar...");
                    scanner.nextLine();
                    break;
                }
                case INSPECTARMY: {
                    clearConsole();
                    game.inspectArmies();
                    System.out.println("\nPressione ENTER para continuar...");
                    scanner.nextLine();
                    break;
                }
                case PLAY: {
                    game.play();
                    System.out.println("\nPressione ENTER para continuar...");
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
