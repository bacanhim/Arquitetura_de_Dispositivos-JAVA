package Comparadores;

import Exercito.FightingForce;
import java.util.Comparator;

public class OrderByAttack implements Comparator<FightingForce> {

    @Override
    public int compare(FightingForce fightingForce, FightingForce t1) {
        return fightingForce.getAtaque() - t1.getAtaque();
    }
}
