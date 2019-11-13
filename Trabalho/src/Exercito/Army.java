package Exercito;

import java.util.ArrayList;
import java.util.Random;

public class Army {
    ArrayList<FightingForce> attackForce;
    ArrayList<FightingForce> defenceForce;

    public Army() {
        attackForce = new ArrayList<FightingForce>();
        defenceForce = new ArrayList<FightingForce>();
    }

    public Army(int catapultas, int cavalaria, int infantaria, int side) {
        attackForce = new ArrayList<FightingForce>();
        defenceForce = new ArrayList<FightingForce>();
        for (int i = 0; i < catapultas; i++) {
            Random random = new Random();
            if (random.nextDouble() * 100 < side) {
                attackForce.add(new Catapult());
            } else {
                defenceForce.add(new Catapult());
            }
        }
        for (int i = 0; i < cavalaria; i++) {
            Random random = new Random();
            if (random.nextDouble() * 100 < side) {
                attackForce.add(new Cavalary());
            } else {
                defenceForce.add(new Cavalary());
            }
        }
        for (int i = 0; i < infantaria; i++) {
            Random random = new Random();
            if (random.nextDouble() * 100 < side) {
                attackForce.add(new Infantry());
            } else {
                defenceForce.add(new Infantry());
            }
        }
    }
}
