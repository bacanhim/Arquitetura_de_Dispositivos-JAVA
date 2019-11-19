package Exercito;

public class Cavalry extends FightingForce {
    public Cavalry() {
        super(50, 50);
    }
    @Override
    public String toString() {
        return "Cavalaria: "+ super.toString();
    }
}
