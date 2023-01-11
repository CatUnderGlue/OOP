package part4.transports;

import part4.drivers.DDriver;

public class Bus extends Transport<DDriver> {


    public Bus(String brand, String model, double engineVolume, DDriver driver) {
        super(brand, model, engineVolume, driver);
    }

    @Override
    public void pitStop() {
        System.out.printf("Водитель: %s из автомобиля %s %s остановился на пит-стоп\n", getDriver().getFullname(), getBrand(), getModel());
    }

    @Override
    public double bestLapTime() {
        return LAP_DISTANCE / maxSpeed();
    }

    @Override
    public double maxSpeed() {
        return getEngineVolume() * 10; // Допустим объём двигателя будет показателем скорости :D
    }
}