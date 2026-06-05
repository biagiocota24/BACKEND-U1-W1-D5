package entities.game;

import interfaces.game.NonCombattente;

public class Mercante extends Personaggio implements NonCombattente {
    private int ricchezza;
    private int numOggettiPosseduti;

    public Mercante(String name, int energia, int livello, int ricchezza, int numOggettiPosseduti) {
        super(name, energia, livello);
        this.ricchezza = ricchezza;
        this.numOggettiPosseduti = numOggettiPosseduti;
    }

    @Override
    public void mostraStato() {
        System.out.println("-------MERCANTE-------");
        System.out.println("Nome : " + getName());
        System.out.println("Livello . " + getLivello());
        System.out.println("Energia disponibile : " + getEnergia() + "/100");
        System.out.println("Ricchezza : " + this.ricchezza+"€");
        System.out.println("Numero di oggetti posseduti : " + this.numOggettiPosseduti);
    }


}
