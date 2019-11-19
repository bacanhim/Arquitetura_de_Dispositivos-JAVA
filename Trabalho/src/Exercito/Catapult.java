package Exercito;

public class Catapult extends FightingForce {
    public Catapult() {
        super(100, 1);
    }
    @Override
    public String toString() {
        return "\nCatapulta: "+ super.toString();
    }
}
