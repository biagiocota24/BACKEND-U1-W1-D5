package entities.mediaPlayer;

import interfaces.mediaPlayer.HasLuminosita;
import interfaces.mediaPlayer.HasVolume;
import interfaces.mediaPlayer.Riproducibile;

import java.util.Scanner;

public class Video extends Media implements HasLuminosita, HasVolume, Riproducibile {
    private int luminosita;
    private int volume;
    private int durata;

    //COSTRUTTORE STANDARD CON LUMINOSITA E VOLUME MEDII GIA IMPOSTATA
    public Video(String name, int durata, String formato) {
        super(name, formato);
        this.volume = 5;
        this.luminosita = 5;
        this.durata = durata;
    }

    //COSTRUTTORE STANDARD COMPLETO
    public Video(String name, int durata, int volume, int luminosita, String formato) {
        super(name, formato);
        this.volume = volume;
        this.luminosita = luminosita;
        this.durata = durata;
    }

    //COSTRUTTORE PER UTENTE

    public static Video creaVideo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il nome del Video : ");
        String name = scanner.nextLine();

        System.out.println("Inserisci la durata : ");
        int durata = Integer.parseInt(scanner.nextLine());

        System.out.println("Inserisci il volume di riproduzione da 1 a 10 : ");
        int volume = Integer.parseInt(scanner.nextLine());

        System.out.println("Inserisci la luminosità desiderata da 1 a 10 : ");
        int luminosita = Integer.parseInt(scanner.nextLine());

        System.out.println("Inserisci il formato : ");
        String formato = scanner.nextLine();

        return new Video(name, durata, volume, luminosita, formato);
    }

    public int getVolume() {
        return volume;
    }

    public int getLuminosita() {
        return luminosita;
    }

    @Override
    public int getDurata() {
        return durata;
    }

    @Override
    public void setDurata(int durata) {
        this.durata = durata;
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


    public void setLuminosita(int luminosita) {
        if (luminosita > 10) {
            this.luminosita = 10;
        } else if (luminosita < 1) {
            this.luminosita = 1;
        } else {
            this.luminosita = luminosita;
        }
    }

    @Override
    public void play() {
        for (int i = this.getDurata(); i >= 0; i--) {
            System.out.println(this.getName() + " " + "!".repeat(this.getVolume()) + " " + "*".repeat(this.luminosita));
        }
    }

    @Override
    public String toString() {
        return "entities.mediaPlayer.Video{" +
                "luminosita=" + luminosita +
                ", volume=" + volume +
                ", durata=" + durata +
                "} " + super.toString();
    }
}
