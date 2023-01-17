package collections.part1.transports;

import collections.part1.Competing;
import collections.part1.drivers.Driver;
import collections.part1.exceptions.CantFindLicense;
import collections.part1.mechanics.Mechanic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Transport<D extends Driver, M extends Mechanic> implements Competing {
    private static final int MAX_MECHANICS = 5;
    private D driver;
    private List<M> mechanics = new ArrayList<>();
    private String brand;
    private String model;
    private double engineVolume;

    public Transport(String brand, String model, double engineVolume, D driver) {
        setBrand(brand);
        setModel(model);
        setEngineVolume(engineVolume);
        setDriver(driver);
    }

    public abstract void passDiagnostic() throws CantFindLicense;

    public abstract void startMoving();

    public abstract void stopMoving();

    public abstract void printType();

    public void printInfo(){
        System.out.printf("Водитель: %s\nМеханики: %s\n", driver, getMechanics());
    }

    public void addMechanic(M mechanic){
        if (mechanics.contains(mechanic)){
            throw new IllegalArgumentException("Данный механик уже обслуживает эту машину!");
        }
        if (mechanics.size() < MAX_MECHANICS){
            mechanics.add(mechanic);
            mechanic.addTransport(this);
        } else {
            throw new RuntimeException("Эту машину обслуживает максимальное кол-во механиков!");
        }
    }

    public void removeMechanic(M mechanic){
        if (mechanics.contains(mechanic)){
            mechanics.remove(mechanic);
        } else {
            System.out.println("Данный механик не найден в обслуживающем персонале машины.");
        }
    }

    public List<M> getMechanics() {
        return mechanics;
    }

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

    public D getDriver() {
        return driver;
    }

    public void setDriver(D driver) {
        if (driver.getCar() == null) {
            driver.setCar(this);
            if (this.driver != null) {
                this.driver.setCar(null);
            }
            this.driver = driver;
        } else {
            throw new IllegalArgumentException("Данный водитель уже управляет другим авто");
        }
    }

    @Override
    public String toString() {
        return String.format("Brand: %s Model: %s Engine Volume: %.2f", getBrand(), getModel(), getEngineVolume());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport<?,?> transport = (Transport<?,?>) o;
        return Double.compare(transport.engineVolume, engineVolume) == 0 && Objects.equals(driver, transport.driver) && Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver, brand, model, engineVolume);
    }
}
