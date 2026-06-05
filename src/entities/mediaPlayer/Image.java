package entities.mediaPlayer;

import interfaces.mediaPlayer.HasLuminosita;
import interfaces.mediaPlayer.Visualizzabile;

import java.util.Scanner;

public class Image extends Media implements HasLuminosita, Visualizzabile {
    private int luminosita;

    //COSTRUTTORE STANDARD CON LUMINOSITA MEDIA GIA IMPOSTATA
    public Image(String name, String formato) {
        super(name, formato);
        this.luminosita = 5;
    }

    // //COSTRUTTORE STANDARD COMPLETO
    public Image(String name, int luminosita, String formato) {
        super(name, formato);
        this.luminosita = luminosita;
    }


    //METODO PER COSTRUIRE DA UTENTE
    public static Image creaImage() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il nome dell'immagine : ");
        String name = scanner.nextLine();

        System.out.println("Inserisci una luminosità da 1 a 10 : ");
        int luminosita = Integer.parseInt(scanner.nextLine());

        System.out.println("Inserisci il formato");
        String formato = scanner.nextLine();

        return new Image(name, luminosita, formato);
    }

    @Override
    public int getLuminosita() {
        return luminosita;
    }

    @Override
    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }

    public void stampaImage() {
        System.out.println("name : " + this.getName());
        System.out.println("luminosita : " + this.getLuminosita());
        System.out.println("formato : " + this.getFormato());
    }

    @Override
    public void show() {
        System.out.println(this.getName() + " " + "*".repeat(this.getLuminosita()));
    }

    @Override
    public String toString() {
        return "entities.mediaPlayer.Image{" +
                "luminosita=" + luminosita +
                "} " + super.toString();
    }
}
