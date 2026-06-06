package entities.game;

import interfaces.game.NonCombattente;

import java.util.Scanner;

public class Mercante extends Personaggio implements NonCombattente {
    private int ricchezza;
    private int numOggettiPosseduti;

    public void setRicchezza(int ricchezza) {
        if (ricchezza < 0) {
            this.ricchezza = 0;
        }
        this.ricchezza = ricchezza;
    }

    public void setNumOggettiPosseduti(int numOggettiPosseduti) {
        if (numOggettiPosseduti < 0) {
            this.numOggettiPosseduti = 0;
        }
        this.numOggettiPosseduti = numOggettiPosseduti;
    }

    public Mercante(String name, int energia, int livello, int ricchezza, int numOggettiPosseduti) {
        super(name, energia, livello);
        this.ricchezza = ricchezza;
        this.numOggettiPosseduti = numOggettiPosseduti;
    }

    // COSTRUTTORE DA SCANNER
    public Mercante() {
        super("", 0, 0);
        Scanner scanner = new Scanner(System.in);
        //
        System.out.println("Inserisci il nome del mercante: ");
        this.setName(scanner.nextLine());
        //
        int energia;
        do {
            System.out.println("Inserisci il livello di energia da 1 a 100: ");
            energia = Integer.parseInt(scanner.nextLine());
        } while (energia < 1 || energia > 100);
        this.setEnergia(energia);
        //
        int livello;
        do {
            System.out.println("Inserisci il livello: ");
            livello = Integer.parseInt(scanner.nextLine());
        } while (livello < 1 || livello > 10);
        this.setLivello(livello);
        //
        int ricchezza;
        do {
            System.out.println("Inserisci la ricchezza del personaggio: ");
            ricchezza = Integer.parseInt(scanner.nextLine());
        } while (ricchezza < 0);
        this.setRicchezza(ricchezza);
        //
        int numOggetti;
        do {
            System.out.println("Inserisci il numero di oggetti posseduti: ");
            numOggetti = Integer.parseInt(scanner.nextLine());
        } while (numOggetti < 0);
        this.setNumOggettiPosseduti(numOggetti);
    }

    @Override
    public void mostraStato() {
        System.out.println("-------MERCANTE-------");
        System.out.println("Nome : " + getName());
        System.out.println("Livello . " + getLivello());
        System.out.println("Energia disponibile : " + getEnergia() + "/100");
        System.out.println("Ricchezza : " + this.ricchezza + "€");
        System.out.println("Numero di oggetti posseduti : " + this.numOggettiPosseduti);
    }


}
