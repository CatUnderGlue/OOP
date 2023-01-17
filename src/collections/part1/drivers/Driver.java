package collections.part1.drivers;

import collections.part1.transports.Transport;

import java.util.Objects;

public abstract class Driver<T extends Transport> {
    private T car;
    private final String fullname;
    private boolean hasDriveLicense;
    private double driveExperience;

    public Driver(String fullname, boolean hasDriveLicense, double driveExperience) {
        if (fullname == null || fullname.isEmpty() || fullname.isBlank()) {
            this.fullname = "default";
        } else {
            this.fullname = fullname;
        }

        this.hasDriveLicense = hasDriveLicense;

        if (driveExperience < 0) {
            this.driveExperience = 0;
        } else {
            this.driveExperience = driveExperience;
        }
    }

    public abstract void startMoving();

    public abstract void stopMoving();

    public abstract void refuelCar();

    public String getFullname() {
        return fullname;
    }

    public boolean isHasDriveLicense() {
        return hasDriveLicense;
    }

    public void setHasDriveLicense(boolean hasDriveLicense) {
        this.hasDriveLicense = hasDriveLicense;
    }

    public double getDriveExperience() {
        return driveExperience;
    }

    public void setDriveExperience(double driveExperience) {
        this.driveExperience = driveExperience;
    }

    public T getCar() {
        return car;
    }

    public void setCar(T car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver<?> driver = (Driver<?>) o;
        return hasDriveLicense == driver.hasDriveLicense && Double.compare(driver.driveExperience, driveExperience) == 0 && Objects.equals(fullname, driver.fullname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullname, hasDriveLicense, driveExperience);
    }

    @Override
    public String toString() {
        return fullname + " Наличие прав: " + (hasDriveLicense ? "есть" : "нет") + " Стаж: " + driveExperience + " лет.";
    }
}
