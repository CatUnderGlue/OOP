package part4.transports;

import part4.Competing;
import part4.drivers.Driver;

import java.util.Objects;

public abstract class Transport<T extends Driver> implements Competing {
    private T driver;
    private String brand;
    private String model;
    private double engineVolume;

    public Transport(String brand, String model, double engineVolume, T driver) {
        setBrand(brand);
        setModel(model);
        setEngineVolume(engineVolume);
        setDriver(driver);
    }

    public void startMoving() {
        System.out.println("Начинает движение");
    }

    public void stopMoving() {
        System.out.println("Заканчивает движение");
    }

    @Override
    public abstract double bestLapTime();

    @Override
    public abstract double maxSpeed();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.isEmpty() || brand.isBlank()) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.isEmpty() || model.isBlank()) {
            this.model = "default";
        } else {
            this.model = model;
        }
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume <= 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public T getDriver() {
        return driver;
    }

    public void setDriver(T driver) {
        if (!driver.isBusy()) {
            driver.setBusy(true);
            if (this.driver != null) {
                this.driver.setBusy(false);
            }
            this.driver = driver;
        } else {
            throw new IllegalArgumentException("Данный водитель уже управляет другим авто");
        }
    }

    @Override
    public String toString() {
        return "Brand: " + getBrand() + "\n" +
                "Model: " + getModel() + "\n" +
                "Engine Volume: " + getEngineVolume() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Double.compare(transport.engineVolume, engineVolume) == 0 && Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume);
    }
}
