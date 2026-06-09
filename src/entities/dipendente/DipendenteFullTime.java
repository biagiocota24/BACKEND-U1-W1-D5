package entities.dipendente;

public class DipendenteFullTime extends Dipendente {

    private static final int GIORNI_MENSILI = 26;
    private double pagaGiornaliera;
    private int giorniMensili;

    public static double getPagaGiornaliera(Dipartimento dipartimento) {
        return switch (dipartimento) {
            case PRODUZIONE -> 50;
            case VENDITE -> 80;
            case AMMINISTRAZIONE -> 100;
        };
    }

    public DipendenteFullTime(int matricola, Dipartimento dipartimento) {
        super(matricola, getPagaGiornaliera(dipartimento) * GIORNI_MENSILI, dipartimento);
        this.giorniMensili = GIORNI_MENSILI;
        this.pagaGiornaliera = getPagaGiornaliera(dipartimento);

    }
}
