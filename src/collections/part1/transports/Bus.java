package collections.part1.transports;

import collections.part1.drivers.DDriver;

public class Bus extends Transport<DDriver> {
    public enum Capacity {
        EXTRA_SMALL(null, 10),
        SMALL(null, 25),
        MEDIUM(40, 50),
        LARGE(60, 80),
        EXTRA_LARGE(100, 120);

        private final Integer minCapacity;
        private final Integer maxCapacity;

        Capacity(Integer minCapacity, Integer maxCapacity) {
            this.minCapacity = minCapacity;
            this.maxCapacity = maxCapacity;
        }

        @Override
        public String toString() {
            return String.format("Вместимость: %s %s", (minCapacity != null ? "от " + minCapacity + " человек" : ""),
                    maxCapacity != null ? "до " + maxCapacity + " человек" : "");
        }
    }
    private Capacity capacity;

    public Bus(String brand, String model, double engineVolume, DDriver driver, Capacity capacity) {
        super(brand, model, engineVolume, driver);
        this.capacity = capacity;
    }

    @Override
    public void passDiagnostic() {
        System.out.println("Автобусы не подлежат диагностике!");
    }

    @Override
    public void printType() {
        if (capacity == null) {
            System.out.println("Данных по т/с недостаточно");
        } else {
            System.out.println("Автобус: " + capacity);
        }
    }

    @Override
    public void startMoving() {
        System.out.printf("Автобус марки %s начал движение\n", getBrand());
    }

    @Override
    public void stopMoving() {
        System.out.printf("Автобус марки %s закончил движение\n", getBrand());
    }

    @Override
    public void pitStop() {
        System.out.printf("Водитель: %s из автобуса %s %s остановился на пит-стоп\n", getDriver().getFullname(), getBrand(), getModel());
    }

    @Override
    public double bestLapTime() {
        return LAP_DISTANCE / maxSpeed();
    }

    @Override
    public double maxSpeed() {
        return getEngineVolume() * 10; // Допустим объём двигателя будет показателем скорости :D
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }
}
