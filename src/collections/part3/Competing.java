package collections.part3;

public interface Competing {
    double LAP_DISTANCE = 750;

    default void pitStop() {
        System.out.println("Остановился на пит-стоп");
    }

    double bestLapTime();

    double maxSpeed();
}
