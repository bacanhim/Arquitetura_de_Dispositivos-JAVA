package Exercito;

public class Infantry extends FightingForce {
    public Infantry() {
        super(25, 75);
    }
    @Override
    public String toString() {
        return "Infantaria: "+ super.toString();
    }
}
