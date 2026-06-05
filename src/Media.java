public abstract class Media {

    private String name;
    private String formato;

    public Media(String name, String formato) {
        this.name = name;
        this.formato = formato;
    }

    public String getName() {
        return name;
    }

    public String getFormato() {
        return formato;
    }


    @Override
    public String toString() {
        return "Media{" +
                "name='" + name + '\'' +
                ", formato='" + formato + '\'' +
                '}';
    }
}
