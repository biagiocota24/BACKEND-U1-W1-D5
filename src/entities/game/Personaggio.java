package entities.game;

public abstract class Personaggio {
    private String name;
    private int energia;
    private int livello;

    public Personaggio(String name, int energia, int livello) {
        this.name = name;
        this.energia = energia;
        this.livello = livello;
    }

    public String getName() {
        return name;
    }

    public int getEnergia() {
        return energia;
    }

    public int getLivello() {
        return livello;
    }

    public void setEnergia(int energia) {
        if (energia <= 0) {
            System.out.println(this.getName() + " sconfitto");
            this.energia = 0;
        } else if (energia > 100) {
            this.energia = 100;
        } else {
            this.energia = energia;
        }
    }

    public void setLivello(int livello) {
        if (livello <= 0) {
            System.out.println("Devi inserire un valore maggiore di 0 !");
        } else if (livello > 10) {
            this.livello = 10;
        } else {
            this.livello = livello;
        }
    }

    public void setName(String name) {
        if (name.length() <= 0) {
            System.out.println("Devi inserire un nome");
        } else if (name.length() > 30) {
            System.out.println("Che nome strano !!");
            System.out.println("Te lo accettiamo comunque !");
            this.name = name;
        } else {
            this.name = name;
        }
    }
}
