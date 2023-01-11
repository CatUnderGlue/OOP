package part4.drivers;

import java.util.Objects;

public abstract class Driver {
    private boolean busy = false;
    private final String fullname;
    private boolean driveLicense;
    private double driveExperience;

    public Driver(String fullname, boolean driveLicense, double driveExperience) {
        this.fullname = fullname;
        this.driveLicense = driveLicense;
        this.driveExperience = driveExperience;
    }

    public abstract void startMoving();

    public abstract void stopMoving();

    public abstract void refuelCar();

    public String getFullname() {
        return fullname;
    }

    public boolean isDriveLicense() {
        return driveLicense;
    }

    public void setDriveLicense(boolean driveLicense) {
        this.driveLicense = driveLicense;
    }

    public double getDriveExperience() {
        return driveExperience;
    }

    public void setDriveExperience(double driveExperience) {
        this.driveExperience = driveExperience;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return driveLicense == driver.driveLicense && Double.compare(driver.driveExperience, driveExperience) == 0 && Objects.equals(fullname, driver.fullname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullname, driveLicense, driveExperience);
    }

    @Override
    public String toString() {
        return fullname + " Наличие прав: " + (driveLicense ? "есть" : "нет") + " Стаж: " + driveExperience + " лет.";
    }
}
