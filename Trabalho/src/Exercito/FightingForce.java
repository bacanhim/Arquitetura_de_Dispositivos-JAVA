package Exercito;

public abstract class FightingForce {
    private int ataque;
    private int defesa;

    public FightingForce(int ataque, int defesa) {
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

}
