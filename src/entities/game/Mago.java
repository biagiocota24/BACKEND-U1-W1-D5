package entities.game;

import interfaces.game.Combattente;

import java.util.Scanner;

public class Mago extends Personaggio implements Combattente {
    private int potereMagico;
    private int mana;

    public void setPotereMagico(int potereMagico) {
        if (potereMagico <= 0) {
            System.out.println("Devi inserire un valore maggiore di 0 ");
        } else if (potereMagico > 100) {
            this.potereMagico = 100;
        } else {
            this.potereMagico = potereMagico;
        }
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

    public Mago(String name, int energia, int livello, int potereMagico, int mana) {
        super(name, energia, livello);
        this.potereMagico = potereMagico;
        this.mana = mana;
    }

    // COSTRUTTORE DA SCANNER
    public Mago() {
        super("", 0, 0);
        Scanner scanner = new Scanner(System.in);
        //
        String name;
        do {
            System.out.println("Inserisci il nome del guerriero: ");
            name = scanner.nextLine();
            if (name.length() <= 0) System.out.println("Il nome non può essere vuoto!");
        } while (name.length() <= 0);
        this.setName(name);
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
        int potereMagico;
        do {
            System.out.println("Inserisci il livello di potere magico da 1 a 100: ");
            potereMagico = Integer.parseInt(scanner.nextLine());
        } while (potereMagico < 1 || potereMagico > 100);
        this.setPotereMagico(potereMagico);
        //
        int mana;
        do {
            System.out.println("Inserisci il livello di mana da 1 a 100: ");
            mana = Integer.parseInt(scanner.nextLine());
        } while (mana < 1 || mana > 100);
        this.setMana(mana);
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
        System.out.println("Mana : " + this.mana + "/100");
        System.out.println("Potere magico : " + this.potereMagico + "/100");
    }
}
