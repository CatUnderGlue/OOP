package collections.part1.drivers;

import collections.part1.transports.Car;

public class BDriver extends Driver<Car> {
    public BDriver(String fullname, boolean hasDriveLicense, double driveExperience) {
        super(fullname, hasDriveLicense, driveExperience);
    }

    @Override
    public void startMoving() {
        System.out.printf("Водитель категории B: %s начал движение\n", getFullname());
    }

    @Override
    public void stopMoving() {
        System.out.printf("Водитель категории B: %s закончил движение\n", getFullname());
    }

    @Override
    public void refuelCar() {
        System.out.printf("Водитель категории B: %s заправляет авто\n", getFullname());
    }
}
