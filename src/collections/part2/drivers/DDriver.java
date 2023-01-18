package collections.part2.drivers;

import collections.part2.transports.Bus;

public class DDriver extends Driver<Bus> {
    public DDriver(String fullname, boolean hasDriveLicense, double driveExperience) {
        super(fullname, hasDriveLicense, driveExperience);
    }

    @Override
    public void startMoving() {
        System.out.printf("Водитель категории D: %s начал движение\n", getFullname());
    }

    @Override
    public void stopMoving() {
        System.out.printf("Водитель категории D: %s закончил движение\n", getFullname());
    }

    @Override
    public void refuelCar() {
        System.out.printf("Водитель категории D: %s заправляет авто\n", getFullname());
    }
}
