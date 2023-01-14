package enumlesson.drivers;

import enumlesson.transports.Bus;

public class DDriver extends Driver<Bus> {
    public DDriver(String fullname, boolean driveLicense, double driveExperience) {
        super(fullname, driveLicense, driveExperience);
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
