package entities.game;

import interfaces.game.Combattente;

public class Mago extends Personaggio implements Combattente {
    private int potereMagico;
    private int mana;

    public Mago(String name, int energia, int livello, int potereMagico, int mana) {
        super(name, energia, livello);
        this.potereMagico = potereMagico;
        this.mana = mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            this.mana = 0;
        } else if (mana > 100) {
            this.mana = 100;
        } else {
            this.mana = mana;
        }
    }

    public void azione(Personaggio avversario) {
        if (avversario.getEnergia() <= 0) {
            System.out.println("L'avversario non puo essere attaccato");
        } else if (getEnergia() <= 0) {
            System.out.println("Il personaggio non ha energia");
        } else {
            int danno = (this.potereMagico * this.mana * getLivello()) / 5;
            avversario.setEnergia(avversario.getEnergia() - danno);
            setMana(this.mana - danno / 3);
        }
    }


    public void medita() {
        if (this.mana > 100) {
            System.out.println("Mana gia carico al massimo ! ");
        } else {
            setMana(this.mana + 10);
        }
    }

    @Override
    public void mostraStatoCombattente() {
        System.out.println("------MAGO---------");
        System.out.println("Nome : " + getName());
        System.out.println("Livello . " + getLivello());
        System.out.println("Energia disponibile : " + getEnergia() + "/100");
        System.out.println("Mana : " + this.mana+ "/100");
        System.out.println("Potere magico : " + this.potereMagico+ "/100");
    }
}
