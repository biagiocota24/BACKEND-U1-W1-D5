import interfaces.HasLuminosita;

public class Video extends Recording implements HasLuminosita {
    private int luminosita;

    public Video(String formato, int durata, String name) {
        super(durata, name, formato, 10);
        this.luminosita = 5;
    }

    public int getLuminosita() {
        return luminosita;
    }

    @Override
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
        return "Video{" +
                "luminosita=" + luminosita +
                "} " + super.toString();
    }
}
