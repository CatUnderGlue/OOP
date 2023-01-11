package part4.drivers;

public class BDriver extends Driver {
    public BDriver(String fullname, boolean driveLicense, double driveExperience) {
        super(fullname, driveLicense, driveExperience);
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
