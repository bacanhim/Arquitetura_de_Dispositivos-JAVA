import Exercito.Army;

import java.util.Random;

public class Game {

    private Army player;
    private Army enemy;

    private void createArmies() {

        player = new Army(30,20, 40, 50);
    }

    public static void main(String[] args) {
        Game game = new Game();

        //criar exercitos
        game.createArmies();

    }
}
