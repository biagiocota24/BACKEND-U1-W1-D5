package entities;

import java.util.Scanner;

public class MediaPlayer {


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
                default -> System.out.println("Tipologia media non supportata ! ");
            }
        }

        System.out.println("Quale media vuoi riprodurre adesso ? Digita un valore da 1 a 5 ");
        int scelta = Integer.parseInt(scanner.nextLine()) - 1;

        if (scelta > 4 || scelta < -1) {
            System.out.println("Valore non valido !!");
        } else {
            while (scelta != 0) {

                if (scelta == -1) break;
                if (playlist[scelta] instanceof Image){
                    Image i = (Image)playlist[scelta];
                    i.show();
                }
                if (playlist[scelta] instanceof Recording){
                    Recording r = (Recording) playlist[scelta];
                    r.play();
                }
                if (playlist[scelta] instanceof Video){
                    Video v = (Video) playlist[scelta];
                    v.play();
                }
            }
        }


    }


}


