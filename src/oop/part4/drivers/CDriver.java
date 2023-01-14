package oop.part4.drivers;

import oop.part4.transports.Truck;

public class CDriver extends Driver<Truck> {
    public CDriver(String fullname, boolean driveLicense, double driveExperience) {
        super(fullname, driveLicense, driveExperience);
    }

    @Override
    public void startMoving() {
        System.out.printf("Водитель категории C: %s начал движение\n", getFullname());
    }

    @Override
    public void stopMoving() {
        System.out.printf("Водитель категории C: %s закончил движение\n", getFullname());
    }

    @Override
    public void refuelCar() {
        System.out.printf("Водитель категории C: %s заправляет авто\n", getFullname());
    }
}
