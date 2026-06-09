package entities.dipendente;

public class DipendentePartTime extends Dipendente implements CalculateSalary {
    private int oreLavorate;
    private static final double pagaOraria = 7.50;

    public DipendentePartTime(int matricola, int oreLavorate) {
        super(matricola, pagaOraria * oreLavorate, Dipartimento.PRODUZIONE);
        this.oreLavorate = oreLavorate;
    }

    @Override
    public double calculateSalary() {
        return pagaOraria * oreLavorate;
    }
}
