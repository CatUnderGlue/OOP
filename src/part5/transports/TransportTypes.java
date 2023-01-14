package part5.transports;

public enum TransportTypes {
    CAR("Легковой автомобиль"),
    TRUCK("Грузовой автомобиль"),
    BUS("Автобус");
    private final String translate;

    TransportTypes(String translate) {
        this.translate = translate;
    }

    @Override
    public String toString() {
        return translate;
    }
}
