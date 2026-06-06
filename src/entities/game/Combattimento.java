package entities.game;
import interfaces.game.Combattente;
import interfaces.game.NonCombattente;
import java.util.Scanner;

public class Combattimento {
    //CON ARRAY PRONTO
    public static void combatti(Personaggio[] personaggi) {
        Scanner scanner = new Scanner(System.in);

        //SELEZIONE PRIMO PERSONAGGIO
        int primo;
        do {
            System.out.println("Seleziona il primo personaggio inserendo un numero da 1 a " + personaggi.length);
            primo = Integer.parseInt(scanner.nextLine());
        } while (primo < 1 || primo > personaggi.length);
        Personaggio primoPers = personaggi[primo - 1];
        System.out.println("Hai selezionato : " + primoPers.getName());

        //SELEZIONE SECONDO PERSONAGGIO 
        int secondo;
        do {
            System.out.println("Seleziona il secondo personaggio inserendo un numero da 1 a " + personaggi.length + " e diverso dal primo personaggio");
            secondo = Integer.parseInt(scanner.nextLine());
        } while (secondo < 1 || secondo > personaggi.length || secondo == primo);
        Personaggio secondoPers = personaggi[secondo - 1];
        System.out.println("Hai selezionato : " + secondoPers.getName());

        // VERIFICO SE IL PRIMO PERSONAGGIO E UN COMBATTENTE
        if (primoPers instanceof Combattente) {

            // VARIABILE PER SAPERE A CHE GIRO SIAM0
            int giro = 1;

            // CICLO CON CONDIZIONI PER FARGLI SCONTRARE RIPETUTAMENTE FINO A ESAURIMENTO ENERGIA
            do {

                //STAMPA LO SCONTRO IN CUI CI TROVIAMO
                System.out.println("---------Scontro " + giro + "-----------");
                giro++;

                // PRIMO PERSONAGGIO ATTACCA
                ((Combattente) primoPers).azione(secondoPers);

                // SE LA SUA ENERGIA ARRIVA A 0 SI ESCE
                if (secondoPers.getEnergia() <= 0) {
                    System.out.println("----------Scontro terminato-------------");
                    break;
                }

                // VERIFICO CHE IL SECONDO PERSONAGGIO SIA UN COMBATTENTE
                if (secondoPers instanceof Combattente) {

                    // SE E COMBATTENTE ATTACCA IL PRIMO PERSONAGGIO
                    ((Combattente) secondoPers).azione(primoPers);

                    // SE LA SUA ENERGIA ARRIVA A 0 SI ESCE
                    if (primoPers.getEnergia() <= 0) {
                        System.out.println("----------Scontro terminato-------------");
                        break;
                    }
                }

                // MOSTRO LO STATO DEI DUE COMBATTENTI
                if (secondoPers instanceof Combattente) {
                    ((Combattente) primoPers).mostraStatoCombattente();
                    ((Combattente) secondoPers).mostraStatoCombattente();
                }

                // MOSTRO LO STATO DI UN COMBATTENTE E DI UN NON-COMBATTENTE
                else if (secondoPers instanceof NonCombattente) {
                    ((Combattente) primoPers).mostraStatoCombattente();
                    ((NonCombattente) secondoPers).mostraStato();
                }

                // SE ENTRAMBI HANNO ENERGIA RESIDUA SI VA AL PROSSIMO SCONTRO
            } while (primoPers.getEnergia() > 0 && secondoPers.getEnergia() > 0);

            // ASSEGNO A DELLE VARIABILI IL VINCITORE E IL PERDENTE
            Personaggio vincitore;
            Personaggio perdente;

            if (primoPers.getEnergia() > 0) {
                vincitore = primoPers;
                perdente = secondoPers;
            } else {
                vincitore = secondoPers;
                perdente = primoPers;
            }

            // STAMPO CHI E IL VINCITORE
            System.out.println("Il combattimento è stato vinto da " + vincitore.getName());

        }
        // QUI SI ENTRA SE IL PRIMO PERSONAGGIO NON E UN COMBATTENTE
        else {
            System.out.println("Il personaggio non è un combattente e quindi non puo combattere !");
        }
    }


    public static void creaPersonaggiECombatti() {
        Scanner scanner = new Scanner(System.in);

        // CHIEDO QUANTI PERSONAGGI SI VOGLIANO CREARE
        System.out.println("Quanti personaggi vuoi creare ?");
        int numPersonaggi = Integer.parseInt(scanner.nextLine());

        // CREO ARRAY DEI PERSONAGGI CON LUNGHEZZA INDICATA PRIMA
        Personaggio[] personaggi = new Personaggio[numPersonaggi];

        // CICLO PER CREARE TANTI PERSONAGGI QUANTO SELEZIONATO
        for (int i = 0; i < personaggi.length; i++) {

            // CHIEDO CHE TIPO DI PERSONAGGIO SI VOGLIO CREARE
            System.out.println("Quale tipo di personaggio vuoi creare ? 'guerriero' , 'mago' , mercante");
            String tipoPersonaggio = scanner.nextLine();

            // A SECONDA DELLA SCELTA RICHIAMO UN COSTRUTTORE CHE CREA UN NUOVO PERSONAGGIO E LO METTE NELL'ARRAY
            switch (tipoPersonaggio) {
                case "guerriero" -> personaggi[i] = new Guerriero();
                case "mago" -> personaggi[i] = new Mago();
                case "mercante" -> personaggi[i] = new Mercante();
                // SE IL TIPO DI PERSONAGGIO SCELTO NON ERA VALIDO DECREMENTA L'INDICE E TE LO FA REINSERIRE
                default -> {
                    System.out.println("Tipo personaggio non disponibile ! ");
                    i--;
                }
            }
        }

        // CHIAMO IL METODO PER IL COMBATTIMENTO
        combatti(personaggi);
    }
}
