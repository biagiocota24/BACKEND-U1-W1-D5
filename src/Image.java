import interfaces.HasLuminosita;
import interfaces.Riproducibile;
import interfaces.Visualizzabile;

public class Image extends Media implements HasLuminosita, Visualizzabile {
    private int luminosita;

    @Override
    public int getLuminosita() {
        return luminosita;
    }

    @Override
    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }

    public Image(String name, int luminosita, String formato) {
        super(name, formato);
        this.luminosita = luminosita;
    }

    public void stampaImage() {
        System.out.println("name : " + this.getName());
        System.out.println("luminosita : " + this.getLuminosita());
        System.out.println("formato : " + this.getFormato());
    }

    @Override
    public void show() {
        System.out.println(this.getName() + " " + "*".repeat(this.luminosita));
    }
}
