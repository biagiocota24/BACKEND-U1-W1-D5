package entities;

import interfaces.HasVolume;
import interfaces.Riproducibile;

import java.util.Scanner;

public class Recording extends Media implements Riproducibile, HasVolume {
    private int durata;
    private int volume;

    //COSTRUTTORE STANDARD CON VOLUME IMPOSTATO
    public Recording(String name, int durata, String formato) {
        super(name, formato);
        this.durata = durata;
        this.volume = 5;
    }

    // COSTRUTTORE COMPLETO
    public Recording(String name, int durata, String formato, int volume) {
        super(name, formato);
        this.durata = durata;
        this.volume = volume;
    }

    //METODO PER COSTRUIRE DA UTENTE

    public static Recording creaRecording() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il nome dell'Audio : ");
        String name = scanner.nextLine();

        System.out.println("Inserisci la durata : ");
        int durata = Integer.parseInt(scanner.nextLine());

        System.out.println("Inserisci il formato : ");
        String formato = scanner.nextLine();

        System.out.println("Inserisci il volume di riproduzione da 1 a 10 : ");
        int volume = Integer.parseInt(scanner.nextLine());

        return new Recording(name, durata, formato, volume);
    }


    public int getVolume() {
        return volume;
    }

    public int getDurata() {
        return durata;
    }


    public void setVolume(int volume) {
        if (volume > 10) {
            this.volume = 10;
        } else if (volume < 0) {
            this.volume = 0;
        } else {
            this.volume = volume;
        }
    }

    @Override
    public void setDurata(int durata) {
        this.durata = durata;
    }

    @Override
    public String toString() {
        return "entities.Recording{" +
                super.toString() +
                "durata=" + durata +
                ", volume=" + volume +
                '}';
    }

    @Override
    public void play() {
        for (int i = this.durata; i >= 0; i--) {
            System.out.println(this.getName() + " " + "!".repeat(this.volume));
            if (i == 0) {
                System.out.println("finito");
            }
        }
    }


}
