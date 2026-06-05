package interfaces;

public interface HasVolume {
    int getVolume();

    void setVolume(int volume);

    default void AlzaVolume() {
        setVolume(getVolume() + 1);
    }

    default void abbassaVolume() {
        setVolume(getVolume() - 1);
    }
}
