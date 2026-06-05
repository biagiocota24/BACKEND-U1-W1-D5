package entities.mediaPlayer;

import java.util.Scanner;

public class MediaPlayer {

    // PER CREARE TUTTI GLI ELEMENTI DA SOLO
    public static void riproduci() {
        Scanner scanner = new Scanner(System.in);
        Media[] playlist = new Media[5];

        for (int i = 0; i < playlist.length; i++) {

            System.out.println("Quale tipo di contenuto vuoi creare ? ( immagine , audio , video )");
            String type = scanner.nextLine();

            switch (type) {
                case "immagine" -> playlist[i] = Image.creaImage();
                case "audio" -> playlist[i] = Recording.creaRecording();
                case "video" -> playlist[i] = Video.creaVideo();
                default -> {
                    System.out.println("Tipologia media non supportata ! ");
                    i--;
                }
            }
        }

        System.out.println("Quale media vuoi riprodurre adesso ? Digita un valore da 1 a 5 . Digita 0 se vuoi ");
        int scelta = Integer.parseInt(scanner.nextLine()) - 1;


        while (scelta != -1) {
            if (scelta > playlist.length - 1 || scelta < 0) {
                System.out.println("Valore non valido !!");
            } else {
                if (playlist[scelta] instanceof Image) {
                    Image i = (Image) playlist[scelta];
                    i.show();
                } else if (playlist[scelta] instanceof Recording) {
                    Recording r = (Recording) playlist[scelta];
                    r.play();
                } else if (playlist[scelta] instanceof Video) {
                    Video v = (Video) playlist[scelta];
                    v.play();
                }
            }
            System.out.println("Quale media vuoi riprodurre adesso ? Digita un valore da 1 a 5 . Digita 0 se vuoi uscire");
            scelta = Integer.parseInt(scanner.nextLine()) - 1;
        }
    }

    // CON LISTA GIA PRONTA
    public static void riproduciConListaPronta(Media[] playlist) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quale media vuoi riprodurre adesso ? Digita un valore da 1 a 5 . Digita 0 se vuoi uscire");
        int scelta = Integer.parseInt(scanner.nextLine()) - 1;


        while (scelta != -1) {
            if (scelta > playlist.length - 1 || scelta < 0) {
                System.out.println("Valore non valido !!");
            } else {
                if (playlist[scelta] instanceof Image) {
                    Image i = (Image) playlist[scelta];
                    i.show();
                } else if (playlist[scelta] instanceof Recording) {
                    Recording r = (Recording) playlist[scelta];
                    r.play();
                } else if (playlist[scelta] instanceof Video) {
                    Video v = (Video) playlist[scelta];
                    v.play();
                }
            }
            System.out.println("Quale media vuoi riprodurre adesso ? Digita un valore da 1 a 5 . Digita 0 se vuoi ");
            scelta = Integer.parseInt(scanner.nextLine()) - 1;
        }
    }


}





