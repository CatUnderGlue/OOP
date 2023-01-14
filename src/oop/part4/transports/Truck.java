package oop.part4.transports;

import oop.part4.drivers.CDriver;

public class Truck extends Transport<CDriver> {

    public Truck(String brand, String model, double engineVolume, CDriver driver) {
        super(brand, model, engineVolume, driver);
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
}
