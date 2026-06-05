package entities.game;

import interfaces.game.Combattente;

public class Guerriero extends Personaggio implements Combattente {
    private int forza;
    private int resistenza;

    public Guerriero(String name, int energia, int livello, int forza, int resistenza) {
        super(name, energia, livello);
        this.forza = forza;
        this.resistenza = resistenza;
    }

    public void allenati() {
        if (getEnergia() <= 0) {
            System.out.println("Il personaggio è esausto , non puo allenarsi !");
        } else {
            this.resistenza = this.resistenza + 5;
            if (this.resistenza > 100) {
                this.resistenza = 100;
            }
        }
    }

    public void azione(Personaggio avversario) {
        if (getEnergia() <= 0) {
            System.out.println("il personaggio non puo agire");
        } else {
            int danno = (this.forza * this.resistenza * getLivello()) / 10;
            avversario.setEnergia(avversario.getEnergia() - danno);
            setEnergia(getEnergia() - danno / 5);
        }

    }

    @Override
    public void mostraStatoCombattente() {
        System.out.println("------GUERRIERO---------");
        System.out.println("Nome : " + getName());
        System.out.println("Livello . " + getLivello());
        System.out.println("Energia disponibile : " + getEnergia() + "/100");
        System.out.println("Forza : " + this.forza + "/100");
        System.out.println("Resistenza : " + this.resistenza + "/100");
    }
}
