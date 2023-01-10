package part4.transports;

import part4.drivers.CDriver;

public class Truck<T extends CDriver> extends Transport {
    private T driver;

    public Truck(String brand, String model, double engineVolume, T driver) {
        super(brand, model, engineVolume);
        setDriver(driver);
    }

    @Override
    public void pitStop() {
        System.out.printf("Водитель: %s из автомобиля %s %s остановился на пит-стоп\n", driver.getFullname(), getBrand(), getModel());
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
}
