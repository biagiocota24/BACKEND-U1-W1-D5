import interfaces.Riproducibile;

public class Recording extends Media implements Riproducibile {
    private int durata;
    private int volume;

    public Recording(int durata, String name, String formato) {
        super(name, formato);
        this.durata = durata;
        this.volume = 5;
    }

    public Recording(int durata, String name, String formato, int volume) {
        super(name, formato);
        this.durata = durata;
        this.volume = volume;
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

    public int getVolume() {
        return volume;
    }

    public int getDurata() {
        return durata;
    }

    public void AlzaVolume() {
        setVolume(volume + 1);
    }

    public void abbassaVolume() {
        setVolume(volume - 1);
    }


    @Override
    public String toString() {
        return "Recording{" +
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
