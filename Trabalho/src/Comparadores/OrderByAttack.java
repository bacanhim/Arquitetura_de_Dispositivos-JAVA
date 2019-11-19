package Comparadores;

import Exercito.FightingForce;
import java.util.Comparator;

public class OrderByAttack implements Comparator<FightingForce> {

    @Override
    public int compare(FightingForce t, FightingForce t1) {
        return t1.getAtaque() - t.getAtaque();
    }
}
