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

    // create random bot army
    private void createArmyBot() {
        Random random = new Random();
        final int max = 100;
        int total = 0;
        int catapult = random.nextInt(max);
        total += catapult;
        int cavalary = random.nextInt(max - total);
        total += cavalary;
        int infantry = random.nextInt(max - total);
        total += infantry;
        int percentage = random.nextInt(100 + 1);
        enemy = new Army(catapult, cavalary, infantry, percentage);
    }

    // create my army
    private void createArmies() {
        int catapult, cavalary = 0, infantry = 0, percentage, total = 0;
        System.out.println("\n\nNOTA: Exército não pode ultrupassar as 100 Unidades.");
        do {
            catapult = Verification.isInt("Unidades de Catapultas: \n");
        }
        while (catapult < 0 || catapult > 100);
        total += catapult;
        if (total < 100) {
            System.out.println("\nTropas restantes: " + (100 - total));
            do {
                cavalary = Verification.isInt("Unidades de Cavalaria: \n");
            }
            while (cavalary < 0 || cavalary > 100 - catapult);
        }
        total += cavalary;
        if (total < 100) {
            System.out.println("\nTropas restantes: " + (100 - total));
            do {
                infantry = Verification.isInt("Unidades de Infantaria: \n");
            }
            while (infantry < 0 || infantry > 100 - cavalary - catapult);
        }
        total += infantry;
        do {
            percentage = Verification.isInt("Percentagem de unidades para o ataque: \n");
        }
        while (percentage > 100 || percentage < 0);
        player = new Army(catapult, cavalary, infantry, percentage);
        createArmyBot();
    }

    // inspect armies
    public void inspectArmies() {
        String line = Verification.isTrue("Deseja visualizar as tropas por ordem de ataque: (sim/nao)");
        if (line.equals("sim")) {
            if (player.getAttackForce().size() == 0 && player.getDefenceForce().size() == 0 && enemy.getAttackForce().size() == 0 && enemy.getDefenceForce().size() == 0) {
                System.out.println("Deverá criar os armies primeiro.");
            } else {
                System.out.println("PLAYER - Exercito ordenado: ");
                player.Order();
                System.out.print("Ataque");
                System.out.println(player.getAttackForce());
                System.out.print("Defesa");
                System.out.println(player.getDefenceForce());
                System.out.println("COMPUTADOR - Exercito ordenado: ");
                enemy.Order();
                System.out.print("Ataque");
                System.out.println(enemy.getAttackForce());
                System.out.print("Defesa");
                System.out.println(enemy.getDefenceForce());
            }

        }
        if (line.equals("nao")) {
            if (player.getAttackForce().size() == 0 && player.getDefenceForce().size() == 0 && enemy.getAttackForce().size() == 0 && enemy.getDefenceForce().size() == 0) {
                System.out.println("Deverá criar os armies primeiro.");
            } else {
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
                    game.createArmies();
                    System.out.println("\nPressione ENTER para continuar...");
                    scanner.nextLine();
                    break;
                }
                case INSPECTARMY: {
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
