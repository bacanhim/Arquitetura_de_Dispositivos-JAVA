package Exercito;

import java.util.ArrayList;
import java.util.Random;

public class Army {
    int damage;
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
                attackForce.add(new Cavalry());
            } else {
                defenceForce.add(new Cavalry());
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

    public ArrayList<FightingForce> getDefenceForce() {
        return defenceForce;
    }

    public ArrayList<FightingForce> getAttackForce() {
        return attackForce;
    }

    public int attackForceRound() {
        int ataque = 0;
        for (int i = 0; i < getAttackForce().size(); i++) {
            ataque += getAttackForce().get(i).getAtaque() * (Math.random());
        }
        return ataque;
    }

    public int defenceForceRound() {
        int defesa = 0;
        for (int i = 0; i < getDefenceForce().size(); i++) {
            defesa += getDefenceForce().get(i).getDefesa();
        }
        return defesa;
    }

    public void attack(Army victim) {
        damage = attackForceRound();
        victim.removeDef(damage);
    }

    public int getDamage() {
        return damage;
    }

    private void removeDef(int damage) {
        for (int i = 0; i < getDefenceForce().size(); i++) {
            if (getDefenceForce().get(i).getDefesa() < damage) {
                damage -= getDefenceForce().get(i).getDefesa();
                getDefenceForce().remove(i);
                i--;
            } else if (getDefenceForce().get(i).getDefesa() > damage && damage > 0) {
                getDefenceForce().get(i).setDefesa(getDefenceForce().get(i).getDefesa() - damage);
                i--;
                damage = 0;
            }
        }
    }

}
