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
        if (this.energia <= 0){
            System.out.println("Personaggio gia sconfitto");
        }else{
            this.energia = energia;
        }
    }
}
