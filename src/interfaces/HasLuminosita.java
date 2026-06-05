package interfaces;

public interface HasLuminosita {
    int getLuminosita();

    void setLuminosita(int luminosita);

    default void aumentaLuminosita() {
        setLuminosita(getLuminosita() + 1);
    }

    default void riduciLuminsita() {
        setLuminosita(getLuminosita() - 1);
    }
}
