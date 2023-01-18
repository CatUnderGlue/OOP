package collections.part2.drivers;

import collections.part2.transports.Truck;

public class CDriver extends Driver<Truck> {
    public CDriver(String fullname, boolean hasDriveLicense, double driveExperience) {
        super(fullname, hasDriveLicense, driveExperience);
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
