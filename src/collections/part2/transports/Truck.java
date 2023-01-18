package collections.part2.transports;

import collections.part2.drivers.CDriver;
import collections.part2.exceptions.CantFindLicense;

public class Truck extends Transport<CDriver> {
    public enum Carrying {
        N1(null, 3.5),
        N2(3.5, 12.0),
        N3(12.0, null);

        private final Double minValue;
        private final Double maxValue;

        Carrying(Double minValue, Double maxValue) {
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        @Override
        public String toString() {
            return String.format("Грузоподъёмность: %s %s", (minValue != null ? "от " + minValue + " тонн" : ""),
                    maxValue != null ? "до " + maxValue + " тонн" : "");
        }
    }
    private Carrying carrying;

    public Truck(String brand, String model, double engineVolume, CDriver driver, Carrying carrying) {
        super(brand, model, engineVolume, driver);
        this.carrying = carrying;
    }

    @Override
    public void passDiagnostic() throws CantFindLicense {
        if (!getDriver().isHasDriveLicense()){
            throw new CantFindLicense("У водителя отсутствуют водительские права!");
        } else {
            System.out.printf("Диагностика грузового автомобиля - %s %s успешно пройдена\n", getBrand(), getModel());
        }
    }

    @Override
    public void printType() {
        if (carrying == null){
            System.out.println("Данных по т/с недостаточно");
        } else {
            System.out.println("Грузовой автомобиль: " + carrying);
        }
    }

    @Override
    public void startMoving() {
        System.out.printf("Грузовик марки %s начал движение\n", getBrand());
    }

    @Override
    public void stopMoving() {
        System.out.printf("Грузовик марки %s закончил движение\n", getBrand());
    }

    @Override
    public void pitStop() {
        System.out.printf("Водитель: %s из грузовика %s %s остановился на пит-стоп\n", getDriver().getFullname(), getBrand(), getModel());
    }

    @Override
    public double bestLapTime() {
        return LAP_DISTANCE / maxSpeed();
    }

    @Override
    public double maxSpeed() {
        return getEngineVolume() * 10; // Допустим объём двигателя будет показателем скорости :D
    }

    public Carrying getCarrying() {
        return carrying;
    }

    public void setCarrying(Carrying carrying) {
        this.carrying = carrying;
    }
}
