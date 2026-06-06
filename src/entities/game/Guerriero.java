package entities.game;

import interfaces.game.Combattente;

import java.util.Scanner;

public class Guerriero extends Personaggio implements Combattente {
    private int forza;
    private int resistenza;


    public void setForza(int forza) {
        if (forza <= 0) {
            System.out.println("Devi inserire un valore maggiore di 0 ");
        } else if (forza > 100) {
            this.forza = 100;
        } else {
            this.forza = forza;
        }
    }

    public void setResistenza(int resistenza) {
        if (resistenza <= 0) {
            System.out.println("Devi inserire un valore maggiore di 0 ");
        } else if (resistenza > 100) {
            this.resistenza = 100;
        } else {
            this.resistenza = resistenza;
        }
    }

    public Guerriero(String name, int energia, int livello, int forza, int resistenza) {
        super(name, energia, livello);
        this.forza = forza;
        this.resistenza = resistenza;
    }

    //COSTRUTTORE DA SCANNER
    public Guerriero() {
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
            System.out.println("Inserisci il livello : ");
            livello = Integer.parseInt(scanner.nextLine());
        } while (livello < 1 || livello > 10);
        this.setLivello(livello);
        //
        int forza;
        do {
            System.out.println("Inserisci il livello di forza da 1 a 100");
            forza = Integer.parseInt(scanner.nextLine());
        } while (forza < 1 || forza > 100);
        this.setForza(forza);
        //
        int resistenza;
        do {
            System.out.println("Inserisci il livello di resistenza da 1 a 100");
            resistenza = Integer.parseInt(scanner.nextLine());
        } while (resistenza < 1 || resistenza > 100);
        this.setResistenza(resistenza);
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
            System.out.println(getName() + " non puo agire");
        } else {
            int danno = (this.forza + this.resistenza + getLivello()) / 10;
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
