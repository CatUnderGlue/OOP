package collections.part1;

import collections.part1.drivers.BDriver;
import collections.part1.drivers.CDriver;
import collections.part1.drivers.DDriver;
import collections.part1.drivers.Driver;
import collections.part1.mechanics.BusMechanic;
import collections.part1.mechanics.CarMechanic;
import collections.part1.mechanics.Mechanic;
import collections.part1.mechanics.TruckMechanic;
import collections.part1.transports.Bus;
import collections.part1.transports.Car;
import collections.part1.transports.Transport;
import collections.part1.transports.Truck;

import java.util.ArrayList;
import java.util.List;

public class CheckInService {
    public static List<Driver<?>> drivers = new ArrayList<>(12);
    public static  List<Transport<?,?>> transports = new ArrayList<>(12);
    public static  List<Mechanic<?>> mechanics = new ArrayList<>(21);

    public static void driversInitialise(){
        for (int i = 1; i < 5; i++) {
            drivers.add(new BDriver("FIO" + i, true, 1.0 + i));
        }
        for (int i = 1; i < 5; i++) {
            drivers.add(new CDriver("FIO" + i, true, 1.0 + i));
        }
        for (int i = 1; i < 5; i++) {
            drivers.add(new DDriver("FIO" + i, true, 1.0 + i));
        }
    }
    public static void transportInitialise(){
        double count = 1;
        for (Driver<?> driver : drivers) {
            if (driver instanceof BDriver){
                transports.add(new Car("Brand " + count, "Model " + count, Math.random() * 100, (BDriver) driver, Car.BTypes.SEDAN));
            } else if (driver instanceof CDriver) {
                transports.add(new Truck("Brand " + count, "Model " + count, Math.random() * 100, (CDriver) driver, Truck.Carrying.N2));
            } else if (driver instanceof DDriver) {
                transports.add(new Bus("Brand " + count, "Model " + count, Math.random() * 100, (DDriver) driver, Bus.Capacity.MEDIUM));
            }
            count++;
        }
    }
    public static void mechanicsInitialise(){
        for (int i = 1; i < 7; i++) {
            mechanics.add(new CarMechanic("FIO" + i, "Pepega Service"));
        }
        for (int i = 1; i < 7; i++) {
            mechanics.add(new TruckMechanic("FIO" + i, "Cappa Service"));
        }
        for (int i = 1; i < 7; i++) {
            mechanics.add(new BusMechanic("FIO" + i, "BloodTrail Service"));
        }
    }

    public static void printAllTransportInfo(Transport<?,?>... transports) {
        for (Transport<?,?> transport : transports) {
            System.out.printf("Для %s %s %s\n", transport.getClass().getSimpleName(), transport.getBrand(),
                    transport.getModel());
            System.out.printf("Максимальная скорость: %.2f км/ч\nЛучший круг: %.2f сек\n\n", transport.maxSpeed(),
                    transport.bestLapTime());
        }
    }

    private static void printCheckinInformation(Transport<?,?>... transports) {
        for (Transport<?,?> transport : transports) {
            System.out.printf("Водитель: %s управляет автомобилем: %s %s %s и будет участвовать в заезде\n",
                    transport.getDriver().getFullname(), transport.getClass().getSimpleName(), transport.getBrand(),
                    transport.getModel());
        }
        System.out.println();
    }
}
